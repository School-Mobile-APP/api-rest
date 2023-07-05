package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolapi.api.entities.PersonaElementoHogarPk;

@Repository
public interface PersonaElementosHogarRepository extends JpaRepository<PersonaElementoHogarPk, Long> {

}
