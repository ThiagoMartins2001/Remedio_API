package com.remedio.thiago.curso.DTOItemRegistration;

import com.remedio.thiago.curso.remedio.Laboratorio;
import com.remedio.thiago.curso.remedio.Via;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarRemedio(
    @NotNull
    Long id,
    String nome, 
    Via via, 
    Laboratorio laboratorio) {

}
