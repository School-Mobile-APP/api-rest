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

import com.ficha.dto.SgPersonaDto;
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
			@RequestBody @Validated SgPersona ficha) {
		String mensaje = "";
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
		return ResponseEntity.status(201).body(mensaje);
	}

	@RequestMapping(value = {
			"/persona/{id}" }, method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	public @ResponseBody ResponseEntity<?> modificarPersona(@PathVariable("id") Long id,
			@RequestBody @Validated SgPersona per) {
		String mensaje = "";
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
			registro.setPerSegundoNombre(per.getPerSegundoNombre());
			registro.setPerEmail(per.getPerEmail());
			registro.setPerEscolaridad(per.getPerEscolaridad());
			permodificado = personarepository.save(registro);
			if (permodificado != null) {
				mensaje = "Modificado correctamente";
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			mensaje = "Error" + e.toString();
		}
		return permodificado != null ? ResponseEntity.status(200).body(permodificado)
				: ResponseEntity.status(201).body(mensaje);
	}
}
