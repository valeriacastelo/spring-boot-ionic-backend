package com.nelioalves.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nelioalves.backend.domain.Client;
import com.nelioalves.backend.dto.ClientDTO;
import com.nelioalves.backend.repositories.ClientRepository;
import com.nelioalves.backend.services.exception.DataIntegrityException;
import com.nelioalves.backend.services.exception.ObjectNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repo;
	
	public Client find(Integer id) {
		Optional<Client> op = repo.findById(id);
		
		return op.orElseThrow(() -> new ObjectNotFoundException("Object not found! "
				+ "Id:[" + id + "] Type:[" + Client.class.getName() + "]"));
	}
	
	public Client insert(Client obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Client update(Client obj) {
		Client updateObj = find(obj.getId());
		updateData(updateObj, obj);
		
		return repo.save(updateObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch(DataIntegrityViolationException ex) {
			throw new DataIntegrityException("Not possible delete a Client with associated entities");
		}
	}
	
	public List<Client> findAll() {
		return repo.findAll();
	}
	
	public Page<Client> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Client fromDTO(ClientDTO dto) {
		return new Client(dto.getId(), dto.getName(), dto.getEmail(), null, null);
	}
	
	private void updateData(Client updateObj, Client obj) {
		updateObj.setName(obj.getName());
		updateObj.setEmail(obj.getEmail());
	}

}
