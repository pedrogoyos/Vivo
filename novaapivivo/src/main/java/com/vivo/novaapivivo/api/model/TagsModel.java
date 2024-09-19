package com.vivo.novaapivivo.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
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
        return idTag;
    }

    public void setIdTag(long idTag) {
        this.idTag = idTag;
    }

    @Column(name = "text")
    @NotNull
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "product_id", nullable = true)
    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }
}
