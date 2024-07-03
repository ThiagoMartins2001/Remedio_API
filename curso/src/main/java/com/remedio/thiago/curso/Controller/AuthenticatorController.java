package com.remedio.thiago.curso.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remedio.thiago.curso.DTOAuthenticator.DadosAuthenticator;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AuthenticatorController {

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAuthenticator dados){
        var token =  new UsernamePasswordAuthenticationToken(dados. login(), dados.senha());
        var authentication = manager.authenticate(token);
        return ResponseEntity.ok().build();

    }

}