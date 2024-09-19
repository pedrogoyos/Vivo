package com.vivo.novaapivivo.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@Entity
@Table(name = "TB_DESCRIPTIONS")
public class DescriptionModel {
    private long idDescription;
    private String text;
    private String urlDescription;
    private String category;

    private ProductModel product;

    public DescriptionModel(){}

    public DescriptionModel(long idDescription, String text, String urlDescription, String category) {
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

    public String getText() {
        return text;
    }

    @Column(name = "text")
    @NotNull
    public void setText(String text) {
        this.text = text;
    }

    public String getUrlDescription() {
        return urlDescription;
    }

    public void setUrlDescription(String urlDescription) {
        this.urlDescription = urlDescription;
    }

    public String getCategory() {
        return category;
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
