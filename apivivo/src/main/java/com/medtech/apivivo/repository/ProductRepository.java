package com.medtech.apivivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medtech.apivivo.model.ProductModel;


@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
   
}
