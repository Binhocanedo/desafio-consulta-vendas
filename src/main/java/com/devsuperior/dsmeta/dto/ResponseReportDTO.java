package com.devsuperior.dsmeta.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ResponseReportDTO {
    @Id
    @JsonIgnore
    private Long id;
    private List<SellerPerSaleDTO> content = new ArrayList<>();

    public ResponseReportDTO(){}

    public List<SellerPerSaleDTO> getContent() {
        return content;
    }
}