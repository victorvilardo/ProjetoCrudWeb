package br.com.senac.disciplina.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.disciplina.domain.Disciplina;



@Repository

public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {
 
	
	
	
}