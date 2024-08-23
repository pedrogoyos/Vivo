package com.medtech.apivivo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_PRICES")
public class PricesModel {
    
    private long idPrices;
    private String description;
    private String type;
    private String recurringPeriod;
    private float amount;

    private ProductModel product;

    public PricesModel(){}


    public PricesModel(long idPrices, String description, String type, String recurringPeriod, float amount) {
        this.idPrices = idPrices;
        this.description = description;
        this.type = type;
        this.recurringPeriod = recurringPeriod;
        this.amount = amount;
    }


    @Id
    @Column(name = "id")
    public long getIdPrices() {
        return this.idPrices;
    }

    public void setIdPrices(long idPrices) {
        this.idPrices = idPrices;
    }

    @Column(name = "description")
    @NotNull
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "type")
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "recurring_period")
    public String getRecurringPeriod() {
        return this.recurringPeriod;
    }

    public void setRecurringPeriod(String recurringPeriod) {
        this.recurringPeriod = recurringPeriod;
    }

    @Column(name = "amount")
    public float getAmount() {
        return this.amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }


    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "product_id", nullable = false)
    public ProductModel getProduct() {
        return this.product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }


}
