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
import com.schoolapi.api.entities.PersonaReferencia;
import com.schoolapi.api.repositories.PersonaReferenciaRepository;
import com.schoolapi.api.services.ReferenciaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/referencias")
public class ReferenciasApoyoController {
	@Autowired
	private ReferenciaService referenciaService;
	@Autowired
	private PersonaReferenciaRepository personaReferenciaRepository;
	@GetMapping("")
	public ResponseEntity<?> getAll(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(referenciaService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":"+e.toString()+"}");
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable Long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(referenciaService.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":"+e.toString()+"}");
		}
	}
	@PostMapping("/")
	public ResponseEntity<?> createReferencia(@RequestBody PersonaReferencia ref) {
		try {
			PersonaReferencia perRef = personaReferenciaRepository.save(ref);
			return ResponseEntity.status(HttpStatus.OK).body(perRef);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\""+ e.toString() + "\"}");
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteReferencia(@PathVariable("id") Long id) {
		try {
			personaReferenciaRepository.deleteReferencia(id);
			return ResponseEntity.status(HttpStatus.OK).body("{\"Mensaje\":\""+"Eliminado"+"\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\""+ e.toString() + "\"}");
		}
	}
}
