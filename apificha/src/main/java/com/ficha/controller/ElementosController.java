package com.ficha.controller;

import java.util.List;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ficha.model.SgPersonaElemento;
import com.ficha.repository.ElementosHogarRepository;

@CrossOrigin
@RestController
@RequestMapping("/")
public class ElementosController {
	@Autowired
	ElementosHogarRepository elementosrepository;

	@RequestMapping(value = {
			"/elementos/{id}" }, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody List<SgPersonaElemento> getElementos(@PathVariable("id") Long id) {
		List<SgPersonaElemento> elementos = elementosrepository.getElementos(id);
		return elementos != null ? elementos : null;
	}

	@RequestMapping(value = {
			"/eliminarElementos/{id}" }, method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
	public @ResponseBody ResponseEntity<?> eliminarElementos(@PathVariable("id") Long pk) throws JsonMappingException, JsonProcessingException {
		String mensaje = "";
		elementosrepository.deleteElementos(pk);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode json= mapper.readTree("{\"Mensaje\":Eliminado Correctamente"+"}");
		mensaje = "Eliminado correctamente";
		return ResponseEntity.ok(json);
	}

	@RequestMapping(value = { "/elementos" }, method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody ResponseEntity<?> modificarElementos(@RequestBody @Validated SgPersonaElemento perEl) {
		String mensaje = "";
		SgPersonaElemento elementomodificado = null;
		try {
			elementomodificado = elementosrepository.save(perEl);
			if (elementomodificado != null) {
				mensaje = "Modificado correctamente";
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			mensaje = "Error" + e.toString();
		}
		return elementomodificado != null ? ResponseEntity.status(200).body(elementomodificado)
				: ResponseEntity.status(201).body(mensaje);
	}
}
