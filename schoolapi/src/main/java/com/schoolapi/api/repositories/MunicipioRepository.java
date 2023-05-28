package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolapi.api.entities.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository <Municipio, Long>{

}
