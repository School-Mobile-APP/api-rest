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
import com.ficha.model.SgPersonaTerapia;
import com.ficha.repository.TerapiaRepository;

@CrossOrigin
@RestController
@RequestMapping("/")
public class TerapiasController {
	@Autowired
	TerapiaRepository terapiasrepository;

	@RequestMapping(value = {
			"/terapias/{id}" }, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody List<SgPersonaTerapia> getDiscapacidades(@PathVariable("id") Long id) {
		List<SgPersonaTerapia> terapias = terapiasrepository.getTerapias(id);
		return terapias != null ? terapias : null;
	}

	@RequestMapping(value = {
			"/eliminarTerapias/{id}" }, method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
	public @ResponseBody ResponseEntity<?> eliminarTerapias(@PathVariable("id") Long pk) throws JsonMappingException, JsonProcessingException {
		String mensaje = "";
		ObjectMapper mapper = new ObjectMapper();
        JsonNode json =null;
    	json= mapper.readTree("{\"Mensaje\": \"Eliminado correctamente\"}");
		terapiasrepository.deleteTer(pk);
		mensaje = "Eliminado correctamente";
		return ResponseEntity.ok(json);
	}

	@RequestMapping(value = {
			"/terapias" }, method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody ResponseEntity<?> modificarDiscapacidades(
			@RequestBody @Validated SgPersonaTerapia perTer) {
		String mensaje = "";
		SgPersonaTerapia termodificada = null;
		try {
			termodificada = terapiasrepository.save(perTer);
			if (termodificada != null) {
				mensaje = "Modificado correctamente";
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			mensaje = "Error" + e.toString();
		}
		return termodificada != null ? ResponseEntity.status(200).body(termodificada)
				: ResponseEntity.status(201).body(mensaje);
	}
}
