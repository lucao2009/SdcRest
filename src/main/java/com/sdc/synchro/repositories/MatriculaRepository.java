package com.sdc.synchro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sdc.synchro.domain.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Integer>{

}