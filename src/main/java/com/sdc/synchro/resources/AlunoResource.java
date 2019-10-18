package com.sdc.synchro.resources;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sdc.synchro.domain.Aluno;
import com.sdc.synchro.services.AlunoService;


@RestController
@RequestMapping(value="/alunos") //o parametro do 'value' eh o nome do endpoit que eu quero criar, essa classe serah um controlador REST e
										// responderah pelo endpoint /categorias
public class AlunoResource {
	
	@Autowired
	private AlunoService service;		//acessando o servico
	
	
	
	//para esse metodo java ser uma funcao REST, eu tenho que associar ela com algum dos verbos do http
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Aluno> find(@PathVariable Integer id) {
		
		Aluno obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Aluno>> findAll() {
		
		List<Aluno> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}	

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Aluno obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Aluno obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
