package com.schoolapi.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolapi.api.entities.PersonaTerapia;
import com.schoolapi.api.repositories.PersonaTerapiaRepository;
import com.schoolapi.api.services.TerapiaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/terapias")
public class TerapiaController {
	@Autowired 
	private TerapiaService terapiaService;
	@Autowired
	private PersonaTerapiaRepository personaTerapiaRepository;
	@GetMapping("")
	public ResponseEntity<?> getAll(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(terapiaService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(terapiaService.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}
	@PostMapping("/")
	public ResponseEntity<?> createDiscapacidad(@RequestBody PersonaTerapia ter) {
		try {
			PersonaTerapia perTer = personaTerapiaRepository.save(ter);
			return ResponseEntity.status(HttpStatus.OK).body(perTer);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDiscapacidad(@PathVariable("id") Long id) {
		try {
			personaTerapiaRepository.deleteTerapia(id);
			return ResponseEntity.status(HttpStatus.OK).body("{\"Mensaje\":\""+"Eliminado"+"\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}
}
