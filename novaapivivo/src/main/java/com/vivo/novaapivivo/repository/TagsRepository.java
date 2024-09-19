package com.vivo.novaapivivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vivo.novaapivivo.api.model.TagsModel;


@Repository
public interface TagsRepository extends JpaRepository<TagsModel, Long> {
   
}
