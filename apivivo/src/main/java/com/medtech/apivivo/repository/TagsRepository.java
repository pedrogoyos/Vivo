package com.medtech.apivivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medtech.apivivo.model.TagsModel;


@Repository
public interface TagsRepository extends JpaRepository<TagsModel, Long> {
   
}
