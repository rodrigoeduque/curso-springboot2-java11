package br.com.rodrigoeduque.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rodrigoeduque.curso.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
