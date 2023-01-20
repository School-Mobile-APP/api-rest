package com.ficha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ficha.model.SgCanalesAtencion;

public interface CanalesRepository extends JpaRepository<SgCanalesAtencion,Long>{
	
}
