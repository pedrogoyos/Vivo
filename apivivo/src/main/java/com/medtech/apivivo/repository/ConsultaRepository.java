// package com.medtech.apivivo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.stereotype.Repository;


// @Repository
// public interface ConsultaRepository extends JpaRepository<UserModel, Long> {
//     @Query(nativeQuery = true, value = "INSERT INTO TB_CONSULTA SELECT * FROM TB_CONSULTA_NOVA WHERE TB_CONSULTA_NOVA.ID_CONSULTA = ?1")
//     ConsultaModel saveConsultaById (String id);
// }
