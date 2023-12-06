package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.schoolapi.api.entities.Ingresos;

@Repository
public interface IngresosRepository extends JpaRepository<Ingresos, Long>{

}
