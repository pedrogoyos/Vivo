package com.medtech.apivivo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.medtech.apivivo.model.UserModel;
import com.medtech.apivivo.repository.UserRepository;


@RestController
public class UserController {

    // Lembrando que Autowired só funciona com classes BEANS Java! Exemplo: Classes
    // com anotação @Service, @Beans, etc
    @Autowired
	public UserRepository userRepository;

    // Get - Trazer, Post - Cadastrar, Put - Editar, Patch - Editar, Delete - Deletar
    @GetMapping(value = "/users/{id}/products/{wait}")
    @Operation(summary = "Retorna os produtos contratados de um cliente")
    @ApiResponse(
            responseCode = "200",
            description = "Sucesso"
    )
    public ResponseEntity<UserModel> findById(@PathVariable("id") long id, @PathVariable("wait") long wait) {
    
            try {
                Thread.sleep(wait*1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return new ResponseEntity(userRepository.findById(id).get(), HttpStatus.OK);
    }


}