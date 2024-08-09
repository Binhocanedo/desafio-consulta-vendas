package com.devsuperior.dsmeta.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class SellerPerSaleDTO {
    @Id
    private Long id;
    private LocalDate date;
    private Double amount;
    private String sellerName;
    private String email;
    private String phone;

    public SellerPerSaleDTO(){}
    public SellerPerSaleDTO(Long id, LocalDate date, Double amount, String sellerName, String email, String phone) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.sellerName = sellerName;
        this.email = email;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }

    public String getSellerName() {
        return sellerName;
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
}
