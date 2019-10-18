package com.sdc.synchro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.sdc.synchro.domain.Aluno;
import com.sdc.synchro.repositories.AlunoRepository;
import com.sdc.synchro.services.exceptions.DataIntegrityException;
import com.sdc.synchro.services.exceptions.ObjectNotFoundException;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repo;
	
	
	public Aluno findById(Integer id) {
		Optional<Aluno> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName()));
	}
	
	public Aluno insert(Aluno obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Aluno update(Aluno obj) {
		findById(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Categoria que possui Alunos.");
		}
	}
	
	public List<Aluno> findAll() {
		return repo.findAll();
	}
}
