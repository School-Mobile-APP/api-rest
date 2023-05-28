package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolapi.api.entities.FuentesAgua;

@Repository
public interface FuentesAguaRepository extends JpaRepository<FuentesAgua, Long>{
}
