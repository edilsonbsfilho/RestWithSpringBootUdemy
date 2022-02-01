package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

/**
 * 
 * @author Edilson
 *
 */
@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	
	/**
	 * 
	 * @param person
	 * @return
	 */
	public Person create(Person person) {
		return person;
	}
	
	/**
	 * 
	 * @param person
	 * @return
	 */
	public Person update(Person person) {
		return person;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void delete(String id) {
		
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Person findById(String id) {
		Person person = mockPerson();
		return person;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Person> findAll() {
		
		List<Person> personList = new ArrayList<>();
		
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson();
			
			personList.add(person);
		}
		
		
		return personList;
	}
	
	private Person mockPerson() {
		Person person = new Person(
				counter.incrementAndGet(), 
				"Joao" + counter.get(), 
				"Silva", 
				"Endereço", 
				"Masculino");
		return person;
	}
}
