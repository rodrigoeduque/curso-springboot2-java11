package br.com.rodrigoeduque.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.rodrigoeduque.curso.entities.Order;
import br.com.rodrigoeduque.curso.entities.User;
import br.com.rodrigoeduque.curso.entities.enums.OrderStatus;
import br.com.rodrigoeduque.curso.repositories.OrderRepository;
import br.com.rodrigoeduque.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;

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
	}
}