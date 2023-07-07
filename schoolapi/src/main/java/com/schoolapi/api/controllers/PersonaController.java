package com.schoolapi.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolapi.api.entities.DatosResidenciales;
import com.schoolapi.api.entities.EstudianteCanal;
import com.schoolapi.api.entities.Persona;
import com.schoolapi.api.entities.PersonaElementoHogarPk;
import com.schoolapi.api.repositories.EstudianteCanalAtencionRepository;
import com.schoolapi.api.repositories.PersonaElementosHogarRepository;
import com.schoolapi.api.repositories.PersonaRepository;
import com.schoolapi.api.services.PersonaService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/personas")
public class PersonaController {
	@PersistenceContext
	EntityManager em;
	@Autowired 
	private EstudianteCanalAtencionRepository estudianteCanalAtencionRepository;
	@Autowired
	private PersonaService personaService;
	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private PersonaElementosHogarRepository personaElementosHogarRepository;

	@GetMapping("/{dui}")
	public ResponseEntity<?> getPerson(@PathVariable String dui) {
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Persona> cq = cb.createQuery(Persona.class);
			Root<Persona> person = cq.from(Persona.class);
			Predicate duiFound = cb.equal(person.get("perDui"), dui);
			cq.where(duiFound);
			TypedQuery<Persona> query = em.createQuery(cq);
			if (query.getResultList().size() == 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":" + "No encontrado" + "}");
			}
			return ResponseEntity.status(HttpStatus.OK).body(query.getResultList());
			// return
			// ResponseEntity.status(HttpStatus.OK).body(personaService.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":" + e.toString() + "}");
		}
	}

	@PostMapping("/elementos/")
	public ResponseEntity<?> addElemento(@RequestBody PersonaElementoHogarPk perEl) {
		try {
			PersonaElementoHogarPk perEleNuevo = personaElementosHogarRepository.save(perEl);
			return ResponseEntity.status(HttpStatus.OK).body(perEleNuevo);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":" + e.toString() + "}");
		}
	}

	@PutMapping("/pasoCuatro")
	public ResponseEntity<?> actualizarPasoCuatro(@RequestBody DatosResidenciales datos) {
		try {
			Boolean actualizado=personaRepository.updateStepFour(datos.getPeTieneServicioBasura(),
					datos.getPerFuenteAbastecimientoAguaResidencial(),
					datos.getPerTieneServicioEnergiaElectricaResidencial(), datos.getPerPk());
			if(actualizado) {
				return ResponseEntity.status(HttpStatus.OK).body("{\"Modificado\":" + "Exito" + "}");
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":" + "No se modificó" + "}");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":" + e.toString() + "}");	
		}
	}
	@PutMapping("/internet")
	public ResponseEntity<?> actualizarInternet(@RequestBody Persona per) {
		try {
			Boolean actualizado=personaRepository.updateInternet(per.getPerAccesoInternet(),per.getPerPk());
			if(actualizado) {
				return ResponseEntity.status(HttpStatus.OK).body("{\"Modificado\":" + "Exito" + "}");
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":" + "No se modificó" + "}");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":" + e.toString() + "}");	
		}
	}
	@PutMapping("/internetResidencial")
	public ResponseEntity<?> actualizarInternet(@RequestBody DatosResidenciales dat) {
		try {
			Boolean actualizado=personaRepository.updateInternetResidencial(dat.getPerTieneConexionInternetResidencial(),dat.getPerPk());
			if(actualizado) {
				return ResponseEntity.status(HttpStatus.OK).body("{\"Modificado\":" + "Exito" + "}");
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":" + "No se modificó" + "}");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":" + e.toString() + "}");	
		}
	}
	@PostMapping("/estCanal")
	public ResponseEntity<?> addElemento(@RequestBody EstudianteCanal estCan) {
		try {
			EstudianteCanal estudianteCanal = estudianteCanalAtencionRepository.save(estCan);
			return ResponseEntity.status(HttpStatus.OK).body(estudianteCanal);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":" + e.toString() + "}");
		}
	}
	
}
