package com.schoolapi.api.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.schoolapi.api.utils.JwtUtils;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private JwtUtils jwtUtils;
	@GetMapping("/{code}")
	public ResponseEntity<?> getToken(@PathVariable("code") String code) {
		try {
			if(!jwtUtils.checkCode(code)) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"" + "Código inválido" + "\"}");	
			}
			String token=jwtUtils.generateJwt(code);
			return ResponseEntity.status(HttpStatus.OK).body("{\"Token\":\""+token+"\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}
}
