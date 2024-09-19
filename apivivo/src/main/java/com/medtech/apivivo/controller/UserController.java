package com.medtech.apivivo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Random;

import com.medtech.apivivo.model.UserModel;
import com.medtech.apivivo.repository.UserRepository;


@RestController
public class UserController {

    // Lembrando que Autowired só funciona com classes BEANS Java! Exemplo: Classes
    // com anotação @Service, @Beans, etc
    @Autowired
	public UserRepository userRepository;
    private UserModel User;

    // Get - Trazer, Post - Cadastrar, Put - Editar, Patch - Editar, Delete - Deletar
    @GetMapping(value = "/users/{id}/products/{wait}")
    @Operation(summary = "Retorna os produtos contratados de um cliente com um delay programavel")
    @ApiResponse(
            responseCode = "200",
            description = "Sucesso"
    )
    public ResponseEntity<UserModel> findByIdSetDelay(@PathVariable("id") long id, @PathVariable("wait") long wait) {
    
            try {
                Thread.sleep(wait*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new ResponseEntity(userRepository.findById(id).get(), HttpStatus.OK);
    }


    @GetMapping(value = "/users/{id}/products/random-response-time")
    @Operation(summary = "Retorna os produtos contratados de um cliente com um delay aleatório")
    @ApiResponse(
            responseCode = "200",
            description = "Sucesso"
    )
    public ResponseEntity<UserModel> findByIdRandomDelay(@PathVariable("id") long id) {
    
        int wait = new Random().nextInt(15)+1;
            try {
                Thread.sleep(wait*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new ResponseEntity(userRepository.findById(id).get(), HttpStatus.OK);
    }
    
    // Get - Trazer, Post - Cadastrar, Put - Editar, Patch - Editar, Delete - Deletar
    @GetMapping(value = "/users/{id}/products")
    @Operation(summary = "Retorna os produtos contratados de um cliente com um delay programavel")
    @ApiResponse(
            responseCode = "200",
            description = "Sucesso"
    )
    public ResponseEntity<UserModel> findById(@PathVariable("id") long id) {
    
            return new ResponseEntity(userRepository.findById(id).get(), HttpStatus.OK);
    }
    
    @PutMapping(value = "/users/{id}/products")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody @Validated UserModel user ){
        UserModel currentUser = user;
        currentUser.setIdUser(id);
        userRepository.save(currentUser);
        return ResponseEntity.ok().build();
    }



}