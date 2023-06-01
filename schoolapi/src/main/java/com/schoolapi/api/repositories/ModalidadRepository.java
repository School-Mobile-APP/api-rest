package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolapi.api.entities.Modalidad;

@Repository
public interface ModalidadRepository extends JpaRepository<Modalidad, Long>{

}
