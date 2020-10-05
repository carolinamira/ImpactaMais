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

import com.zeroseis.impactamais.model.Hospital;
import com.zeroseis.impactamais.repository.HospitalRepository;

@RestController
@RequestMapping("/hospitais")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HospitalController {
	
	@Autowired
	public HospitalRepository repository;
	
	@GetMapping //GetAllHospitais
	public ResponseEntity<List<Hospital>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}") //getbyId Hospitais
	public ResponseEntity<Hospital> GetById(@PathVariable long id){
		return repository.findById(id).map(resp-> ResponseEntity.ok(resp))
		.orElse(ResponseEntity.notFound().build());		
	}
	
	@GetMapping("/cidade/{cidade}") //GetAllByCidade
	public ResponseEntity<Hospital> GetAllByCidade(@PathVariable String cidade) {
		return repository.findAllByCidadeContainingIgnoreCase(cidade).map(resp-> ResponseEntity.ok(resp))
		.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping //postHospital
	public ResponseEntity<Hospital> post (@RequestBody Hospital nome){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(nome));
	}
	
	@PutMapping //putHospital
	public ResponseEntity<Hospital> put (@RequestBody Hospital nome) {
		return ResponseEntity.ok(repository.save(nome));		
	}
	
	@DeleteMapping("/{id}") //deleteHospital
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	
	}

}
