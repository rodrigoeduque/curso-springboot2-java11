package br.com.rodrigoeduque.curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodrigoeduque.curso.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAEntity() {
		User u = new User(1L, "Maria", "maria@gmail.com", "99999999-999", "12345");

		return ResponseEntity.ok().body(u);
	}

}
