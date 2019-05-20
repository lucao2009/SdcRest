package com.nelioalves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	//declarando dependencia de um objeto do tipo CategoriaRepository
	@Autowired	//anotacao que vai instanciar automaticamente a dependencia a seguir, pelo mecanismo de injeção de dependencia ou inversão de controle
	private CategoriaRepository repo;		//usando um repository
	
	//operacao/metodo capaz de buscar uma categoria por codigo
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
}
