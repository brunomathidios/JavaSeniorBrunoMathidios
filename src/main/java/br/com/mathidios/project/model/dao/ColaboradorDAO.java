package br.com.mathidios.project.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.mathidios.project.model.entity.Colaborador;

@Repository
public interface ColaboradorDAO extends JpaRepository<Colaborador, Long> {
	
	@Query("select new br.com.mathidios.project.model.entity.Colaborador( "
			+ "s.nmSetor, c.nmColab, c.emailColab, c.idColab) from Setor s inner join "
			+ "Colaborador c on c.setor.idSetor = s.idSetor order by s.nmSetor, c.nmColab")
	List<Colaborador> findAll();

}
