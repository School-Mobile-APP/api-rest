package com.schoolapi.api.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.schoolapi.api.entities.DatosResidenciales;
import com.schoolapi.api.entities.Estudiante;
import com.schoolapi.api.entities.EstudianteCanal;
import com.schoolapi.api.entities.Persona;
import com.schoolapi.api.entities.PersonaElementoHogarPk;
import com.schoolapi.api.repositories.EstudianteCanalAtencionRepository;
import com.schoolapi.api.repositories.EstudianteRepository;
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
	@Autowired
	private EstudianteRepository estudianteRepository;

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
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"No encontrado\"}");
			}
			return ResponseEntity.status(HttpStatus.OK).body(query.getResultList());
			// return
			// ResponseEntity.status(HttpStatus.OK).body(personaService.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@PostMapping("/elementos/")
	public ResponseEntity<?> addElemento(@RequestBody PersonaElementoHogarPk perEl) {
		try {
			PersonaElementoHogarPk perEleNuevo = personaElementosHogarRepository.save(perEl);
			return ResponseEntity.status(HttpStatus.OK).body(perEleNuevo);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@PutMapping("/internet")
	public ResponseEntity<?> actualizarInternet(@RequestBody Persona per) {
		try {
			Integer actualizado = personaRepository.updateInternet(per.getPerAccesoInternet(), per.getPerPk());
			if (actualizado == 1) {
				return ResponseEntity.status(HttpStatus.OK).body("{\"Modificado\":" + "Exito" + "}");
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":" + "No se modificó" + "}");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@PutMapping("/pasoSeis")
	public ResponseEntity<?> actualizarPasoSeis(@RequestBody Persona per) {
		try {
			Integer actualizado = personaRepository.updatePasoSeis(per.getPerDui(), per.getPerPrimerNombre(),
					per.getPerSegundoNombre(), per.getPerPrimerApellido(), per.getPerSegundoApellido(),
					per.getPerEmail(), per.getPerEscolaridadFk(), per.getPerPk());
			if (actualizado == 1) {
				return ResponseEntity.status(HttpStatus.OK).body("{\"Modificado\":" + "Exito" + "}");
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Datos incorrectos\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":" + e.toString() + "}");
		}
	}

	@PutMapping("/internetResidencial")
	public ResponseEntity<?> actualizarInternet(@RequestBody DatosResidenciales dat) {
		try {
			Integer actualizado = personaRepository
					.updateInternetResidencial(dat.getPerTieneConexionInternetResidencial(), dat.getPerPk());
			if (actualizado == 1) {
				return ResponseEntity.status(HttpStatus.OK).body("{\"Exito\":\"Modificado correctamente\"}");
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

	@PutMapping("/perfil")
	public ResponseEntity<?> updatePerfil(@RequestBody Persona per) {
		try {
			if (personaRepository.updatePerfil(per.getPerPrimerNombre(), per.getPerSegundoNombre(),
					per.getPerPrimerApellido(), per.getPerSegundoApellido(), per.getPerFechaNacimiento(),
					per.getPerEmail(), per.getPerPk()) == 1) {
				return ResponseEntity.status(HttpStatus.OK).body("{\"Exito\":\"Modificado correctamente\"}");
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Datos incorrectos\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":" + e.toString() + "}");
		}
	}

	@PutMapping("/estPasoCinco/")
	public ResponseEntity<?> updatePasoCinco(@RequestBody Estudiante est) {
		try {
			if (estudianteRepository.updateEstudiante(est.getModalidad().getMulPk(), est.getEstSintonizaCanal10(),
					est.getEstPersona()) == 1) {
				return ResponseEntity.status(HttpStatus.OK).body("{\"Exito\":\"Modificado correctamente\"}");
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Datos incorrectos\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":" + e.toString() + "}");
		}
	}

	@PutMapping("/pasoDos")
	public ResponseEntity<?> updatePasoDos(@RequestBody Persona per) {
		try {
			System.out.print(per.getEtnia().getEtnPk());

			if (personaRepository.updatePasoDos(per.getPerDui(), per.getPerPrimerNombre(), per.getPerSegundoNombre(),
					per.getPerPrimerApellido(), per.getPerSegundoApellido(), per.getNacionalidad().getNacPk(),
					per.getPerRetornada(), per.getPerPartidaNacimientoPosee(), per.getSexo().getSexPk(),
					per.getEtnia().getEtnPk(), per.getPerTieneDiagnostico(), per.getPerEmail(),
					per.getPerTipoTrabajo().getTtrPk(), per.getPerEstadoCivil().getEciPk(),
					per.getPerConvivenciaFamFk(), per.getPerEmbarazo(), per.getPerTieneHijos(),
					per.getPerCantidadHijos(), per.getPerFechaNacimiento(), per.getPerPk()) == 1) {
				return ResponseEntity.status(HttpStatus.OK).body("{\"Exito\":\"Modificado correctamente\"}");
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Datos incorrectos\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":" + e.toString() + "}");
		}
	}

	@PutMapping("/pasoCuatro")
	public ResponseEntity<?> updatePasoCuatro(@RequestBody DatosResidenciales dat) {
		try {
			if (personaRepository.updatePasoCuatro(dat.getPeTieneServicioBasura(),
					dat.getPerFuenteAbastecimientoAguaResidencial(),
					dat.getPerTieneServicioEnergiaElectricaResidencial(), dat.getPerPk()) == 1) {
				return ResponseEntity.status(HttpStatus.OK).body("{\"Exito\":\"Modificado correctamente\"}");
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Datos incorrectos\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":" + e.toString() + "}");
		}
	}

	@DeleteMapping("/elementos/{id}")
	public ResponseEntity<?> deleteDiscapacidad(@PathVariable("id") Long id) {
		try {
			personaElementosHogarRepository.deleteElementos(id);
			return ResponseEntity.status(HttpStatus.OK).body("{\"Mensaje\":\"" + "Eliminado" + "\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@DeleteMapping("/canales/{id}")
	public ResponseEntity<?> deleteCanal(@PathVariable("id") Long id) {
		try {
			estudianteCanalAtencionRepository.deleteCanalesEstudiantes(id);
			return ResponseEntity.status(HttpStatus.OK).body("{\"Mensaje\":\"" + "Eliminado" + "\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}
}
