package com.ficha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ficha.model.SgCanton;
import com.ficha.repository.CantonRepository;

@CrossOrigin
@RestController
@RequestMapping("/")

public class CantonController {
	@Autowired
	CantonRepository cantonrepository;

	@RequestMapping(value = { "canton" }, method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody ResponseEntity<?> crearCanton(@RequestBody @Validated SgCanton canton) {
		String mensaje = "";
		SgCanton modificado = null;
		try {
			modificado = cantonrepository.save(canton);
		} catch (Exception e) {
			System.out.println(e.toString());
			mensaje = e.toString();
		}
		return modificado != null ? ResponseEntity.status(200).body(modificado)
				: ResponseEntity.status(201).body(mensaje);
	}
}
