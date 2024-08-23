package com.medtech.apivivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medtech.apivivo.model.PricesModel;


@Repository
public interface PricesRepository extends JpaRepository<PricesModel, Long> {
   
}
