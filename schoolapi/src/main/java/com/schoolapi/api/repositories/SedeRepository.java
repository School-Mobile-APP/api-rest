package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolapi.api.entities.Sede;
@Repository
public interface SedeRepository extends JpaRepository<Sede,Long>{

}
