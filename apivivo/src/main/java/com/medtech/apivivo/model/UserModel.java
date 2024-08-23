package com.medtech.apivivo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TB_USER")
public class UserModel {
	
	private long idUser;
    private String phoneNumber;
    private String nameUser;

	List<ProductModel> product;
	
	public UserModel() {}


    public UserModel(long idUser, String phoneNumber, String nameUser) {
        this.idUser = idUser;
        this.phoneNumber = phoneNumber;
        this.nameUser = nameUser;
    }
	

	@Id
	@Column(name = "id")
	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

    @Column(name = "phone_number")
	@NotNull(message = "Número de telefone obrigatório")
	@Size(min = 11, max = 15, message = "Número deve ter entre 11 e 15 caracteres")
	@JsonIgnore
	public String getPhoneNumber() {
		return phoneNumber;
	}

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }


    @Column(name = "user_name")
	@NotNull(message = "Nome obrigatório")
	public String getNameUser() {
		return nameUser;
	}

    public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	@OneToMany(mappedBy = "user")
	public List<ProductModel> getProduct() {
		return product;
	}

	public void setProduct(List<ProductModel> product) {
		this.product = product;
	}
	
}
