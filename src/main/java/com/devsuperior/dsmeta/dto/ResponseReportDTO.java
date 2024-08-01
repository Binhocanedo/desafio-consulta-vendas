package com.devsuperior.dsmeta.dto;


import java.util.ArrayList;
import java.util.List;

public class ResponseReportDTO {

    private List<SellerPerSaleDTO> content = new ArrayList<>();

    public ResponseReportDTO(){}

    public List<SellerPerSaleDTO> getContent() {
        return content;
    }

    public void setContent(List<SellerPerSaleDTO> content) {
        this.content = content;
    }
}