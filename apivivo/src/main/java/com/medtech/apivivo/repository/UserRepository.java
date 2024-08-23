package com.medtech.apivivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medtech.apivivo.model.UserModel;


@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
   
}
