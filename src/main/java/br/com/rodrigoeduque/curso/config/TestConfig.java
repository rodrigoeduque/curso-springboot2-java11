package br.com.rodrigoeduque.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.rodrigoeduque.curso.entities.Category;
import br.com.rodrigoeduque.curso.entities.Order;
import br.com.rodrigoeduque.curso.entities.Product;
import br.com.rodrigoeduque.curso.entities.User;
import br.com.rodrigoeduque.curso.entities.enums.OrderStatus;
import br.com.rodrigoeduque.curso.repositories.CategoryRepository;
import br.com.rodrigoeduque.curso.repositories.OrderRepository;
import br.com.rodrigoeduque.curso.repositories.ProductRepository;
import br.com.rodrigoeduque.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {

		User user1 = new User(null, "Maria Brown", "maria@gmail.com.br", "999998888", "123456");
		User user2 = new User(null, "Alex Green", "alex@gmail.com.br", "999887777", "123456");
		
//		userRepository.save(user1);
//		userRepository.save(user2);

		
		userRepository.saveAll(Arrays.asList(user1,user2));
		
		Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.CANCELED, user1);
		Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.DELIVERED, user2);
		Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED,user1);
		
		orderRepository.saveAll(Arrays.asList(order1,order2,order3));
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers"); 

		categoryRepository.saveAll(Arrays.asList(cat1,cat2, cat3));
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
	}
}