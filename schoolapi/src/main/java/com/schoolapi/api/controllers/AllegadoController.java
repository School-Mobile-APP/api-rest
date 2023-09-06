package com.schoolapi.api.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.schoolapi.api.entities.AllegadoDTO;
import com.schoolapi.api.entities.Allegado;
import com.schoolapi.api.repositories.PersonaRepository;
import com.schoolapi.api.utils.JwtUtils;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/allegados")
public class AllegadoController {
	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private JwtUtils jwtUtils;
	@PostMapping("/")
	public ResponseEntity<?> getAllegado(@RequestBody Allegado all,@RequestHeader(value = "authorization", defaultValue = "") String auth,@RequestHeader(value = "code", defaultValue = "") String code) {
		try {
			if(auth.isEmpty() || auth==null || auth.isBlank() || code.isEmpty() || code==null || code.isBlank()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"Error\":\"No autorizado\"}");
			}
			if(!jwtUtils.checkToken(auth, code)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"Error\":\"No autorizado\"}");
			}
			List<AllegadoDTO> allegado=personaRepository.getAllegados(all.getAllPersonaReferenciada().getPerPk());
			if(allegado.size()==0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" +"No encontrado" + "\"}");
			}
			return ResponseEntity.status(HttpStatus.OK).body(allegado);
			} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"" + e.toString() + "\"}");
		}
	}
}
