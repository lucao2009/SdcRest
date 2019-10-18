package com.sdc.synchro;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sdc.synchro.domain.Aluno;
import com.sdc.synchro.repositories.AlunoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	

	@Autowired
	private	AlunoRepository alunoRepository;
	
	@Override
	public void run(String... args) throws Exception {

		Aluno	a1 = new Aluno(null, "Lucas Alves", 21, 2016015204, "lucas@gmail.com", "Eng. de Comp.");
		Aluno	a2 = new Aluno(null, "Geraldo", 43, 2092137891, "geraldo@gmail.com", "Ciencias Biologicas");

		alunoRepository.saveAll(Arrays.asList(a1, a2));
	}

}
