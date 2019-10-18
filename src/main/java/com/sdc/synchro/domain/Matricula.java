package com.sdc.synchro.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Matricula implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer codigoDisciplina;
	private Integer matriculaAluno;
	
	public Matricula() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Matricula(Integer id, Integer codigoDisciplina, Integer matriculaAluno) {
		super();
		this.id = id;
		this.codigoDisciplina = codigoDisciplina;
		this.matriculaAluno = matriculaAluno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodigoDisciplina() {
		return codigoDisciplina;
	}

	public void setCodigoDisciplina(Integer codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}

	public Integer getMatriculaAluno() {
		return matriculaAluno;
	}

	public void setMatriculaAluno(Integer matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
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
		Matricula other = (Matricula) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
