package br.com.senac.disciplina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.disciplina.domain.Disciplina;
import br.com.senac.disciplina.repositorio.DisciplinaRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class DisciplinaService {

	@Autowired
	DisciplinaRepository repo;
	
	public Disciplina salvar (Disciplina disciplina) {
		
		return repo.save(disciplina);
	}
	
	
	public List<Disciplina> buscarTodasDisciplinas(){
		
		return repo.findAll();
	}

	public Disciplina buscarPorId (Integer id) throws ObjectNotFoundException{
		Optional<Disciplina> disciplina = repo.findById(id);
		
		return disciplina.orElseThrow(() -> new ObjectNotFoundException("Disciplina não encontrada: " +id ));
		
		
		
	}
	
	public Disciplina salvarDisciplinaAlteracao(Disciplina disciplinaAlterada)throws ObjectNotFoundException  {
		
		Disciplina disciplinaAtual = buscarPorId(disciplinaAlterada.getId());
		disciplinaAtual.setNome(disciplinaAlterada.getNome());
		disciplinaAtual.setDescricao(disciplinaAlterada.getDescricao());
		
		return salvar(disciplinaAtual);
	}
	
	
	public void excluir(Integer id) {
		repo.deleteById(id);
		
	}
	
	
	
	
	
}