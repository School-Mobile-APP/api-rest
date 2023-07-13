package com.schoolapi.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolapi.api.entities.PersonaReferencia;
import com.schoolapi.api.entities.Telefono;
import com.schoolapi.api.repositories.TelefonoRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/telefonos")
public class TelefonoController {
	@Autowired
	private TelefonoRepository telefonoRepository;
	@PostMapping("/")
	public ResponseEntity<?> createPhone(@RequestBody Telefono tel){
		try {
			Telefono agregadoTelefono=telefonoRepository.save(tel);
			return ResponseEntity.status(HttpStatus.OK).body(agregadoTelefono);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\""+ e.toString() + "\"}");
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDiscapacidad(@PathVariable("id") Long id) {
		try {
			telefonoRepository.deleteTelefono(id);
			return ResponseEntity.status(HttpStatus.OK).body("{\"Mensaje\":\""+"Eliminado"+"\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\""+ e.toString() + "\"}");
		}
	}
}
