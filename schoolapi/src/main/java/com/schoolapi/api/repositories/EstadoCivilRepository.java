package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolapi.api.entities.EstadoCivil;

public interface EstadoCivilRepository extends JpaRepository<EstadoCivil, Long> {

}
