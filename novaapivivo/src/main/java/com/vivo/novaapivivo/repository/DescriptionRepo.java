package com.vivo.novaapivivo.repository;

import com.vivo.novaapivivo.api.model.DescriptionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionRepo extends JpaRepository<DescriptionModel, Long> {
}
