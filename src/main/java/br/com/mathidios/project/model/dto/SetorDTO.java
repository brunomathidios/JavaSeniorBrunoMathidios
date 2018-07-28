package br.com.mathidios.project.model.dto;

import java.util.ArrayList;
import java.util.List;

public class SetorDTO {
	
	private String nome;
	private List<ColaboradorDTO> colaboradorDTOList;
	
	public SetorDTO() {
		super();
	}
	
	public SetorDTO(String nome) {
		super();
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<ColaboradorDTO> getColaboradorDTOList() {
		if(this.colaboradorDTOList == null) {
			this.colaboradorDTOList = new ArrayList<ColaboradorDTO>();
		}
		return colaboradorDTOList;
	}
	
	public void setColaboradorDTOList(List<ColaboradorDTO> colaboradorDTOList) {
		this.colaboradorDTOList = colaboradorDTOList;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colaboradorDTOList == null) ? 0 : colaboradorDTOList.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		SetorDTO other = (SetorDTO) obj;
		if (colaboradorDTOList == null) {
			if (other.colaboradorDTOList != null)
				return false;
		} else if (!colaboradorDTOList.equals(other.colaboradorDTOList))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
}
