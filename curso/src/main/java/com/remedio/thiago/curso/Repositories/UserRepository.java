package com.remedio.thiago.curso.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.remedio.thiago.curso.User.User;


public interface UserRepository extends JpaRepository<User,Long>{
User findByLogin(String login);

}
