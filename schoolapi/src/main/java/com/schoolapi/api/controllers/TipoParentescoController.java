package com.schoolapi.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolapi.api.services.TipoParentescoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/parentescos")
public class TipoParentescoController {
	@Autowired
	private TipoParentescoService tipoParentescoService;
	@GetMapping("")
	public ResponseEntity<?> getAll(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(tipoParentescoService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":"+e.toString()+"}");
		}
	}

}
