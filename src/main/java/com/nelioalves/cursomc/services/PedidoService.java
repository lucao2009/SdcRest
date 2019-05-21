package com.nelioalves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Pedido;
import com.nelioalves.cursomc.repositories.PedidoRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	//declarando dependencia de um objeto do tipo PedidoRepository
	@Autowired	//anotacao que vai instanciar automaticamente a dependencia a seguir, pelo mecanismo de injeção de dependencia ou inversão de controle
	private PedidoRepository repo;		//usando um repository
	
	//operacao/metodo capaz de buscar uma categoria por codigo
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
