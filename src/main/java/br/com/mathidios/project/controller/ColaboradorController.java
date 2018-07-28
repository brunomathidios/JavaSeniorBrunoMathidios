package br.com.mathidios.project.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mathidios.project.model.dto.SetorDTO;
import br.com.mathidios.project.model.entity.Colaborador;
import br.com.mathidios.project.model.service.ColaboradorService;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	/**
	 * Method to retrieve a specific employee
	 * @param @PathVariable(name="idColab") Long idColab
	 * @return ResponseEntity<Colaborador>
	 * @throws Exception
	 */
	@GetMapping("/id/{idColab}")
	public ResponseEntity<Colaborador> getColaboradorById(@PathVariable(name="idColab") Long idColab) throws Exception {
		try {
			
			return Optional
			        .ofNullable( this.colaboradorService.findByIdColab(idColab) )
			        .map( colaborador -> ResponseEntity.ok().body(colaborador) ) 
			        .orElseGet( () -> ResponseEntity.notFound().build() );			
			
		} catch (Exception e) {
			return new ResponseEntity<Colaborador>(new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Method to persist a new employee
	 * @param @RequestBody Colaborador colaborador
	 * @return ResponseEntity<Colaborador>
	 */
	@PostMapping("/new")
	public ResponseEntity<Colaborador> createColaborador(@Valid @RequestBody Colaborador colaborador) {
		try {
			
			return new ResponseEntity<Colaborador>(this.colaboradorService.create(colaborador), HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<Colaborador>(new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Method to remove employee by id
	 * @param @PathVariable(name="idColab") Long idColab
	 * @return ResponseEntity<?>
	 */
	@DeleteMapping("/delete/{idColab}")
	public ResponseEntity<?> deleteColabById(@PathVariable(name="idColab") Long idColab) {
		try {
			
			this.colaboradorService.deleteByIdColab(idColab);	
			return ResponseEntity.ok().build();
			
		} catch (Exception e) {
			if(e instanceof EmptyResultDataAccessException) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.badRequest().build();
		}
	}
	
	/**
	 * Method to retrieve all employees
	 * @return ResponseEntity<List<Colaborador>>
	 */
	@GetMapping
	public ResponseEntity<List<SetorDTO>> getAllColaboradores() {
		try {
			
			return Optional
					.ofNullable( this.colaboradorService.findAll() )
					.map( colaborarAgrupadoSetorDTOList -> ResponseEntity.ok().body(colaborarAgrupadoSetorDTOList) )
					.orElseGet( () -> ResponseEntity.notFound().build() );			
			
		} catch (Exception e) {
			return new ResponseEntity<List<SetorDTO>>(new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}
	}
}
