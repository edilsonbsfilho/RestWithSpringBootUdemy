package br.com.erudio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;

/**
 * 
 * @author Edilson
 *
 */
@Service
public class PersonService {
	
	@Autowired
	PersonRepository repo;
	
	/**
	 * 
	 * @param person
	 * @return
	 */
	public Person create(Person person) {
		return repo.save(person);
	}
	
	/**
	 * 
	 * @param person
	 * @return
	 */
	public Person update(Person person) {
		Person entity = repo.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Nenhuma pessoa encontrada para o ID informado."));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repo.saveAndFlush(entity);
	}
	
	/**
	 * 
	 * @param id
	 */
	public void delete(Long id) {
		Person person = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhuma pessoa encontrada para o ID informado."));
		
		repo.delete(person);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Person findById(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhuma pessoa encontrada para o ID informado."));
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Person> findAll() {
		return repo.findAll();
	}
}
