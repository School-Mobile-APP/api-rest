package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolapi.api.entities.TipoParentesco;

@Repository
public interface TipoParentescoRepository extends JpaRepository<TipoParentesco, Long>{

}
