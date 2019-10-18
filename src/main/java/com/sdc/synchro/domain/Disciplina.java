package com.sdc.synchro.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer codigo;
	private String nome;
	private String professor;
	private Integer qtdeVagas;
	
	
	public Disciplina() {
		super();
		// TODO Auto-generated
	}


	public Disciplina(Integer id, Integer codigo, String nome, String professor, Integer qtdeVagas) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.professor = professor;
		this.qtdeVagas = qtdeVagas;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getProfessor() {
		return professor;
	}


	public void setProfessor(String professor) {
		this.professor = professor;
	}


	public Integer getQtdeVagas() {
		return qtdeVagas;
	}


	public void setQtdeVagas(Integer qtdeVagas) {
		this.qtdeVagas = qtdeVagas;
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
		Disciplina other = (Disciplina) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
