package com.ficha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ficha.model.SgPersonaDiscapacidad;
import com.ficha.repository.DatosResidencialesRepository;

@CrossOrigin
@RestController
@RequestMapping("/")
public class DatosResidencialesController {
	@Autowired
	DatosResidencialesRepository datosrepository;

	@RequestMapping(value = {
			"/internetResidencial/{internet}/{pk}" }, method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	public @ResponseBody ResponseEntity<?> modificarEst(@PathVariable("internet") Boolean internet,
			@PathVariable("pk") Long pk) {
		String mensaje = "";
		try {
			if (datosrepository.updateAccesoInternet(internet, pk) == 1) {
				mensaje = "Modificado correctamente";
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			mensaje = e.toString();
		}
		return ResponseEntity.status(201).body(mensaje);
	}
}
