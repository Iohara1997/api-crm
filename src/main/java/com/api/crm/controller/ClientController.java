package com.api.crm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.crm.model.Client;
import com.api.crm.repository.ClientRepository;



@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping
	public List<Client>  list() {
		return clientRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client add(@RequestBody Client client) {  
		return clientRepository.save(client);
	}
	
	@PutMapping(path = "/{id}")
	public Client update(@RequestBody Client client, @PathVariable Long id) {
		client.setId(id);
		return clientRepository.save(client);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Client> listId(@PathVariable Long id) {
		return clientRepository.findById(id);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Client> delete(@PathVariable Long id) {
		Optional<Client> data = clientRepository.findById(id);
		clientRepository.delete(data.get());
		return new ResponseEntity<Client>(HttpStatus.OK);
	}
}
