package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.entities.Seller;

import java.util.ArrayList;
import java.util.List;

public class SellerDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;

    private List<SaleDTO> sales = new ArrayList<>();

    public SellerDTO(){}

    public SellerDTO(Long id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    public SellerDTO(Seller entity){
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        phone = entity.getPhone();
        for(Sale sale : entity.getSales()){
            sales.add(new SaleDTO(sale));
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public List<SaleDTO> getSales() {
        return sales;
    }
}
