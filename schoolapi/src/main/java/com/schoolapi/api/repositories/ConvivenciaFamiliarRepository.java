package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolapi.api.entities.ConvivenciaFamiliar;

@Repository
public interface ConvivenciaFamiliarRepository extends JpaRepository<ConvivenciaFamiliar, Long>{

}
