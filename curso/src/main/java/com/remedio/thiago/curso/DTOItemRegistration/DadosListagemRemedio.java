package com.remedio.thiago.curso.DTOItemRegistration;

import java.time.LocalDate;

import com.remedio.thiago.curso.remedio.Laboratorio;
import com.remedio.thiago.curso.remedio.Remedio;
import com.remedio.thiago.curso.remedio.Via;

public record DadosListagemRemedio(
    Long id,
    String nome, 
    Via via, 
    String Lote, 
    Laboratorio laboratorio, 
    LocalDate validade) {

    public DadosListagemRemedio(Remedio remedio){
        this(remedio.getId(),
        remedio.getNome(), 
        remedio. getVia(), 
        remedio.getLote(), 
        remedio.getLaboratorio(), 
        remedio.getValidade()); 
    }

}
