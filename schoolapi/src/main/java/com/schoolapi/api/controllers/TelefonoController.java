package com.schoolapi.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":"+e.toString()+"}");
		}
	}
}
