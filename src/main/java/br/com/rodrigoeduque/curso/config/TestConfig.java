package br.com.rodrigoeduque.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.rodrigoeduque.curso.entities.User;
import br.com.rodrigoeduque.curso.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User user1 = new User(null, "Maria Brown", "maria@gmail.com.br", "999998888", "123456");
		User user2 = new User(null, "Alex Green", "alex@gmail.com.br", "999887777", "123456");
		
//		userRepository.save(user1);
//		userRepository.save(user2);

		
		userRepository.saveAll(Arrays.asList(user1,user2));
	}
}
