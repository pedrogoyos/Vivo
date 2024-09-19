package com.vivo.novaapivivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vivo.novaapivivo.api.model.PricesModel;


@Repository
public interface PricesRepository extends JpaRepository<PricesModel, Long> {
   
}
