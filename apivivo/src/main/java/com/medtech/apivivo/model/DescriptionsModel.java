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
@Table(name = "TB_DESCRIPTIONS")
public class DescriptionsModel {
    private long idDescription;
    private String text;
    private String urlDescription;
    private String category;

    private ProductModel product;


    public DescriptionsModel(){}


    public DescriptionsModel(Long idDescription, String text, String urlDescription, String category) {
        this.idDescription = idDescription;
        this.text = text;
        this.urlDescription = urlDescription;
        this.category = category;
    }
    
    @Id
    @Column(name = "id")
    public long getIdDescription() {
        return this.idDescription;
    }

    public void setIdDescription(long idDescription) {
        this.idDescription = idDescription;
    }

    @Column(name = "text")
    @NotNull
    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrlDescription() {
        return this.urlDescription;
    }

    public void setUrlDescription(String urlDescription) {
        this.urlDescription = urlDescription;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "product_id", nullable = true)
    public ProductModel getProduct() {
        return this.product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

}
