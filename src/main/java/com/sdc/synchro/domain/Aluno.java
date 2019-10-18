package com.sdc.synchro.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private Integer idade;
	private Integer matricula;
	private String email;
	private String curso;

public Aluno() {
	super();
	// TODO Auto-generated constructor stub
}

public Aluno(Integer id, String nome, Integer idade, Integer matricula, String email, String curso) {
	super();
	this.id = id;
	this.nome = nome;
	this.idade = idade;
	this.matricula = matricula;
	this.email = email;
	this.curso = curso;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getCurso() {
	return curso;
}

public void setCurso(String curso) {
	this.curso = curso;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public Integer getIdade() {
	return idade;
}

public void setIdade(Integer idade) {
	this.idade = idade;
}

public Integer getMatricula() {
	return matricula;
}

public void setMatricula(Integer matricula) {
	this.matricula = matricula;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Aluno other = (Aluno) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
	}
}
