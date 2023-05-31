package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolapi.api.entities.Persona;
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{

}
