package com.nelioalves.cursomc.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias") //o parametro do 'value' eh o nome do endpoit que eu quero criar, essa classe serah um controlador REST e
										// responderah pelo endpoint /categorias
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;		//acessando o servico
	
	//para esse metodo java ser uma funcao REST, eu tenho que associar ela com algum dos verbos do http
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Categoria> find(@PathVariable Integer id) {
		
		Categoria obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
	} // fim do GET
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj) {	// a notacao @RequestBody faz o json ser convertido para um objeto Java automaticamente
		obj = service.insert(obj);	//a operacao save do repository me retorna um objeto, por isso o 'obj = '
		//aqui o novo objeto jah foi inserido no banco e jah possui um id, agora eu uso esse id na URI de resposta
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();	//construindo a URI
		return ResponseEntity.created(uri).build();	// retornando a resposta HTTP
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT) 
	public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id) {
		obj.setId(id);  // por garantia
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
}
