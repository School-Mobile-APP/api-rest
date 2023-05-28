package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.schoolapi.api.entities.ReferenciasApoyo;
@Service
public interface ReferenciasApoyoRepository extends JpaRepository<ReferenciasApoyo, Long> {

}
