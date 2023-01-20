package com.ficha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ficha.dto.SgFichaDatos;
import com.ficha.dto.SgModalidadesEst;
import com.ficha.model.SgEstCanalesAtencion;
import com.ficha.model.SgMultiModalidad;
import com.ficha.repository.CanalesRepository;
import com.ficha.repository.ModalidadPersonaRepository;
import com.ficha.repository.ModalidadRepository;

@CrossOrigin
@RestController
@RequestMapping("/")
public class ModalidadController {
	@Autowired 
	ModalidadRepository modalidadrepository;
	@Autowired
	ModalidadPersonaRepository modalidadestrepository;
	@RequestMapping(value= {"/modalidades"},method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody List<SgMultiModalidad> getCanales(){
		List<SgMultiModalidad> datos=modalidadrepository.findAll();
		return datos!=null?datos:null;
	}
	@RequestMapping(value = { "/modalidades/{id}" }, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody ResponseEntity<?> getModalidad(@PathVariable("id") Long id) {
		SgModalidadesEst datos = modalidadestrepository.getModalidadPersona(id);
		return datos!=null?ResponseEntity.status(200).body(datos):ResponseEntity.status(201).body("No hay datos");
	}
}
