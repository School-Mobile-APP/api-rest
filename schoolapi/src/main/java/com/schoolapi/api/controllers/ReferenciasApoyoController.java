package com.schoolapi.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolapi.api.services.ReferenciaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/referencias")
public class ReferenciasApoyoController {
	@Autowired
	private ReferenciaService referenciaService;
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
}