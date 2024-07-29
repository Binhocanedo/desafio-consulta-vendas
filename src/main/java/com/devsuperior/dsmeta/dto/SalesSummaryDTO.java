package com.devsuperior.dsmeta.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SalesSummaryDTO {

    @Id
    @JsonIgnore
    private Long id;
    private String sellerName;
    private Double totalSales;

    public SalesSummaryDTO(){}

    public SalesSummaryDTO(String sellerName, Double totalSales) {
        this.sellerName = sellerName;
        this.totalSales = totalSales;
    }

    public String getSellerName() {
        return sellerName;
    }

    public Double getTotalSales() {
        return totalSales;
    }
}