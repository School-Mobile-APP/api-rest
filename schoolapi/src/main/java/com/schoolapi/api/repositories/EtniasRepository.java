package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolapi.api.entities.Etnia;

@Repository
public interface EtniasRepository extends JpaRepository<Etnia, Long>{

}
