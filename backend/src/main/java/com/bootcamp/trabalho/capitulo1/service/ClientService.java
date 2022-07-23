package com.bootcamp.trabalho.capitulo1.service;



import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.trabalho.capitulo1.dto.ClientDTO;
import com.bootcamp.trabalho.capitulo1.entities.ClientEntity;
import com.bootcamp.trabalho.capitulo1.repository.ClientRepository;
import com.bootcamp.trabalho.capitulo1.service.exceptions.DataBaseException;
import com.bootcamp.trabalho.capitulo1.service.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(Pageable pageable){
		Page<ClientEntity> list = clientRepository.findAll(pageable);
		return list.map(x -> new ClientDTO(x));
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<ClientEntity> obj = clientRepository.findById(id);
		ClientEntity entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new ClientDTO(entity);
	}

	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		ClientEntity entity = new ClientEntity();
		copyDtoToEntity(dto,entity);
		entity = clientRepository.save(entity);
		return new ClientDTO(entity);
		

	}
	
	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
			ClientEntity entity = clientRepository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = clientRepository.save(entity);
			return new ClientDTO(entity);
		}catch(EntityNotFoundException e){
			 throw new ResourceNotFoundException("Id not found" + id);
			
		}
		
	}

	private void copyDtoToEntity(ClientDTO dto, ClientEntity entity) {
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
		
	}

	public void delete(Long id) {
		try {
			clientRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found" + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity violation");
		}
		
	}

	
}
