package com.schoolapi.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.schoolapi.api.entities.Telefono;
import com.schoolapi.api.repositories.TelefonoRepository;
import com.schoolapi.api.utils.JwtUtils;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/telefonos")
public class TelefonoController {
	@Autowired
	private TelefonoRepository telefonoRepository;
	@Autowired
	private JwtUtils jwtUtils;
	//Obtiene todos los telefonos
	@PostMapping("/")
	public ResponseEntity<?> createPhone(@RequestBody Telefono tel,@RequestHeader(value = "authorization", defaultValue = "") String auth,@RequestHeader(value = "code", defaultValue = "") String code){
		try {
			if(auth.isEmpty() || auth==null || auth.isBlank() || code.isEmpty() || code==null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if(!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			Telefono agregadoTelefono=telefonoRepository.save(tel);
			return ResponseEntity.status(HttpStatus.OK).body(agregadoTelefono);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}
	//Elimina un telefono basado en un ID
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDiscapacidad(@PathVariable("id") Long id,@RequestHeader(value = "authorization", defaultValue = "") String auth,@RequestHeader(value = "code", defaultValue = "") String code) {
		try {
			if(auth.isEmpty() || auth==null || auth.isBlank() || code.isEmpty() || code==null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if(!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			telefonoRepository.deleteTelefono(id);
			return ResponseEntity.status(HttpStatus.OK).body("{\"Mensaje\":\""+"Eliminado"+"\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\""+ e.toString() + "\"}");
		}
	}
}
