package com.remedio.thiago.curso.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remedio.thiago.curso.remedio.DadosCadastroRemedio;
import com.remedio.thiago.curso.remedio.Remedio;
import com.remedio.thiago.curso.remedio.RemedioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
    private RemedioRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroRemedio dados){
        repository.save(new Remedio(dados));

    }
}
