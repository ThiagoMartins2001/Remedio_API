package com.remedio.thiago.curso.DTOItemRegistration;

import java.time.LocalDate;

import com.remedio.thiago.curso.remedio.Laboratorio;
import com.remedio.thiago.curso.remedio.Remedio;
import com.remedio.thiago.curso.remedio.Via;

public record DadosDetalhamentoRemedio(
    Long id, 
    String nome, 
    Via via, 
    String lote, 
    int quantidade, 
    LocalDate validade, 
    Laboratorio laboratorio, 
    Boolean ativo) {

        public DadosDetalhamentoRemedio (Remedio remedio) {
            this(
                remedio.getId(), 
                remedio.getNome(), 
                remedio.getVia(), 
                remedio.getLote(), 
                remedio.getQuantidade(), 
                remedio.getValidade(), 
                remedio.getLaboratorio(), 
                remedio.getAtivo());
        }
}
