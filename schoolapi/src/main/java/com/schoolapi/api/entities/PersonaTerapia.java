package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "sg_personas_terapias",schema="centros_educativos")
@IdClass(value = PersonaTerapiaPk.class)
public class PersonaTerapia implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    private Long per_pk;
    @Id
    private Long ter_pk;
}
