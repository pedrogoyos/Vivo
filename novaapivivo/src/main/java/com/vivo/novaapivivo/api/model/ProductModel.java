package com.vivo.novaapivivo.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "TB_PRODUCT")
public class ProductModel {
    private String idProduct;
    private String typeProduct;
    private String nameProduct;
    private String subscriptionType;
    private String status;
    private Date startDate;
    private Date endDate;

    private User user;
    private ProductModel parentProduct;

    private List<TagsModel> tags;
    private List<DescriptionModel> descriptions;
    private List<PricesModel> prices;
    private List<IdentifiersModel> identifiers;
    private List<ProductModel> subproducts;

    public ProductModel() {}

    public ProductModel(String idProduct, String typeProduct, String nameProduct, String subscriptionType, String status, Date startDate, Date endDate) {
        this.idProduct = idProduct;
        this.typeProduct = typeProduct;
        this.nameProduct = nameProduct;
        this.subscriptionType = subscriptionType;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Id
    @Column(name = "id")
    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    @Column(name = "product_type")
    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    @Column(name = "product_name")
    @NotNull
    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    @Column(name = "subscription_type")
    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "user_id", nullable = true)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne()
    @JoinColumn(name="product_id")
    @JsonIgnore
    public ProductModel getParentProduct() {
        return parentProduct;
    }

    public void setParentProduct(ProductModel parentProduct) {
        this.parentProduct = parentProduct;
    }

    @OneToMany(mappedBy = "product")
    public List<TagsModel> getTags() {
        return tags;
    }

    public void setTags(List<TagsModel> tags) {
        this.tags = tags;
    }

    @OneToMany(mappedBy = "product")
    public List<DescriptionModel> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<DescriptionModel> descriptions) {
        this.descriptions = descriptions;
    }

    @OneToMany(mappedBy = "product")
    public List<PricesModel> getPrices() {
        return prices;
    }

    public void setPrices(List<PricesModel> prices) {
        this.prices = prices;
    }

    @OneToMany(mappedBy = "product")
    public List<IdentifiersModel> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(List<IdentifiersModel> identifiers) {
        this.identifiers = identifiers;
    }

    @OneToMany(mappedBy = "parentProduct")
    public List<ProductModel> getSubproducts() {
        return subproducts;
    }

    public void setSubproducts(List<ProductModel> subproducts) {
        this.subproducts = subproducts;
    }
}
