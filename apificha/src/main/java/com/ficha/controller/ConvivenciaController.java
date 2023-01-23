package com.ficha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ficha.model.SgConvivenciaFamiliar;
import com.ficha.repository.ConvivenciaFamiliarRepository;

@CrossOrigin
@RestController
@RequestMapping("/")
public class ConvivenciaController {
	@Autowired 
	ConvivenciaFamiliarRepository convivenciarepository;
	@RequestMapping(value= {"/convivencia"},method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody List<SgConvivenciaFamiliar> getDatosFicha(){
		List<SgConvivenciaFamiliar> datos=convivenciarepository.findAll();
		return datos!=null?datos:null;
	}
}
