package br.com.rodrigoeduque.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rodrigoeduque.curso.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
