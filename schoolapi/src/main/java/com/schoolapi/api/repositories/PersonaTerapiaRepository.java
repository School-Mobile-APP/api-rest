package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolapi.api.entities.PersonaTerapia;

@Repository
public interface PersonaTerapiaRepository extends JpaRepository<PersonaTerapia, Long> {

}
