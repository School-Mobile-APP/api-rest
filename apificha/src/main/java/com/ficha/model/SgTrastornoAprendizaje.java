package com.ficha.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

public class SgTrastornoAprendizaje implements Serializable {
	 private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "tra_pk")
	    private Long traPk;

	    @Size(max = 4)
	    @Column(name = "tra_codigo", length = 4)
	    private String traCodigo;
	    public Long getTraPk() {
	        return traPk;
	    }

	    public void setTraPk(Long traPk) {
	        this.traPk = traPk;
	    }

	    public String getTraCodigo() {
	        return traCodigo;
	    }

	    public void setTraCodigo(String traCodigo) {
	        this.traCodigo = traCodigo;
	    }
}
