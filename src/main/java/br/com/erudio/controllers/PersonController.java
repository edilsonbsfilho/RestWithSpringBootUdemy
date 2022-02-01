package br.com.erudio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.model.Person;
import br.com.erudio.services.PersonService;

/**
 * 
 * @author Edilson
 *
 */
@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService  personService;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	//@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping("/{id}")
	public Person findById(@PathVariable("id") Long id) {
		return personService.findById(id);
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping
	public List<Person> findAll() {
		return personService.findAll();
	}
	
	/**
	 * 
	 * @param person
	 * @return
	 */
	//@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping
	public Person create(@RequestBody Person person) {
		return personService.create(person);
	}
	
	/**
	 * 
	 * @param person
	 * @return
	 */
	@PutMapping
	public Person update(@RequestBody Person person) {
		return personService.update(person);
	}
	
	/**
	 * 
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		personService.delete(id);
	}
}
