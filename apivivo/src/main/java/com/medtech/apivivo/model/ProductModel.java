package com.medtech.apivivo.model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

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

	private UserModel user;
	private ProductModel parentProduct;

	private List<TagsModel> tags;
	private List<DescriptionsModel> descriptions;
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

	@Column(name = "subscription_type")
	public String getSubscriptionType() {
		return this.subscriptionType;
	}

	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	@Column(name = "status")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "start_date")
	@PastOrPresent
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "end_date")
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

    @Column(name = "product_type")
	public String getTypeProduct() {
		return typeProduct;
	}

    public void setTypeProduct(String typeProduct){
        this.typeProduct = typeProduct;
    }


    @Column(name = "product_name")
	@NotNull(message = "Nome obrigatório")
	public String getNameProduct() {
		return nameProduct;
	}

    public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	@OneToMany(mappedBy = "product")
	public List<TagsModel> getTags() {
		return tags;
	}

	public void setTags(List<TagsModel> tags) {
		this.tags = tags;
	}
	
	@OneToMany(mappedBy = "product")
	public List<DescriptionsModel> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(List<DescriptionsModel> descriptions) {
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
	
	@ManyToOne()
	@JoinColumn(name="product_id")
	@JsonIgnore
	public ProductModel getParentProduct() {
        return this.parentProduct;
    }

	public void setParentProduct(ProductModel parentProduct) {
        this.parentProduct = parentProduct;
    }

	@OneToMany(mappedBy = "parentProduct")
	public List<ProductModel> getSubproducts() {
		return this.subproducts;
	}

	public void setSubproducts(List<ProductModel> subproducts) {
        this.subproducts = subproducts;
    }



	@ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "user_id", nullable = true)
    public UserModel getUser() {
        return this.user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

}
