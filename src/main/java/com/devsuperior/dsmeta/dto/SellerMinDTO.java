package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.entities.Seller;

import java.util.ArrayList;
import java.util.List;

public class SellerMinDTO {

    private String name;
    private Double total;

    private List<Sale> sales = new ArrayList<>();

    public SellerMinDTO(String name, Double total) {
        this.name = name;
        this.total = total;
    }

    public SellerMinDTO(Seller entity){
        name = entity.getName();
        for(Sale sale : sales){
            
        }
    }
}
