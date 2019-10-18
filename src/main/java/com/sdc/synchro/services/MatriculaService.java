package com.sdc.synchro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.sdc.synchro.domain.Matricula;
import com.sdc.synchro.repositories.MatriculaRepository;
import com.sdc.synchro.services.exceptions.DataIntegrityException;
import com.sdc.synchro.services.exceptions.ObjectNotFoundException;

@Service
public class MatriculaService {

	@Autowired
	private MatriculaRepository repo;
	
	
	public Matricula findById(Integer id) {
		Optional<Matricula> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! Id: " + id + ", Tipo: " + Matricula.class.getName()));
	}
	
	public Matricula insert(Matricula obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Matricula update(Matricula obj) {
		findById(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir");
		}
	}
	
	public List<Matricula> findAll() {
		return repo.findAll();
	}
}
