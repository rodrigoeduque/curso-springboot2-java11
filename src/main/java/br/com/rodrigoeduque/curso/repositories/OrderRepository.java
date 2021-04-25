package br.com.rodrigoeduque.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rodrigoeduque.curso.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
