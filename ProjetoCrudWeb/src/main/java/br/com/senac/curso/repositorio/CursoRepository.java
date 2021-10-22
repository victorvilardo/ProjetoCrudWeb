package br.com.senac.curso.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.curso.domain.Curso;



@Repository

public interface CursoRepository extends JpaRepository<Curso, Integer> {
 
	
	
	
}