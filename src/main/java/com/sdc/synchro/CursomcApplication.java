package com.sdc.synchro;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sdc.synchro.domain.Aluno;
import com.sdc.synchro.domain.Disciplina;
import com.sdc.synchro.domain.Matricula;
import com.sdc.synchro.repositories.AlunoRepository;
import com.sdc.synchro.repositories.DisciplinaRepository;
import com.sdc.synchro.repositories.MatriculaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	

	@Autowired
	private	DisciplinaRepository disciplinaRepository;
	
	@Autowired
	private	AlunoRepository alunoRepository;
	
	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Override
	public void run(String... args) throws Exception {

		Aluno	a1 = new Aluno(null, "Lucas Alves", 21, 2016015204, "lucas@gmail.com", "Eng. de Comp.");
		Aluno	a2 = new Aluno(null, "Geraldo", 43, 2092137891, "geraldo@gmail.com", "Ciencias Biologicas");
		
		Disciplina c1 = new Disciplina(null, 1234, "Inteligência Artificial", "Dra Thais Guadêncio", 60);
		Disciplina c2 = new Disciplina(null, 342344, "Engenharia de Software", "Dr Alisson Brito", 40);
		
		Matricula m1 = new Matricula(null, 1234, 2016015204);
		Matricula m2 = new Matricula(null, 342344, 2016015204);
		
		alunoRepository.saveAll(Arrays.asList(a1, a2));
		disciplinaRepository.saveAll(Arrays.asList(c1,c2));
		matriculaRepository.saveAll(Arrays.asList(m1,m2));
		
	}

}
