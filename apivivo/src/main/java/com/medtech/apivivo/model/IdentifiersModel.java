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
@Table(name = "TB_IDENTIFIERS")
public class IdentifiersModel {
    
    private long idIndentifier;
    private String identifier;
    private ProductModel product;

    public IdentifiersModel(){}

    public IdentifiersModel(long idIndentifier, String identifier) {
        this.idIndentifier = idIndentifier;
        this.identifier = identifier;
    }

    @Id
    @Column(name = "id")
    @JsonIgnore
    public long getIdIndentifier() {
        return this.idIndentifier;
    }

    public void setIdIndentifier(long idIndentifier) {
        this.idIndentifier = idIndentifier;
    }


    @Column(name = "identifier")
    @NotNull
    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
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
