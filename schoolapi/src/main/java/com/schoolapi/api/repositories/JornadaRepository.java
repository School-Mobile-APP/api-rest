package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolapi.api.entities.Jornada;

@Repository
public interface JornadaRepository extends JpaRepository<Jornada, Long>{

}
