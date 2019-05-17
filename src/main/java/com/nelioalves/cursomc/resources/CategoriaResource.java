package com.nelioalves.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.cursomc.domain.Categoria;

@RestController
@RequestMapping(value="/categorias") //o parametro do 'value' eh o nome do endpoit que eu quero criar, essa classe serah um controlador REST e
										// responderah pelo endpoint /categorias
public class CategoriaResource {
	
	//para esse metodo java ser uma funcao REST, eu tenho que associar ela com algum dos verbos do http
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {
		
		Categoria cat1 = new Categoria(1, "informatica");
		Categoria cat2 = new Categoria(2, "escritorio");
		
		//o List eh uma interface, aqui eu tenho que usar polimorfirsmo com o ArrayList
		List <Categoria> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);
		
		//return "REST estah funcionando!";
		return lista;
	}
}
