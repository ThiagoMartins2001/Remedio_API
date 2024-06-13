package com.remedio.thiago.curso.remedio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RemedioRepository extends JpaRepository<Remedio, Long>{

    List<Remedio> findAllByAtivoTrue();

}
