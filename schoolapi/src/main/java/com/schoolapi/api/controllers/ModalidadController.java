package com.schoolapi.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolapi.api.services.ModalidadService;
import com.schoolapi.api.utils.JwtUtils;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/modalidades")
public class ModalidadController {
	@Autowired
	private ModalidadService modalidadService;
	@Autowired
	private JwtUtils jwtUtils;
	//Obtiene todas las modalidades
	@GetMapping("")
	public ResponseEntity<?> getAll(@RequestHeader(value = "authorization", defaultValue = "") String auth,@RequestHeader(value = "code", defaultValue = "") String code){
		try {
			if(auth.isEmpty() || auth==null || auth.isBlank() || code.isEmpty() || code==null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if(!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			return ResponseEntity.status(HttpStatus.OK).body(modalidadService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}
	//Obtiene una modalidad basado en la pk de la misma
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable Long id,@RequestHeader(value = "authorization", defaultValue = "") String auth,@RequestHeader(value = "code", defaultValue = "") String code){
		try {
			if(auth.isEmpty() || auth==null || auth.isBlank() || code.isEmpty() || code==null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if(!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			return ResponseEntity.status(HttpStatus.OK).body(modalidadService.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}
}
