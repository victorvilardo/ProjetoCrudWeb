package br.com.senac.professor.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.professor.domain.Professor;


@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
