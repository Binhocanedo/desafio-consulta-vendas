package com.devsuperior.dsmeta.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class RelatorioDTO {
    @Id
    private Long id;
    private String name;
    private Double amount;
    private LocalDate date;

    public RelatorioDTO(){}

    public RelatorioDTO(Long id, String name, Double amount, LocalDate date) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.date = date;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
