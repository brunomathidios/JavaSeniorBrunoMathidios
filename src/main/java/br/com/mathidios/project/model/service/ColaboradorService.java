package br.com.mathidios.project.model.service;

import java.util.List;

import br.com.mathidios.project.model.dto.SetorDTO;
import br.com.mathidios.project.model.entity.Colaborador;

public interface ColaboradorService {

	Colaborador create(Colaborador colaborador);
	List<SetorDTO> findAll();
	Colaborador findByIdColab(Long idColab);
	void deleteByIdColab(Long idColab);
}
