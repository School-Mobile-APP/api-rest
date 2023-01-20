package com.ficha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ficha.model.SgTipoVivienda;
import com.ficha.repository.TipoViviendaRepository;

@CrossOrigin
@RestController
@RequestMapping("/")
public class TipoViviendaController {
	@Autowired
	TipoViviendaRepository viviendarepository;
	@RequestMapping(value= {"/vivienda"},method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody List<SgTipoVivienda> getViviendas(){
		List<SgTipoVivienda> datos=viviendarepository.findAll();
		return datos!=null?datos:null;
	}
}
