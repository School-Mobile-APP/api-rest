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

import com.ficha.dto.SgFichaDatos;
import com.ficha.model.SgPersona;
import com.ficha.model.SgPersonaReferencia;
import com.ficha.repository.PersonaRepository;
import com.ficha.repository.ReferenciasRepository;

@CrossOrigin
@RestController
@RequestMapping("/")
public class ReferenciaController {
	@Autowired
	ReferenciasRepository referenciarepository;
	@RequestMapping(value= {"/getReferencias/{id}"},method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody ResponseEntity<?> getReferencias(@PathVariable("id") Long id){
		SgPersonaReferencia datos=referenciarepository.getPersonaRef(id);
		return datos!=null?ResponseEntity.status(200).body(datos):ResponseEntity.status(401).body("No hay datos");
	}
	@RequestMapping(value = {
			"/referencias" }, method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public @ResponseBody ResponseEntity<?> modificarReferencias(
			@RequestBody @Validated SgPersonaReferencia referencia) {
		String mensaje = "";
		SgPersonaReferencia referenciamodificada = null;
		try {
			referenciarepository.deleteRef(referencia.getPer_pk(),referencia.getRea_pk());
			referenciamodificada=referenciarepository.save(referencia);
			if (referenciamodificada != null) {
				mensaje = "Modificado correctamente";
			}
		}
		catch (Exception e) {
			System.out.println(e.toString());
			mensaje = "Error" + e.toString();
		}
		return referenciamodificada != null ? ResponseEntity.status(200).body(referenciamodificada)
				: ResponseEntity.status(201).body(mensaje);
	}

}
