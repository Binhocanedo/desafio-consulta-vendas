package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.ResponseReportDTO;
import com.devsuperior.dsmeta.dto.SalesSummaryDTO;
import com.devsuperior.dsmeta.dto.SellerPerSaleDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(value = "SELECT new SalesSummaryDTO(s.name, SUM(sa.amount)) " +
            "FROM Sale sa " +
            "JOIN sa.seller s " +
            "WHERE sa.date BETWEEN :minDate AND :maxDate " +
            "GROUP BY s.name ")
    List<SalesSummaryDTO> findSalesSummary(@Param("minDate")LocalDate minDate, @Param("maxDate") LocalDate maxDate);

    @Query(value = "SELECT new SellerPerSaleDTO(s.id, sa.date, SUM(sa.amount), s.name, s.email, s.phone) " +
            "FROM Sale sa " +
            "JOIN sa.seller s " +
            "WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%')) AND sa.date BETWEEN :minDate AND :maxDate " +
            "GROUP BY s.name, sa.date ")
    List<SellerPerSaleDTO> findReport(@Param("name") String sellerName, @Param("minDate") LocalDate minDate, @Param("maxDate") LocalDate maxDate);
}
