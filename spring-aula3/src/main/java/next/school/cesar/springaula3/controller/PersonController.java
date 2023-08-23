package next.school.cesar.springaula3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import next.school.cesar.springaula3.entity.Person;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@GetMapping("/") 
	/*
	 * define o método de requisição e também a sub-rota do recurso
	 * neste caso, o método de requisição é o método GET
	 */
	public Person getPerson(@RequestParam(value = "name", defaultValue = "Oliveira") String name) {
		//lógica de negócio	
		return new Person(name, "04/02/1997");
	}
	
	@PostMapping("/")
	public Person postPerson() {
		return new Person();
	}
	
	
	
}
