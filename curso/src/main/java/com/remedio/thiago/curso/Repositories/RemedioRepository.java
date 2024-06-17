package com.remedio.thiago.curso.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.remedio.thiago.curso.remedio.Remedio;

public interface RemedioRepository extends JpaRepository<Remedio, Long>{

    List<Remedio> findAllByAtivoTrue();

}
