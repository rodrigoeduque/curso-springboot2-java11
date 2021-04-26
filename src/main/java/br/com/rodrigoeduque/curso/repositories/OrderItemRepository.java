package br.com.rodrigoeduque.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rodrigoeduque.curso.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
