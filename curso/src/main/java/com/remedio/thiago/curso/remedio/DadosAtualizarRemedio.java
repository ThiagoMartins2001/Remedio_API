package com.remedio.thiago.curso.remedio;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarRemedio(
    @NotNull
    Long id,
    String nome, 
    Via via, 
    Laboratorio laboratorio) {

}
