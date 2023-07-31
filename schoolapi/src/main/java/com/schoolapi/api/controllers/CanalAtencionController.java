package com.schoolapi.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolapi.api.services.CanalService;
import com.schoolapi.api.utils.JwtUtils;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/canales")
public class CanalAtencionController {
	@Autowired
	private CanalService canalService;
	@Autowired
	private JwtUtils jwtUtils;
	@GetMapping("")
	public ResponseEntity<?> getAll(@RequestHeader(value = "authorization", defaultValue = "") String auth,@RequestHeader(value = "code", defaultValue = "") String code){
		try {
			if(auth.isEmpty() || auth==null || auth.isBlank() || code.isEmpty() || code==null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if(!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			return ResponseEntity.status(HttpStatus.OK).body(canalService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"No encontrado\"}");
		}
	}
}
