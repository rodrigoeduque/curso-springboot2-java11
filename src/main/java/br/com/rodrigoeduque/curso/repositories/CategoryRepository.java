package br.com.rodrigoeduque.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rodrigoeduque.curso.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
