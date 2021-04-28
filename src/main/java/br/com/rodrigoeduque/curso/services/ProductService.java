package br.com.rodrigoeduque.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rodrigoeduque.curso.entities.Product;
import br.com.rodrigoeduque.curso.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public List<Product> findAll() {
		return repository.findAll();
		}

	public Product findbyId(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	
	public Product insert(Product obj) {
		return repository.save(obj);
	}
}
