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
		SgFichaPasoDos pasodosmodificado = null;
		try {
			Optional<SgPersona> registro=personarepository.findById(id);
			System.out.println(registro.toString());
			System.out.println("xxx");
			// System.out.print(registro.get());
			SgPersona persona=new SgPersona();
			/*
			 * Alumno alumnoenviado = new Alumno();
			 * alumnoenviado.setIdAlumno(alumno.getIdAlumno());
			 * alumnoenviado.setNombre(alumno.getNombre());
			 * alumnoenviado.setCorreoInstitucional(alumno.getCorreoInstitucional());
			 * alumnoenviado.setApellido(alumno.getApellido());
			 * alumnoenviado.setFechaNacimiento(alumno.getFechaNacimiento());
			 * alumnoenviado.setContrasenia(alumno.getContrasenia());
			 * alumnoenviado.setGradoDelegate(alumno.getIdGrado()); alumnomodificado =
			 * alumnorepository.save(alumnoenviado);
			 */			
			if (pasodosmodificado != null) {
				mensaje = "Modificado correctamente";
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			mensaje = "Error" + e.toString();
		}
		return pasodosmodificado != null ? ResponseEntity.status(200).body(ficha)
				: ResponseEntity.status(201).body(ficha);
	}

}
