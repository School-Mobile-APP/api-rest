package com.schoolapi.api.entities;

public interface AllegadoDTO {
		public Long getAll_pk();
		public Long getAll_tipo_parentesco();
		public Long getAll_persona();
		public Long getPer_pk();
		public String getPer_primer_nombre();
		public String getPer_segundo_nombre();
		public String getPer_primer_apellido();
		public String getPer_segundo_apellido();
		public String getPer_email();
		public String getPer_dui();
		public String getPer_escolaridad_fk();
		public Boolean getAll_referente();
}
