package com.schoolapi.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolapi.api.entities.Persona;
import com.schoolapi.api.entities.PersonaElementoHogarPk;
import com.schoolapi.api.repositories.PersonaElementosHogarRepository;
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
	private PersonaService personaService;
	@Autowired
	private PersonaElementosHogarRepository personaElementosHogarRepository;
	@GetMapping("/{dui}")
	public ResponseEntity<?> getPerson(@PathVariable String dui){
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
	        CriteriaQuery<Persona> cq = cb.createQuery(Persona.class);
	        Root<Persona> person = cq.from(Persona.class);
	        Predicate duiFound = cb.equal(person.get("perDui"), dui);
	        cq.where(duiFound);
	        TypedQuery<Persona> query = em.createQuery(cq);
	        if(query.getResultList().size()==0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":"+"No encontrado"+"}");
	        }
	        return ResponseEntity.status(HttpStatus.OK).body(query.getResultList());
			//return ResponseEntity.status(HttpStatus.OK).body(personaService.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":"+e.toString()+"}");
		}
	}
	@PostMapping("/elementos/")
	public ResponseEntity<?> addElemento(@RequestBody PersonaElementoHogarPk perEl){
		try {
			PersonaElementoHogarPk perEleNuevo=personaElementosHogarRepository.save(perEl);
			return ResponseEntity.status(HttpStatus.OK).body(perEleNuevo);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":"+e.toString()+"}");
		}
	}
}
