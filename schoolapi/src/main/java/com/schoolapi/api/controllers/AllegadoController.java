package com.schoolapi.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolapi.api.entities.Allegado;
import com.schoolapi.api.entities.Persona;
import com.schoolapi.api.repositories.PersonaRepository;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/allegados")
public class AllegadoController {
	@Autowired
	private PersonaRepository personaRepository;
	@GetMapping("/")
	public ResponseEntity<?> actualizarAllegado(@RequestBody Allegado all) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(personaRepository.getAllegados(all.getAllPersonaReferenciada().getPerPk()));
			//return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Datos incorrectos\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}
}
