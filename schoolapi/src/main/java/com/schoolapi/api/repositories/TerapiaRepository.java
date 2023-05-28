package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolapi.api.entities.Terapia;

@Repository
public interface TerapiaRepository extends JpaRepository<Terapia,Long>{

}
