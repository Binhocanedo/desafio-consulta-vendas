package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.entities.Seller;

import java.util.HashMap;
import java.util.Map;

public class SellerDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;

    private Map<Long, SaleDTO> sales = new HashMap<>();

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
            sales.put(entity.getId(), new SaleDTO(sale));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Map<Long, SaleDTO> getSales() {
        return sales;
    }

    public void setSales(Map<Long, SaleDTO> sales) {
        this.sales = sales;
    }
}
