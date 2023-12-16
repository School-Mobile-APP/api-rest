package com.schoolapi.api.controllers;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.schoolapi.api.entities.AllegadoDTO;
import com.schoolapi.api.entities.Persona;
import com.schoolapi.api.entities.Allegado;
import com.schoolapi.api.repositories.PersonaRepository;
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
//Ruta del controlador
@RequestMapping("/allegados")
public class AllegadoController {
	@PersistenceContext
	EntityManager em;
	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private JwtUtils jwtUtils;

	// buscar un allegado a partir del pk del familiar
	@GetMapping("/{pk}")
	public ResponseEntity<?> getAllegados(@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code, @PathVariable String pk) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Allegado> cq = cb.createQuery(Allegado.class);
			Root<Allegado> person = cq.from(Allegado.class);
			Persona persona = new Persona();
			persona.setPerPk(Long.parseLong(pk));
			Predicate allFound = cb.equal(person.get("allPersona"), persona.getPerPk());
			cq.where(allFound);
			//retorna un allegado en base a una pk
			TypedQuery<Allegado> query = em.createQuery(cq);
			if (query.getResultList().size() == 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"No encontrado\"}");
			}
			return ResponseEntity.status(HttpStatus.OK).body(query.getResultList());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}
	// Obtiene la lista de allegados basado en la pk de la persona a la que pertenecen
	@GetMapping("/v2/{pk}")
	public ResponseEntity<?> getAllegadosv2(@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code, @PathVariable Long pk) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			List<Map<String, Object>> alle = personaRepository.getAll(pk);
			if (alle.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + "No encontrado" + "\"}");
			}
			return ResponseEntity.status(HttpStatus.OK).body(alle);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}
	//Obtiene un allegado basado en la persona a la pk de la persona referenciada
	@PostMapping("/")
	public ResponseEntity<?> getAllegado(@RequestBody Allegado all,
			@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			//Retorna la informacion de la tabla persona y allegados de un allegado
			List<AllegadoDTO> allegado = personaRepository.getAllegados(all.getAllPersona());
			if (allegado.size() == 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + "No encontrado" + "\"}");
			}
			return ResponseEntity.status(HttpStatus.OK).body(allegado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}
	//Actualiza la escolaridad de un allegado
	@PutMapping("/update/{pk}/{per}")
	public ResponseEntity<?> upAll(@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code, @PathVariable Integer pk,
			@PathVariable Integer per) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			personaRepository.updateAll(per, pk);
			return ResponseEntity.status(HttpStatus.OK).body("{\"Modificado\":\"Exito\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}
}
