package com.vivo.novaapivivo.api.controller;

import com.vivo.novaapivivo.api.model.User;
import com.vivo.novaapivivo.repository.UserRepo;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;
import java.util.concurrent.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@RestController
public class UserController {

    @Autowired
    public UserRepo repo;
    private com.vivo.novaapivivo.api.model.User User;

    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(10000);
        factory.setConnectTimeout(10000);
        return factory;
    }

    RestClient restClient = RestClient
            .builder()
            .requestFactory(getClientHttpRequestFactory())
            .build();

    @GetMapping(value = "/users/{id}/products/{wait}")
    @Operation(summary = "Retorna os produtos contratados de um cliente chamando primeiro a api antiga, e depois puxando do banco de dados novo em caso de timeout")
    @ApiResponse(responseCode = "200", description = "Sucesso")
    public ResponseEntity<User> findById(@PathVariable("id") long id, @PathVariable("wait") long wait) {

        ResponseEntity<User> result = null;

        try {
            result = restClient.get()
                    .uri("http://localhost:8080/users/{id}/products/{wait}", id, wait)
                    .accept(APPLICATION_JSON)
                    .retrieve()
                    .toEntity(User.class);
        } catch (Exception e) {
            return new ResponseEntity<User>(repo.findById(id).get(), HttpStatus.OK);
        }
        User user = result.getBody();

        repo.save(user);

        return result;

    }

    @Async
    public CompletableFuture<ResponseEntity<User>> asyncGetData() throws InterruptedException {

    }

    @PutMapping(value = "/users/{id}/products")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody @Validated User user ){
        User currentUser = User;
        currentUser.setIdUser(id);
        repo.save(currentUser);
        return ResponseEntity.ok().build();
    }
}
