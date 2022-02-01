package br.com.erudio.services;

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
	 * @param id
	 * @return
	 */
	public Person findById(String id) {
		Person person = new Person(
				counter.incrementAndGet(), 
				"Joao", 
				"Silva", 
				"Endereço", 
				"Masculino");
		return person;
	}
}
