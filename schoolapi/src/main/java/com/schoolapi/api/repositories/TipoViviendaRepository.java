package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolapi.api.entities.TipoVivienda;

@Repository
public interface TipoViviendaRepository extends JpaRepository<TipoVivienda, Long>{

}
