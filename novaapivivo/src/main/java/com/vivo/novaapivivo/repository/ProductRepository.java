package com.vivo.novaapivivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vivo.novaapivivo.api.model.ProductModel;


@Repository
public interface ProductRepository extends JpaRepository<ProductModel, String> {
   
}
