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
import com.schoolapi.api.entities.PersonaDiscapacidad;
import com.schoolapi.api.repositories.PersonaDiscapacidadRepository;
import com.schoolapi.api.services.DiscapacidadService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/discapacidades")
public class DiscapacidadController {
	@Autowired
	private DiscapacidadService discapacidadService;
	@Autowired
	private PersonaDiscapacidadRepository personaDiscapacidadRepository;

	@GetMapping("")
	public ResponseEntity<?> getAll() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(discapacidadService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(discapacidadService.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@PostMapping("/")
	public ResponseEntity<?> createDiscapacidad(@RequestBody PersonaDiscapacidad disc) {
		try {
			PersonaDiscapacidad perDis = personaDiscapacidadRepository.save(disc);
			return ResponseEntity.status(HttpStatus.OK).body(perDis);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDiscapacidad(@PathVariable("id") Long id) {
		try {
			personaDiscapacidadRepository.deleteDiscapacidad(id);
			return ResponseEntity.status(HttpStatus.OK).body("{\"Mensaje\":\"Eliminado\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}
}
