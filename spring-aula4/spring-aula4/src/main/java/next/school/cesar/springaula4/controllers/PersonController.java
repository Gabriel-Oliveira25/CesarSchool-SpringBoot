package next.school.cesar.springaula4.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import next.school.cesar.springaula4.entities.Person;

@RestController
@RequestMapping("/person")
public class PersonController {

	ArrayList<Person> listPerson = new ArrayList<Person>();
	
	
	@GetMapping
	public ResponseEntity<List<Person>> getPerson() {
		if (listPerson == null || listPerson.isEmpty()) {
			return new ResponseEntity<List<Person>>(this.listPerson, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Person>>(this.listPerson, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Person> create(@RequestBody Person person) {
		listPerson.add(person);
		return new ResponseEntity<Person>(person, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Person> update(@RequestBody Person person, @PathVariable (value = "id") int id){
		
		for (int i = 0; i<listPerson.size(); i++) {
			if (listPerson.get(i).getId() == id) {
				listPerson.get(i).setName(person.getName());
				listPerson.get(i).setAge(person.getAge());
				return new ResponseEntity<Person>(listPerson.get(i), HttpStatus.OK);
			}
		}
	
		return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") int id){
		for (int i = 0; i<listPerson.size(); i++) {
			if (listPerson.get(i).getId() == id) {
				this.listPerson.remove(this.listPerson.get(i));
				   return new ResponseEntity<>(HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
