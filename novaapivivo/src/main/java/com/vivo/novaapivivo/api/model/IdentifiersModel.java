package com.vivo.novaapivivo.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
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
        return idIndentifier;
    }

    public void setIdIndentifier(long idIndentifier) {
        this.idIndentifier = idIndentifier;
    }

    @Column(name = "identifier")
    @NotNull
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "product_id", nullable = false)
    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }
}
