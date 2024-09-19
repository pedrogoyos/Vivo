package com.medtech.apivivo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_TAGS")
public class TagsModel {
    
    private long idTag;
    private String tag;

    private ProductModel product;

    public TagsModel(){}

    public TagsModel(long idTag, String tag) {
        this.idTag = idTag;
        this.tag = tag;
    }

    @Id
    @Column(name = "id")
    public long getIdTag() {
        return this.idTag;
    }

    public void setIdTag(long idTag) {
        this.idTag = idTag;
    }


    @Column(name = "text")
    @NotNull
    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @ManyToOne(optional = false,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "product_id", nullable = false)
    public ProductModel getProduct() {
        return this.product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }


}
