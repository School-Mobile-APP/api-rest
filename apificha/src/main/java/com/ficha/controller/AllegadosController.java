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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ficha.dto.SgAllegadoDto;
import com.ficha.model.SgAllegado;
import com.ficha.repository.AllegadosRepository;
import com.ficha.repository.PersonaRepository;

@CrossOrigin
@RestController
@RequestMapping("/")
public class AllegadosController {
	@Autowired
	AllegadosRepository allegadosrepository;
	@Autowired
	PersonaRepository personarepository;

	@RequestMapping(value = {
			"/allegado/{id}" }, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody SgAllegadoDto getAllegado(@PathVariable("id") Long id) {
		SgAllegadoDto elementos = allegadosrepository.getAllegado(id);
		return elementos != null ? elementos : null;
	}
	@RequestMapping(value = {
			"/allegado/{id}" }, method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	public @ResponseBody ResponseEntity<?> modificarAllegado(@PathVariable("id") Long id,
			@RequestBody @Validated SgAllegado allegado) {
		String mensaje = "";
		ObjectMapper mapper = new ObjectMapper();
        JsonNode json =null;
		SgAllegado allmodificado = null;
		SgAllegado registro = allegadosrepository.findById(id).orElse(null);
		try {
			if (registro == null) {
				registro = new SgAllegado();
			}
			registro.setAllPersona(allegado.getAllPersona());//persona
			registro.setAllPersonaReferenciada(allegado.getAllPersonaReferenciada());//allegado
			registro.setAllTipoParentesco(allegado.getAllTipoParentesco());//parentesco
			allmodificado=allegadosrepository.save(registro);
			if (allmodificado != null) {
				  mensaje = "Modificado correctamente";
				  json= mapper.readTree("{\"Mensaje\":Modificado Correctamente"+"}");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			mensaje = "Error" + e.toString();
		}
		return allmodificado != null ? ResponseEntity.status(200).body(registro)
				: ResponseEntity.ok(json);
	}
}
