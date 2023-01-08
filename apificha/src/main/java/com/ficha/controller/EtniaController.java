package com.ficha.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ficha.model.SgEtnia;
import com.ficha.repository.EtniaRepository;
import com.grupo7.model.AlumnoDTO;

@RestController()
@RequestMapping("/etnias")
public class EtniaController {
	@Autowired
	EtniaRepository etniarepository;

	@RequestMapping(value = "/modificarEtnia", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	public @ResponseBody ResponseEntity<?> modificarMateria(@RequestBody @Validated SgEtnia etnia) {
		String mensaje = "";
		SgEtnia etniamodificada = null;
		try {
			etniamodificada = etniarepository.save(etnia);
			if (etniamodificada != null) {
				mensaje = "Modificada correctamente";
			}
		} catch (Exception e) {
			mensaje = "Error" + e.toString();
		}
		return etniamodificada != null ? ResponseEntity.status(200).body(etniamodificada)
				: ResponseEntity.status(201).body(mensaje);
	}

	@RequestMapping(value = { "/" }, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody List<SgEtnia> obtenerEtnias() {
		List<SgEtnia> etnias = etniarepository.findAll();
		return etnias != null ? etnias : null;
	}
	/*
	 * @PutMapping("/{id}") public void actualizar(@PathVariable("id") Integer
	 * id, @RequestBody SgEtnia etnia) {
	 * 
	 * 
	 * listaEtnias.remove(new SgEtnia(id)); listaEtnias.add(etnia); }
	 */
}
