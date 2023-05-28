package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolapi.api.entities.TipoTrabajo;
@Repository
public interface TipoTrabajoRepository extends JpaRepository<TipoTrabajo, Long>{

}
