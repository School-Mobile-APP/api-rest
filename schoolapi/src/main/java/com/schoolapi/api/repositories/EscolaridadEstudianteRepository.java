package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolapi.api.entities.EscolaridadEstudiante;

@Repository
public interface EscolaridadEstudianteRepository extends JpaRepository<EscolaridadEstudiante,Long>{
}
