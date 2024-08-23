package com.medtech.apivivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medtech.apivivo.model.DescriptionsModel;


@Repository
public interface DescriptionsRepository extends JpaRepository<DescriptionsModel, Long> {
   
}
