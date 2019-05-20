package com.nelioalves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.repositories.ClienteRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	//declarando dependencia de um objeto do tipo ClienteRepository
	@Autowired	//anotacao que vai instanciar automaticamente a dependencia a seguir, pelo mecanismo de injeção de dependencia ou inversão de controle
	private ClienteRepository repo;		//usando um repository
	
	//operacao/metodo capaz de buscar uma categoria por codigo
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
