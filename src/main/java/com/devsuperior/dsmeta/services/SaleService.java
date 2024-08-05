package com.devsuperior.dsmeta.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.devsuperior.dsmeta.dto.SalesSummaryDTO;
import com.devsuperior.dsmeta.dto.ResponseReportDTO;
import com.devsuperior.dsmeta.dto.SellerPerSaleDTO;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.util.ObjectUtils;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	public List<SalesSummaryDTO> getSalesSummary(String minDate, String maxDate){

		LocalDate endDate = maxDate != null ? LocalDate.parse(maxDate) : LocalDate.now();
		LocalDate startDate = minDate != null ? LocalDate.parse(minDate) : endDate.minusYears(1L);

		return repository.findSalesSummary(startDate, endDate);
	}

	public ResponseReportDTO getReportSellers(String name, String minDate, String maxDate){

		LocalDate endDate;
		LocalDate startDate;
		String nameFilter = (name != null && !name.isEmpty()) ? name : "";
		boolean noParams = (minDate == null || minDate.isEmpty()) && (maxDate == null || nameFilter.isEmpty());

		if (noParams) {
			endDate = LocalDate.now();
			startDate = endDate.minusYears(1L);
		} else {
			endDate = (maxDate != null && !maxDate.isEmpty()) ? LocalDate.parse(maxDate) : LocalDate.now();
			startDate = (minDate != null && !minDate.isEmpty()) ? LocalDate.parse(minDate) : endDate.minusYears(1L);
		}

		List<SellerPerSaleDTO> report = repository.findReport(nameFilter, startDate, endDate);
		ResponseReportDTO response = new ResponseReportDTO();
		response.setContent(report);
		return response;
	}
}