package br.com.senac.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.curso.domain.Curso;
import br.com.senac.curso.repositorio.CursoRepository;
import javassist.tools.rmi.ObjectNotFoundException;


@Service
public class CursoService {

	@Autowired
	CursoRepository repo;
	
	public Curso salvar (Curso curso) {
		
		return repo.save(curso);
	}
	
	
	public List<Curso> buscarTodosCursos(){
		
		return repo.findAll();
	}

	public Curso buscarPorId (Integer id) throws ObjectNotFoundException{
		Optional<Curso> curso = repo.findById(id);
		
		return curso.orElseThrow(() -> new ObjectNotFoundException("Curso não encontrado: " +id ));
		
		
		
	}
	
	public Curso salvarCursoAlteracao(Curso cursoAlterado)throws ObjectNotFoundException  {
		
		Curso cursoAtual = buscarPorId(cursoAlterado.getId());
		cursoAtual.setNome(cursoAlterado.getNome());
		cursoAtual.setDescricao(cursoAlterado.getDescricao());
		
		return salvar(cursoAtual);
	}
	
	
	public void excluir(Integer id) {
		repo.deleteById(id);
		
	}
	
	
	
	
	
}
