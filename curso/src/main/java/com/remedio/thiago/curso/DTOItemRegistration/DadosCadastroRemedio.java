package com.remedio.thiago.curso.DTOItemRegistration;

import java.time.LocalDate;

import com.remedio.thiago.curso.remedio.Laboratorio;
import com.remedio.thiago.curso.remedio.Via;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroRemedio(

        @NotBlank
        String nome,
        @Enumerated
        Via via,
        @NotBlank
        String lote,
        int quantidade,
        @Future
        LocalDate validade,
        @Enumerated
        Laboratorio laboratorio) {

}
