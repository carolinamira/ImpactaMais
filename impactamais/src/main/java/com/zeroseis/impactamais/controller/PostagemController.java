package com.zeroseis.impactamais.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeroseis.impactamais.model.Postagem;
import com.zeroseis.impactamais.repository.PostagemRepository;

@RestController
@RequestMapping("/postagem")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {

	@Autowired
	public PostagemRepository repository;
	
	@GetMapping //GetAllPostagem
	public ResponseEntity<List<Postagem>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}") //getbyId Postagem
	public ResponseEntity<Postagem> GetById(@PathVariable long id){
		return repository.findById(id).map(resp-> ResponseEntity.ok(resp))
		.orElse(ResponseEntity.notFound().build());		
				
	}
	
	@PostMapping //postPostagem
	public ResponseEntity<Postagem> post (@RequestBody Postagem titulo){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(titulo));
	}
	
	@PutMapping //putPostagem
	public ResponseEntity<Postagem> put (@RequestBody Postagem titulo) {
		return ResponseEntity.ok(repository.save(titulo));		
	}
	
	@DeleteMapping("/{id}") //deletePostagem
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	
	}
}
