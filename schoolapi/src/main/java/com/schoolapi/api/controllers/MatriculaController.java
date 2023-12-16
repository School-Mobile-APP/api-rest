package com.schoolapi.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolapi.api.entities.Matricula;
import com.schoolapi.api.utils.JwtUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/matriculas")
public class MatriculaController {
	@PersistenceContext
	EntityManager em;
	@Autowired
	private JwtUtils jwtUtils;
	//Obtiene las matriculas basado en una Pk del estudiante
	@GetMapping("/{pk}")
	public ResponseEntity<?> getPerson(@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code, @PathVariable String pk) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			//Ordena las matriculas descendentemente y busca por un parametro distinto a 
			//la pk de la matricula
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Matricula> cq = cb.createQuery(Matricula.class);
			Root<Matricula> person = cq.from(Matricula.class);
			Predicate duiFound = cb.equal(person.get("matEstudianteFk"), pk);
			cq.where(duiFound);
			cq.orderBy(cb.desc(person.get("matFechaHasta")));
			TypedQuery<Matricula> query = em.createQuery(cq);
			if (query.getResultList().size() == 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"No encontrado\"}");
			}
			return ResponseEntity.status(HttpStatus.OK).body(query.getResultList());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

}
