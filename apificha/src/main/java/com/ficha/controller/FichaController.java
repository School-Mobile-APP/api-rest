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
import com.ficha.model.SgFichaPasoCuatro;
import com.ficha.model.SgDatosResidencialesPersona;
import com.ficha.model.SgFichaPasoDos;
import com.ficha.model.SgFichaPasoTres;
import com.ficha.repository.DatosFichaRepository;
import com.ficha.repository.DatosPasoCuatroRepository;
import com.ficha.repository.DireccionRepository;
import com.ficha.repository.EstudianteRepository;
import com.ficha.repository.PersonaRepository;
import com.ficha.dto.SgFichaDatosCuatro;

@CrossOrigin
@RestController
@RequestMapping("/")
public class FichaController {
	@Autowired
	PersonaRepository personarepository;
	@Autowired
	DatosFichaRepository datosrepository;
	@Autowired
	DireccionRepository direccionrepository;
	@Autowired
	DatosPasoCuatroRepository datoscuatrorepository;
	@Autowired
	EstudianteRepository estudianterepository;

	@RequestMapping(value = { "/datos/{id}" }, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody SgFichaDatos getDatosFicha(@PathVariable("id") Long id) {
		SgFichaDatos datos = datosrepository.getFichaDatosPasoDos(id);
		return datos != null ? datos : null;
	}

	@RequestMapping(value = {
			"/datosCuatro/{id}" }, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody SgFichaDatosCuatro getDatosFichaPasoCuatro(@PathVariable("id") Long id) {
		SgFichaDatosCuatro datos = datoscuatrorepository.getFichaDatosPasoCuatro(id);
		return datos != null ? datos : null;
	}

	@RequestMapping(value = {
			"/pasoCuatro/{id}" }, method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	public @ResponseBody ResponseEntity<?> modificarPasoCuatro(@PathVariable("id") Long id,
			@RequestBody @Validated SgFichaPasoCuatro ficha) {
		String mensaje = "";
		SgDatosResidencialesPersona pasocuatromodificado = null;
		SgDatosResidencialesPersona registro = datoscuatrorepository.findById(id).orElse(null);
		try {
			System.out.println();
			if (registro == null) {
				registro = new SgDatosResidencialesPersona(id);
			}
			registro.setPerTieneServicioEnergiaElectricaResidencial(
					ficha.getPerTieneServicioEnergiaElectricaResidencial());
			registro.setPerFuenteAbastecimientoAguaResidencial(ficha.getPerFuenteAbastecimientoAguaResidencial());
			registro.setPeTieneServicioBasura(ficha.getPeTieneServicioBasura());
			pasocuatromodificado = datoscuatrorepository.save(registro);
			if (pasocuatromodificado != null) {
				mensaje = "Modificado correctamente";
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			mensaje = "Error" + e.toString();
		}
		return pasocuatromodificado != null ? ResponseEntity.status(200).body(registro)
				: ResponseEntity.status(201).body(mensaje);
	}

	@RequestMapping(value = {
			"/pasoDos/{id}" }, method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	public @ResponseBody ResponseEntity<?> modificarPasoDos(@PathVariable("id") Long id,
			@RequestBody @Validated SgFichaPasoDos ficha) {
		String mensaje = "";
		try {
			if(personarepository.updatePasoDos(ficha.getPerDui(),
					ficha.getPerPrimerNombre(), ficha.getPerSegundoNombre(), 
					ficha.getPerPrimerApellido(), ficha.getPerSegundoApellido(), 
					ficha.getPerFechaNacimiento(), ficha.getPerNacionalidad(), ficha.getPerRetornada(),
					ficha.getPerPartidaNacimientoPresenta(), ficha.getPerEtnia(), ficha.getPerTieneDiagnostico(), 
					ficha.getPerEmail(), 
					ficha.getPerTipoTrabajo(),
					ficha.getPerEstadoCivil(), ficha.getPerEmbarazo(), ficha.getPerTieneHijos(),
					ficha.getPerCantidadHijos(), ficha.getPerSexo(), ficha.getPerConvivenciaFamFk(), id)==1) {
				mensaje = "Modificado correctamente";
			}
		} catch (Exception e) {
			mensaje = e.toString();
		}
		return ResponseEntity.status(201).body(mensaje);
	}

	@RequestMapping(value = {
			"/pasoTres/{id}/{pk}" }, method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	public @ResponseBody ResponseEntity<?> modificarPasoTres(@PathVariable("id") Long id, @PathVariable("pk") Long pk,
			@RequestBody @Validated SgFichaPasoTres ficha) {
		String mensaje = "";
		try {
			if (direccionrepository.updateDir(ficha.getDirCaserioTexto(), ficha.getDirDepartamento(),
					ficha.getDirMunicipio(), ficha.getDirDireccion(), ficha.getDirZona(), ficha.getDirCanton(), id) == 1
					&& personarepository.updateTipoVivienda(ficha.getPerTipoViviendaFk(), pk) == 1) {
				mensaje = "Modificado correctamente";
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			mensaje = e.toString();
		}
		return ResponseEntity.status(201).body(mensaje);
	}

	@RequestMapping(value = {
			"/internet/{internet}/{pk}" }, method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	public @ResponseBody ResponseEntity<?> modificarInternet(@PathVariable("internet") Boolean internet,
			@PathVariable("pk") Long pk) {
		String mensaje = "";
		try {
			if (personarepository.updateAccesoInternet(internet, pk) == 1) {
				mensaje = "Modificado correctamente";
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			mensaje = e.toString();
		}
		return ResponseEntity.status(201).body(mensaje);
	}

	@RequestMapping(value = {
			"/estudiantePasoCinco/{modalidad}/{diez}/{pk}" }, method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	public @ResponseBody ResponseEntity<?> modificarEst(@PathVariable("modalidad") Long modalidad,
			@PathVariable("diez") Boolean diez,
			@PathVariable("pk") Long pk) {
		String mensaje = "";
		try {
			if (estudianterepository.updatePasoCinco(diez,modalidad,pk) == 1) {
				mensaje = "Modificado correctamente";
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			mensaje = e.toString();
		}
		return ResponseEntity.status(201).body(mensaje);
	}

}
