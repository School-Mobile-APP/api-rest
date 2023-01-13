package com.ficha.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ficha.model.SgFichaPasoDos;
import com.ficha.model.SgPersona;
import com.ficha.repository.PersonaRepository;

@RestController()
@RequestMapping("/ficha")
public class FichaController {
	@Autowired
	PersonaRepository personarepository;

	@RequestMapping(value = {
			"/pasoDos/{id}" }, method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	public @ResponseBody ResponseEntity<?> modificarAlumno(@PathVariable("id") Long id,@RequestBody @Validated SgFichaPasoDos ficha) {
		String mensaje = "";
		SgPersona pasodosmodificado = null;
		try {
			SgPersona registro=personarepository.findById(id).orElse(null);
			System.out.print(registro);
			System.out.println();
			registro.setPerDui(ficha.getPerDui());
			registro.setPerPrimerNombre(ficha.getPerPrimerNombre());
			registro.setPerSegundoNombre(ficha.getPerSegundoNombre());
			registro.setPerPrimerApellido(ficha.getPerPrimerApellido());
			registro.setPerSegundoApellido(ficha.getPerSegundoApellido());
			registro.setPerFechaNacimiento(ficha.getPerFechaNacimiento());
			registro.setPerNacionalidad(ficha.getPerNacionalidad());
			registro.setPerRetornada(ficha.getPerRetornada());
			registro.setPerPartidaNacimientoPresenta(ficha.getPerPartidaNacimientoPresenta());
			registro.setPerEtnia(ficha.getPerEtnia());
			registro.setPerTieneDiagnostico(ficha.getPerTieneDiagnostico());
			registro.setPerEmail(ficha.getPerEmail());
			registro.setPerTieneWhatsapp(ficha.getPerTieneWhatsapp());
			registro.setPerTipoTrabajo(ficha.getPerTipoTrabajo());
			registro.setPerEstadoCivil(ficha.getPerEstadoCivil());
			registro.setPerEmbarazo(ficha.getPerEmbarazo());
			registro.setPerTieneHijos(ficha.getPerTieneHijos());
			registro.setPerCantidadHijos(ficha.getPerCantidadHijos());
			registro.setPerSexo(ficha.getPerSexo());
			System.out.print(registro);
			pasodosmodificado=personarepository.save(registro);
			if (pasodosmodificado != null) {
				mensaje = "Modificado correctamente";
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			mensaje = "Error" + e.toString();
		}
		return pasodosmodificado != null ? ResponseEntity.status(200).body(ficha)
				: ResponseEntity.status(201).body(mensaje);
	}

}
