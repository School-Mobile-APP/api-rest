package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolapi.api.entities.Zona;

@Repository
public interface ZonaRepository extends JpaRepository<Zona, Long>{

}
