package br.com.mathidios.project.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="COLABORADOR")
public class Colaborador {

	@Id
	@Column(name = "ID_COLAB")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idColab;
	
	@Column(name = "NM_COLAB")
	@NotNull
	private String nmColab;
	
	@Column(name = "CPF_COLAB")
	@NotNull
	private String cpfColab;
	
	@Column(name = "TEL_COLAB")
	@NotNull
	private String telColab;
	
	@Column(name = "EMAIL_COLAB")
	@NotNull
	@Email
	private String emailColab;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_SETOR")
	@NotNull
	private Setor setor;
	
	@Transient
	private String nmSetor;
	
	public Colaborador() {
		super();
	}
	
	public Colaborador(String nmSetor, String nmColab, String emailColab, Long idColab) {
		super();
		this.nmSetor = nmSetor;
		this.nmColab = nmColab;
		this.emailColab = emailColab;
		this.idColab = idColab;
	}

	public Long getIdColab() {
		return idColab;
	}

	public void setIdColab(Long idColab) {
		this.idColab = idColab;
	}

	public String getNmColab() {
		return nmColab;
	}

	public void setNmColab(String nmColab) {
		this.nmColab = nmColab;
	}

	public String getCpfColab() {
		return cpfColab;
	}

	public void setCpfColab(String cpfColab) {
		this.cpfColab = cpfColab;
	}

	public String getTelColab() {
		return telColab;
	}

	public void setTelColab(String telColab) {
		this.telColab = telColab;
	}

	public String getEmailColab() {
		return emailColab;
	}

	public void setEmailColab(String emailColab) {
		this.emailColab = emailColab;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
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
		result = prime * result + ((cpfColab == null) ? 0 : cpfColab.hashCode());
		result = prime * result + ((emailColab == null) ? 0 : emailColab.hashCode());
		result = prime * result + ((idColab == null) ? 0 : idColab.hashCode());
		result = prime * result + ((nmColab == null) ? 0 : nmColab.hashCode());
		result = prime * result + ((setor == null) ? 0 : setor.hashCode());
		result = prime * result + ((telColab == null) ? 0 : telColab.hashCode());
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
		Colaborador other = (Colaborador) obj;
		if (cpfColab == null) {
			if (other.cpfColab != null)
				return false;
		} else if (!cpfColab.equals(other.cpfColab))
			return false;
		if (emailColab == null) {
			if (other.emailColab != null)
				return false;
		} else if (!emailColab.equals(other.emailColab))
			return false;
		if (idColab == null) {
			if (other.idColab != null)
				return false;
		} else if (!idColab.equals(other.idColab))
			return false;
		if (nmColab == null) {
			if (other.nmColab != null)
				return false;
		} else if (!nmColab.equals(other.nmColab))
			return false;
		if (setor == null) {
			if (other.setor != null)
				return false;
		} else if (!setor.equals(other.setor))
			return false;
		if (telColab == null) {
			if (other.telColab != null)
				return false;
		} else if (!telColab.equals(other.telColab))
			return false;
		return true;
	}
	
}
