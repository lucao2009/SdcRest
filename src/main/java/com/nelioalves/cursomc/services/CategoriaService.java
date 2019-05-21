package com.nelioalves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.services.exceptions.DataIntegrityException;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	//declarando dependencia de um objeto do tipo CategoriaRepository
	@Autowired	//anotacao que vai instanciar automaticamente a dependencia a seguir, pelo mecanismo de injeção de dependencia ou inversão de controle
	private CategoriaRepository repo;		//usando um repository
	
	//operacao/metodo capaz de buscar uma categoria por codigo
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	} // fim do buscar
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);	// insercao e nao atualizacao
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());	//busco o objeto no banco, caso nao exista o metodo find me lanca uma excessao
		return repo.save(obj);		//o metodo save() do repository serve tanto para salvar quanto para modificar. ele diferencia pelo id se for null ou nao.
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos.");
		}
		
	}
}
