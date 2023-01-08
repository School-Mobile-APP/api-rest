package com.ficha.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;
import javax.persistence.Table;
import java.time.LocalDateTime;
import javax.persistence.Version;
import javax.validation.constraints.Size;
@Entity
@Table(name = "sg_personas_discapacidades", uniqueConstraints = {
    @UniqueConstraint(name = "per_pk", columnNames = {"per_pk"})})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "perPk", scope = SgPersonaDiscapacidad.class)
public class SgPersonaDiscapacidad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "per_pk")
    private Long perdisPk;
    
    @Column(name = "dis_pk")
    private Integer escDispacacidad;


    public SgPersonaDiscapacidad() {
    }
    
    public Long getPerDisPk() {
        return perdisPk;
    }

    public void setPerDisPk(Long perdisPk) {
        this.perdisPk = perdisPk;
    }


    public Integer getDis() {
        return escDispacacidad;
    }

    public void setDis(Integer disPk) {
        this.escDispacacidad = disPk;
    }


    @Override
    public String toString() {
        return "sv.gob.mined.siges.persistencia.entidades.SgProfesion[ proPk=" + perdisPk + " ]";
    }

}