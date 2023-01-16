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
import com.ficha.model.SgPersonaDiscapacidad;
import com.ficha.repository.DiscapacidadRepository;

@CrossOrigin
@RestController
@RequestMapping("/")
public class DiscapacidadController {
	@Autowired
	DiscapacidadRepository discapacidadrepository;

	@RequestMapping(value = {
			"/discapacidades/{id}" }, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody List<SgPersonaDiscapacidad> getDiscapacidades(@PathVariable("id") Long id) {
		List<SgPersonaDiscapacidad> discapacidades = discapacidadrepository.getDiscapacidades(id);
		return discapacidades != null ? discapacidades : null;
	}

	@RequestMapping(value = {
			"/discapacidades" }, method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody ResponseEntity<?> modificarDiscapacidades(
			@RequestBody @Validated SgPersonaDiscapacidad perDisc) {
		String mensaje = "";
		SgPersonaDiscapacidad discmodificada = null;
		try {
			discmodificada = discapacidadrepository.save(perDisc);
			if (discmodificada != null) {
				mensaje = "Modificado correctamente";
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			mensaje = "Error" + e.toString();
		}
		return discmodificada != null ? ResponseEntity.status(200).body(discmodificada)
				: ResponseEntity.status(201).body(mensaje);
	}
}
