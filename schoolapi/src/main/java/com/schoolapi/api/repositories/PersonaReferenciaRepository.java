package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolapi.api.entities.PersonaReferencia;

@Repository
public interface PersonaReferenciaRepository extends JpaRepository<PersonaReferencia, Long> {

}
