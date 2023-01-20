package com.ficha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ficha.model.SgPersonaDiscapacidad;
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
}
