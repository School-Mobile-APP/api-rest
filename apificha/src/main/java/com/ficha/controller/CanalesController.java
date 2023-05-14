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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ficha.dto.SgCanalesEst;
import com.ficha.model.SgCanalesAtencion;
import com.ficha.model.SgEstCanalesAtencion;
import com.ficha.repository.CanalesPersonaRepository;
import com.ficha.repository.CanalesRepository;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CanalesController {
	@Autowired
	CanalesRepository canalesrepository;
	@Autowired
	CanalesPersonaRepository canalestrepository;

	@RequestMapping(value = { "/canales" }, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody List<SgCanalesAtencion> getCanales() {
		List<SgCanalesAtencion> datos = canalesrepository.findAll();
		return datos != null ? datos : null;
	}

	@RequestMapping(value = {
			"/canales/{id}" }, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody ResponseEntity<?> getCanalesId(@PathVariable("id") Long id) throws JsonMappingException, JsonProcessingException {
		List<SgCanalesEst> datos = canalestrepository.getPersonaCanales(id);
		ObjectMapper mapper = new ObjectMapper();
        JsonNode json= mapper.readTree("{\"Mensaje\": \"Modificado correctamente\"}");
		return datos != null ? ResponseEntity.status(200).body(datos) : ResponseEntity.ok(json);
	}

	@RequestMapping(value = { "/canales/{canal}/{id}" }, method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody ResponseEntity<?> modificarCanalest(@PathVariable("id") Integer id,
			@PathVariable("canal") Integer canal) {
		String mensaje = "";
		SgEstCanalesAtencion cestmodificada = new SgEstCanalesAtencion();
		try {
			cestmodificada.setEcaAnioLectivoFk(null);
			cestmodificada.setEcaCanalFk(canal);
			cestmodificada.setEcaEstudianteFk(id);
			cestmodificada.setEcaUltModFecha(null);
			cestmodificada.setEcaVersion(null);
			cestmodificada.setEcaUltModUsuario(null);
			cestmodificada = canalestrepository.save(cestmodificada);
			if (cestmodificada != null) {
				mensaje = "Modificado correctamente";
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			mensaje = "Error" + e.toString();
		}
		return cestmodificada != null ? ResponseEntity.status(200).body(cestmodificada)
				: ResponseEntity.status(201).body(mensaje);
	}

	@RequestMapping(value = {
			"/eliminarCanales/{id}" }, method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
	public @ResponseBody ResponseEntity<?> eliminarCanales(@PathVariable("id") Long pk) throws JsonMappingException, JsonProcessingException {
		String mensaje = "";
		ObjectMapper mapper = new ObjectMapper();
        JsonNode json= mapper.readTree("{\"Mensaje\": \"Eliminado correctamente\"}");
		canalestrepository.deleteCanales(pk);
		mensaje = "Eliminado correctamente";
		return ResponseEntity.ok(json);
	}
}
