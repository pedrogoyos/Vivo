package com.medtech.apivivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medtech.apivivo.model.IdentifiersModel;


@Repository
public interface IdentifiersRepository extends JpaRepository<IdentifiersModel, Long> {
   
}
