package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolapi.api.entities.EstudianteCanal;

@Repository
public interface EstudianteCanalAtencionRepository extends JpaRepository<EstudianteCanal, Long>{

}
