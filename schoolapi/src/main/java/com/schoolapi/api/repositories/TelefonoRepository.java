package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolapi.api.entities.Telefono;

@Repository
public interface TelefonoRepository extends JpaRepository<Telefono,Long> {

}
