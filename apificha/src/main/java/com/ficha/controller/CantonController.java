package com.ficha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ficha.model.SgCanton;
import com.ficha.repository.CantonRepository;

@CrossOrigin
@RestController
@RequestMapping("/")

public class CantonController {
	@Autowired
	CantonRepository cantonrepository;

	@RequestMapping(value = { "canton" }, method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody ResponseEntity<?> crearCanton(@RequestBody @Validated SgCanton canton) throws JsonMappingException, JsonProcessingException {
		String mensaje = "";
		SgCanton modificado = null;
		JsonNode json=null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			modificado = cantonrepository.save(canton);
		} catch (Exception e) {
			System.out.println(e.toString());
	        json= mapper.readTree("{\"Mensaje\":"+e.toString()+"\"}");
			mensaje = e.toString();
		}
		return modificado != null ? ResponseEntity.status(200).body(modificado)
				: new ResponseEntity<Object>(json, HttpStatus.MOVED_PERMANENTLY);
	}
}
