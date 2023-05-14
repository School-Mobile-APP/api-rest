package com.ficha.controller;

import java.time.LocalDate;

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
import com.ficha.dto.SgPersonaDto;
import com.ficha.model.SgDatosResidencialesPersona;
import com.ficha.model.SgPersona;
import com.ficha.repository.PersonaRepository;

@CrossOrigin
@RestController
@RequestMapping("/")
public class PersonaController {
	@Autowired
	PersonaRepository personarepository;

	@RequestMapping(value = {
			"/persona/{id}" }, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody SgPersonaDto getPersonaAllegado(@PathVariable("id") Long id) {
		SgPersonaDto elementos = personarepository.getPersona(id);
		return elementos != null ? elementos : null;
	}

	@RequestMapping(value = {
			"/perfil/{id}" }, method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	public @ResponseBody ResponseEntity<?> modificarPerfil(@PathVariable("id") Long id,
			@RequestBody @Validated SgPersona ficha) throws JsonMappingException, JsonProcessingException {
		String mensaje = "";
		ObjectMapper mapper = new ObjectMapper();
        JsonNode json =mapper.readTree("{\"Mensaje\": \"Modificado correctamente\"}");
		try {
			if(personarepository.updatePerfil(ficha.getPerPrimerNombre(), 
					ficha.getPerSegundoNombre(), 
					ficha.getPerPrimerApellido(), ficha.getPerSegundoApellido(), 
					ficha.getPerFechaNacimiento(), 
					ficha.getPerEmail(), id)==1) {
				mensaje = "Modificado correctamente";
			}
		} catch (Exception e) {
			mensaje = e.toString();
		}
		return ResponseEntity.ok(json);
	}

	@RequestMapping(value = {
			"/persona/{id}" }, method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	public @ResponseBody ResponseEntity<?> modificarPersona(@PathVariable("id") Long id,
			@RequestBody @Validated SgPersona per) throws JsonMappingException, JsonProcessingException {
		String mensaje = "";
		ObjectMapper mapper = new ObjectMapper();
        JsonNode json =null;
		SgPersona permodificado = null;
		SgPersona registro = personarepository.findById(id).orElse(null);
		try {
			if (registro == null) {
				registro = new SgPersona();
			}
			registro.setPerDui(per.getPerDui());
			registro.setPerPrimerApellido(per.getPerPrimerApellido());
			registro.setPerPrimerNombre(per.getPerPrimerNombre());
			registro.setPerSegundoApellido(per.getPerSegundoApellido());
			registro.setPerFechaNacimiento(LocalDate.parse("1992-10-12"));
			registro.setPerSegundoNombre(per.getPerSegundoNombre());
			registro.setPerEmail(per.getPerEmail());
			registro.setPerEscolaridad(per.getPerEscolaridad());
			registro.setPerEstadoCivil(Long.valueOf(1));
			registro.setPerDireccion(per.getPerDireccion());
			permodificado = personarepository.save(registro);
			if (permodificado != null) {
				mensaje = "Modificado correctamente";
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			mensaje = "Error" + e.toString();
			json= mapper.readTree("{\"Mensaje\":"+e.toString()+"}");
		}
		return permodificado != null ? ResponseEntity.status(200).body(permodificado)
				: ResponseEntity.ok(json);
	}
}
