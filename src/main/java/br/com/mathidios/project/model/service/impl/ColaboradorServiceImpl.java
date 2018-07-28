package br.com.mathidios.project.model.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.mathidios.project.model.dao.ColaboradorDAO;
import br.com.mathidios.project.model.dto.ColaboradorDTO;
import br.com.mathidios.project.model.dto.SetorDTO;
import br.com.mathidios.project.model.entity.Colaborador;
import br.com.mathidios.project.model.exception.BusinessException;
import br.com.mathidios.project.model.service.ColaboradorService;

@Service
public class ColaboradorServiceImpl implements ColaboradorService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ColaboradorDAO colaboradorDAO;

	@Override
	public Colaborador create(Colaborador colaborador) {
		try {
			return this.colaboradorDAO.save(colaborador);			
		} catch (Exception e) {
			this.log.error("Erro ao criar colaborador", e);
			throw new BusinessException("Erro ao criar colaborador", e);
		}
	}

	@Override
	public List<SetorDTO> findAll() {
		try {
			
			List<Colaborador> colaboradorList = this.colaboradorDAO.findAll();
			
			if((colaboradorList != null && !colaboradorList.isEmpty())) {
				
				LinkedHashMap<String, List<ColaboradorDTO>> mapColabAgrupadoSetor = new LinkedHashMap<String, List<ColaboradorDTO>>();
				
				List<SetorDTO> colaboradorAgrupadoSetorDTOList = new ArrayList<SetorDTO>();
				
				colaboradorList.forEach(colab -> {
					
					if(mapColabAgrupadoSetor.get(colab.getNmSetor()) == null) {
						
						List<ColaboradorDTO> colabDTOList = new ArrayList<ColaboradorDTO>();
						ColaboradorDTO colabDTO = new ColaboradorDTO(colab.getNmColab(), colab.getEmailColab());
						colabDTOList.add(colabDTO);
						mapColabAgrupadoSetor.put(colab.getNmSetor(), colabDTOList);
						
					} else {
						
						List<ColaboradorDTO> colabDTOList = mapColabAgrupadoSetor.get(colab.getNmSetor());
						colabDTOList.add(new ColaboradorDTO(colab.getNmColab(), colab.getEmailColab()));
					}
					
				});
				
				mapColabAgrupadoSetor.entrySet().stream().forEach(m -> {
					SetorDTO setorDTO = new SetorDTO(m.getKey());
					setorDTO.setColaboradorDTOList(m.getValue());
					colaboradorAgrupadoSetorDTOList.add(setorDTO);
				});
				
				return colaboradorAgrupadoSetorDTOList;
			} 
			
			return null;			
		} catch (Exception e) {
			this.log.error("Erro ao criar todos colaboradores", e);
			throw new BusinessException("Erro ao recuperar colaborador", e);
		}
	}

	@Override
	public Colaborador findByIdColab(Long idColab) {
		try {
			Optional<Colaborador> planet = this.colaboradorDAO.findById(idColab);
			return planet.orElse(null);			
		} catch (Exception e) {
			this.log.error("Erro ao recuperar colaborador id " + idColab, e);
			throw new BusinessException("Erro ao recuperar colaborador", e);
		}
	}

	@Override
	public void deleteByIdColab(Long idColab) {
		try {
			this.colaboradorDAO.deleteById(idColab);
		} catch (EmptyResultDataAccessException empty) {
			this.log.error("Erro ao deletar colab id " + idColab + " Registro não existente!", empty);
			throw empty;
		} catch (Exception e) {
			this.log.error("Erro ao deletar colab id " + idColab, e);
			throw new BusinessException("Erro ao deletar colab", e);
		}
	}

}
