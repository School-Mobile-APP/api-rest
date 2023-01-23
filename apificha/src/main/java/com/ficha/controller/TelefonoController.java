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
import com.ficha.model.SgTelefono;
import com.ficha.repository.TelefonoRepository;

@CrossOrigin
@RestController
@RequestMapping("/")
public class TelefonoController {
	@Autowired
	TelefonoRepository telefonopository;

	@RequestMapping(value = {
			"/telefonos/{id}" }, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody List<SgTelefono> getDatosFicha(@PathVariable("id") Long id) {
		List<SgTelefono> datos = telefonopository.getTelefonos(id);
		return datos != null ? datos : null;
	}

	@RequestMapping(value = {
			"/telefono/{id}" }, method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	public @ResponseBody ResponseEntity<?> modificarTelefono(@PathVariable("id") Long id,
			@RequestBody @Validated SgTelefono tel) {
		String mensaje = "";
		SgTelefono telmodificado = null;
		SgTelefono registro = telefonopository.findById(id).orElse(null);
		try {
			if (registro == null) {
				if (telefonopository.inserTelefono(tel.getTelTelefono(), tel.getTelPersona()) == 1) {
					mensaje = "Modificado exitosamente";
				}
			} else {
				if (telefonopository.updateTelefono(tel.getTelPersona(), tel.getTelTelefono(), id) == 1) {
					mensaje = "Modificado correctamente";
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			mensaje = "Error" + e.toString();
		}
		return telmodificado != null ? ResponseEntity.status(200).body(registro)
				: ResponseEntity.status(201).body(mensaje);
	}

	@RequestMapping(value = {
			"/eliminarTelefono/{id}" }, method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
	public @ResponseBody String eliminarTerapias(@PathVariable("id") Long pk) {
		String mensaje = "";
		telefonopository.deleteTel(pk);
		mensaje = "Eliminado correctamente";
		return mensaje;
	}
}
