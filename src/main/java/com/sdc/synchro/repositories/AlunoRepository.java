package com.sdc.synchro.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sdc.synchro.domain.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

}