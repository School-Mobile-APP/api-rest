package com.schoolapi.api.controllers;

import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolapi.api.entities.Allegado;
import com.schoolapi.api.entities.Canton;
import com.schoolapi.api.entities.DatosResidenciales;
import com.schoolapi.api.entities.Direccion;
import com.schoolapi.api.entities.Estudiante;
import com.schoolapi.api.entities.EstudianteCanal;
import com.schoolapi.api.entities.Persona;
import com.schoolapi.api.entities.PersonaDTO;
import com.schoolapi.api.entities.PersonaElementoHogarPk;
import com.schoolapi.api.entities.TelefonoDTO;
import com.schoolapi.api.repositories.CantonRepository;
import com.schoolapi.api.repositories.DireccionRepository;
import com.schoolapi.api.repositories.EstudianteCanalAtencionRepository;
import com.schoolapi.api.repositories.EstudianteRepository;
import com.schoolapi.api.repositories.IngresosRepository;
import com.schoolapi.api.repositories.PersonaElementosHogarRepository;
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
@RequestMapping("/personas")
public class PersonaController {
	@PersistenceContext
	EntityManager em;
	@Autowired
	private EstudianteCanalAtencionRepository estudianteCanalAtencionRepository;
	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private PersonaElementosHogarRepository personaElementosHogarRepository;
	@Autowired
	private EstudianteRepository estudianteRepository;
	@Autowired
	private IngresosRepository ingresosRepository;
	@Autowired
	private DireccionRepository direccionRepository;
	@Autowired
	private CantonRepository cantonRepository;
	@Autowired
	private JwtUtils jwtUtils;

	@GetMapping("/telefono/{pk}")
	public ResponseEntity<?> getAllegadosTelefonos(
			@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code, @PathVariable("pk") Long pk) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			List<TelefonoDTO> telefonosDtos = personaRepository.getTelefonosAllegado(pk);
			return ResponseEntity.status(HttpStatus.OK).body(telefonosDtos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@GetMapping("/{dui}")
	public ResponseEntity<?> getPerson(@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code, @PathVariable String dui) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
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
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@GetMapping("/matriculaByNie/{nie}")
	public ResponseEntity<?> getMatByNie(@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code, @PathVariable Long nie) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			Long estPk = estudianteRepository.getEstPkByNie(nie);
			if (estPk == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + "No encontrado" + "\"}");
			}
			return ResponseEntity.status(HttpStatus.OK).body("{\"EstPk\":\"" + estPk + "\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@GetMapping("/notas/{nie}")
	public ResponseEntity<?> getNotas(@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code, @PathVariable Long nie) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			List<Map<String, Object>> notas = personaRepository.getNotasv2(nie);
			if (notas.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + "No encontrado" + "\"}");
			}
			return ResponseEntity.status(HttpStatus.OK).body(notas);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@GetMapping("/notas/materias/{nie}")
	public ResponseEntity<?> getNotasMateria(@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code, @PathVariable Long nie) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			List<Map<String, Object>> notas = personaRepository.getNotasMaterias(nie);
			if (notas.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + "No encontrado" + "\"}");
			}
			return ResponseEntity.status(HttpStatus.OK).body(notas);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@GetMapping("/notasnonumericas")
	public ResponseEntity<?> getNotasNoNumericas(@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			List<Map<String, Object>> notas = personaRepository.getNotasNoNumericas();
			if (notas.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + "No encontrado" + "\"}");
			}
			return ResponseEntity.status(HttpStatus.OK).body(notas);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@GetMapping("/nie/{nie}")
	public ResponseEntity<?> getPersonNie(@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code, @PathVariable String nie) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<PersonaDTO> cq = cb.createQuery(PersonaDTO.class);
			Root<PersonaDTO> person = cq.from(PersonaDTO.class);
			Predicate duiFound = cb.equal(person.get("perNie"), nie);
			cq.where(duiFound);
			TypedQuery<PersonaDTO> query = em.createQuery(cq);
			if (query.getResultList().size() == 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"No encontrado\"}");
			}
			return ResponseEntity.status(HttpStatus.OK).body(query.getResultList());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@PostMapping("/elementos/")
	public ResponseEntity<?> addElemento(@RequestBody PersonaElementoHogarPk perEl,
			@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			PersonaElementoHogarPk perEleNuevo = personaElementosHogarRepository.save(perEl);
			return ResponseEntity.status(HttpStatus.OK).body(perEleNuevo);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@PutMapping("/internet")
	public ResponseEntity<?> actualizarInternet(@RequestBody Persona per,
			@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			personaRepository.updateInternet(per.getPerAccesoInternet(), per.getPerPk());
			return ResponseEntity.status(HttpStatus.OK).body("{\"Modificado\":\"Exito\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@PutMapping("/pasoSeis")
	public ResponseEntity<?> actualizarPasoSeis(@RequestBody Persona per,
			@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			personaRepository.updatePasoSeis(per.getPerDui(), per.getPerPrimerNombre(), per.getPerSegundoNombre(),
					per.getPerPrimerApellido(), per.getPerSegundoApellido(), per.getPerEmail(),
					per.getPerEscolaridadFk(), per.getPerPk());
			return ResponseEntity.status(HttpStatus.OK).body("{\"Modificado\":\"Exito\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@PutMapping("/parentesco")
	public ResponseEntity<?> actualizarAllegado(@RequestBody Allegado all,
			@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			personaRepository.updateParentesco(all.getAllTipoParentesco(), all.getAllPersona());
			return ResponseEntity.status(HttpStatus.OK).body("{\"Modificado\":\"Exito\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@PutMapping("/internetResidencial")
	public ResponseEntity<?> actualizarInternet(@RequestBody DatosResidenciales dat,
			@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			personaRepository.updateInternetResidencial(dat.getPerTieneConexionInternetResidencial(), dat.getPerPk());
			return ResponseEntity.status(HttpStatus.OK).body("{\"Exito\":\"Modificado correctamente\"}");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@PostMapping("/estCanal")
	public ResponseEntity<?> addElemento(@RequestBody EstudianteCanal estCan,
			@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			EstudianteCanal estudianteCanal = estudianteCanalAtencionRepository.save(estCan);
			return ResponseEntity.status(HttpStatus.OK).body(estudianteCanal);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@PutMapping("/direccion")
	public ResponseEntity<?> updateDireccion(@RequestBody Direccion dir,
			@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			direccionRepository.updateDireccion(dir.getDirDireccion(), dir.getMunicipio().getMunPk(),
					dir.getDepartamento().getDepPk(), dir.getDirCaserioTexto(), dir.getDirZona().getZonPk(),
					dir.getDirPk());
			return ResponseEntity.status(HttpStatus.OK).body("{\"Exito\":\"Modificado correctamente\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@PutMapping("/vivienda")
	public ResponseEntity<?> updateVivienda(@RequestBody Persona per,
			@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			personaRepository.updateTipoVivienda(per.getPerTipoViviendaFk(), per.getPerPk());
			return ResponseEntity.status(HttpStatus.OK).body("{\"Exito\":\"Modificado correctamente\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@GetMapping("/est/")
	public ResponseEntity<?> getEst(@RequestBody Estudiante est,
			@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(estudianteRepository.findById(est.getEstPk()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@PutMapping("/canton")
	public ResponseEntity<?> updateCanton(@RequestBody Direccion can,
			@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			if (can.getCanton().getCanPk() == 0) {
				direccionRepository.updateCanton(null, can.getDirPk());
				return ResponseEntity.status(HttpStatus.OK).body("{\"Exito\":\"Modificado correctamente\"}");
			} else {
				direccionRepository.updateCanton(can.getCanton().getCanPk(), can.getDirPk());
				return ResponseEntity.status(HttpStatus.OK).body("{\"Exito\":\"Modificado correctamente\"}");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@PostMapping("/canton")
	public ResponseEntity<?> addCanton(@RequestBody Canton can,
			@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			Canton cantonAgregado = cantonRepository.save(can);
			return ResponseEntity.status(HttpStatus.OK).body(cantonAgregado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@PutMapping("/perfil")
	public ResponseEntity<?> updatePerfil(@RequestBody Persona per,
			@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			personaRepository.updatePerfil(per.getPerPrimerNombre(), per.getPerSegundoNombre(),
					per.getPerPrimerApellido(), per.getPerSegundoApellido(), per.getPerFechaNacimiento(),
					per.getPerEmail(), per.getPerPk());
			return ResponseEntity.status(HttpStatus.OK).body("{\"Exito\":\"Modificado correctamente\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@PutMapping("/estPasoCinco/")
	public ResponseEntity<?> updatePasoCinco(@RequestBody Estudiante est,
			@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			estudianteRepository.updateEstudiante(est.getModalidad().getMulPk(), est.getEstSintonizaCanal10(),
					est.getEstPersona().getPerPk());
			return ResponseEntity.status(HttpStatus.OK).body("{\"Exito\":\"Modificado correctamente\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@GetMapping("/ingresos")
	public ResponseEntity<?> getIn(@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			return ResponseEntity.status(HttpStatus.OK).body(ingresosRepository.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@PutMapping("/pasoDosIngresos/{in}/{pk}")
	public ResponseEntity<?> updatePasoDosIngresos(
			@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code,@PathVariable("in") Integer in,@PathVariable("pk") Integer pk) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			personaRepository.updatePerDos(in,pk);
			return ResponseEntity.status(HttpStatus.OK).body("{\"Exito\":\"Modificado correctamente\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@PutMapping("/pasoDos")
	public ResponseEntity<?> updatePasoDos(@RequestBody Persona per,
			@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			long ttrPk = per.getPerTipoTrabajo().getTtrPk();
			if (ttrPk != 0) {
				personaRepository.updatePasoDos(per.getPerDui(), per.getPerPrimerNombre(), per.getPerSegundoNombre(),
						per.getPerPrimerApellido(), per.getPerSegundoApellido(), per.getNacionalidad().getNacPk(),
						per.getPerRetornada(), per.getPerPartidaNacimientoPosee(), per.getSexo().getSexPk(),
						per.getEtnia().getEtnPk(), per.getPerTieneDiagnostico(), per.getPerEmail(), ttrPk,
						per.getPerEstadoCivil().getEciPk(), per.getPerConvivenciaFamFk(), per.getPerEmbarazo(),
						per.getPerTieneHijos(), per.getPerCantidadHijos(), per.getPerFechaNacimiento(), per.getPerPk(),
						per.getPerViveConCantidad());
			} else {
				personaRepository.updatePasoDos(per.getPerDui(), per.getPerPrimerNombre(), per.getPerSegundoNombre(),
						per.getPerPrimerApellido(), per.getPerSegundoApellido(), per.getNacionalidad().getNacPk(),
						per.getPerRetornada(), per.getPerPartidaNacimientoPosee(), per.getSexo().getSexPk(),
						per.getEtnia().getEtnPk(), per.getPerTieneDiagnostico(), per.getPerEmail(), null,
						per.getPerEstadoCivil().getEciPk(), per.getPerConvivenciaFamFk(), per.getPerEmbarazo(),
						per.getPerTieneHijos(), per.getPerCantidadHijos(), per.getPerFechaNacimiento(), per.getPerPk(),
						per.getPerViveConCantidad());
			}
			return ResponseEntity.status(HttpStatus.OK).body("{\"Exito\":\"Modificado correctamente\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@PutMapping("/pasoCuatro")
	public ResponseEntity<?> updatePasoCuatro(@RequestBody DatosResidenciales dat,
			@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			personaRepository.updatePasoCuatro(dat.getPeTieneServicioBasura(),
					dat.getPerFuenteAbastecimientoAguaResidencial(),
					dat.getPerTieneServicioEnergiaElectricaResidencial(), dat.getPerPk());
			return ResponseEntity.status(HttpStatus.OK).body("{\"Exito\":\"Modificado correctamente\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@DeleteMapping("/elementos/{id}")
	public ResponseEntity<?> deleteDiscapacidad(@PathVariable("id") Long id,
			@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			personaElementosHogarRepository.deleteElementos(id);
			return ResponseEntity.status(HttpStatus.OK).body("{\"Mensaje\":\"Eliminado\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}

	@DeleteMapping("/canales/{id}")
	public ResponseEntity<?> deleteCanal(@PathVariable("id") Long id,
			@RequestHeader(value = "authorization", defaultValue = "") String auth,
			@RequestHeader(value = "code", defaultValue = "") String code) {
		try {
			if (auth.isEmpty() || auth == null || auth.isBlank() || code.isEmpty() || code == null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if (!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			estudianteCanalAtencionRepository.deleteCanalesEstudiantes(id);
			return ResponseEntity.status(HttpStatus.OK).body("{\"Mensaje\":\"Eliminado\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}
}
