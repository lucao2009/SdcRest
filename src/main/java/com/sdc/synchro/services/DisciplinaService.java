package com.sdc.synchro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.sdc.synchro.domain.Disciplina;
import com.sdc.synchro.repositories.DisciplinaRepository;
import com.sdc.synchro.services.exceptions.DataIntegrityException;
import com.sdc.synchro.services.exceptions.ObjectNotFoundException;

@Service
public class DisciplinaService {

		@Autowired
		private DisciplinaRepository repo;
		
		
		public Disciplina findById(Integer id) {
			Optional<Disciplina> obj = repo.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto nao encontrado! Id: " + id + ", Tipo: " + Disciplina.class.getName()));
		}
		
		public Disciplina insert(Disciplina obj) {
			obj.setId(null);
			return repo.save(obj);
		}
		
		public Disciplina update(Disciplina obj) {
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
		
		public List<Disciplina> findAll() {
			return repo.findAll();
		}
	}
