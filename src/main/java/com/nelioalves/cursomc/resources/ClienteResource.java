package com.nelioalves.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.services.ClienteService;

@RestController
@RequestMapping(value="/clientes") //o parametro do 'value' eh o nome do endpoit que eu quero criar, essa classe serah um controlador REST e
										// responderah pelo endpoint /categorias
public class ClienteResource {
	
	@Autowired
	private ClienteService service;		//acessando o servico
	
	//para esse metodo java ser uma funcao REST, eu tenho que associar ela com algum dos verbos do http
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {
		
		Cliente obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
	}
}
