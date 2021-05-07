package com.contactura.contactura.controller;


 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contactura.contactura.model.Contact;
import com.contactura.contactura.repository.ContacturaRepository;

@RestController// quer dizer que tudo que esta nessa classe é controlador para APIs Rest
@RequestMapping({"/contactura"}) //é o mapeamento da nossa requisição
public class ContacturaController
 {

	@Autowired // é uma nova instância do repository que usamos para falicitar o uso de todos os metodos do Jpa
	private ContacturaRepository repository;
	
	//listar todos os contatos - http//localhost:8090/contactura
	@GetMapping
	public List findAll() {
		return repository.findAll();
	}
	
	//pesquisar pelo id - http:localhost:8090/contactura/10
	@GetMapping(value = "/{id}")
	public ResponseEntity findById(@PathVariable long id) {//path informa que estamos pegando uma variavel da rota
		return repository.findById(id)
				.map (record ->ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
}
	
	@PostMapping
	public Contact create(@RequestBody Contact contact){
	   return repository.save(contact);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity update(@PathVariable("id") long id,
	                                      @RequestBody Contact contact) {
	   return repository.findById(id)
	           .map(record -> {
	               record.setName(contact.getName());
	               record.setEmail(contact.getEmail());
	               record.setPhone(contact.getPhone());
	               Contact updated = repository.save(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity <?> delete(@PathVariable long id) {
	   return repository.findById(id)
	           .map(record -> {
	               repository.deleteById(id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
 }
	