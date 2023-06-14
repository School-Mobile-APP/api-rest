package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolapi.api.entities.Canton;
@Repository
public interface CantonRepository extends JpaRepository<Canton, Long>{

}
