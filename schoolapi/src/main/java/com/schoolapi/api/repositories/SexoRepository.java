package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolapi.api.entities.Sexo;

@Repository
public interface SexoRepository extends JpaRepository<Sexo,Long>{
	
}
