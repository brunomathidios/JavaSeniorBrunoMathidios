package br.com.mathidios.project.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SETOR")
public class Setor {

	@Id
	@Column(name = "ID_SETOR")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSetor;
	
	@Column(name = "NM_SETOR")
	private String nmSetor;

	public Long getIdSetor() {
		return idSetor;
	}

	public void setIdSetor(Long idSetor) {
		this.idSetor = idSetor;
	}

	public String getNmSetor() {
		return nmSetor;
	}

	public void setNmSetor(String nmSetor) {
		this.nmSetor = nmSetor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idSetor == null) ? 0 : idSetor.hashCode());
		result = prime * result + ((nmSetor == null) ? 0 : nmSetor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Setor other = (Setor) obj;
		if (idSetor == null) {
			if (other.idSetor != null)
				return false;
		} else if (!idSetor.equals(other.idSetor))
			return false;
		if (nmSetor == null) {
			if (other.nmSetor != null)
				return false;
		} else if (!nmSetor.equals(other.nmSetor))
			return false;
		return true;
	}
	
}
