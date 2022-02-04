package br.com.erudio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;
import br.com.erudio.vo.PersonVO;

/**
 * 
 * @author Edilson
 *
 */
@Service
public class PersonService {
	
	private static final String MSG_NENHUMA_PESSOA_ENCONTRADA_PARA_O_ID_INFORMADO = "Nenhuma pessoa encontrada para o ID informado.";
	
	@Autowired
	PersonRepository repo;
	
	/**
	 * 
	 * @param person
	 * @return
	 */
	public PersonVO create(PersonVO personVO) {
		Person person = repo.save(DozerConverter.parseObject(personVO, Person.class));
		return DozerConverter.parseObject(person, PersonVO.class);
	}
	
	/**
	 * 
	 * @param person
	 * @return
	 */
	public PersonVO update(PersonVO personVO) {
		Person entity = repo.findById(personVO.getKey())
				.orElseThrow(() -> new ResourceNotFoundException(MSG_NENHUMA_PESSOA_ENCONTRADA_PARA_O_ID_INFORMADO));
		
		entity.setFirstName(personVO.getFirstName());
		entity.setLastName(personVO.getLastName());
		entity.setAddress(personVO.getAddress());
		entity.setGender(personVO.getGender());
		
		return DozerConverter.parseObject(
				repo.saveAndFlush(entity), PersonVO.class);
	}
	
	/**
	 * 
	 * @param id
	 */
	public void delete(Long id) {
		Person person = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(MSG_NENHUMA_PESSOA_ENCONTRADA_PARA_O_ID_INFORMADO));
		
		repo.delete(person);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public PersonVO findById(Long id) {
		Person person = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(MSG_NENHUMA_PESSOA_ENCONTRADA_PARA_O_ID_INFORMADO));
		return DozerConverter.parseObject(person, PersonVO.class);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<PersonVO> findAll() {
		return DozerConverter.parseListObjects(
				repo.findAll(), PersonVO.class);
	}
}
