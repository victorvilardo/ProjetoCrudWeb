package br.com.senac.professor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.curso.service.CursoService;
import br.com.senac.disciplina.service.DisciplinaService;
import br.com.senac.professor.domain.Professor;
import br.com.senac.professor.service.ProfessorService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping ("professor")
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@Autowired CursoService cursoService;

	@GetMapping("/listarProfessores")
	public ModelAndView listaTodosProfessores() {
		
		
		ModelAndView mv = new ModelAndView("professor/listarProfessores");
		
		
		mv.addObject("professores", professorService.buscarTodosProfessores());

		
		return mv;
		
	}
	
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarProfessores(){
		
		
		ModelAndView mv = new ModelAndView("professor/cadastrarProfessor");
		mv.addObject("disciplinas", disciplinaService.buscarTodasDisciplinas());
		mv.addObject("cursos", cursoService.buscarTodosCursos());
		mv.addObject("professores", new Professor());
		return mv;
		
		
		
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarCurso(Professor professor) {
		professorService.salvar(professor);
		
		return listaTodosProfessores();
		
	}
	
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alteraProfessor(@PathVariable("id") Integer idProfessor) throws ObjectNotFoundException{
			
			ModelAndView mv = new ModelAndView("professor/alterarProfessor");
			
			mv.addObject("disciplinas", disciplinaService.buscarTodasDisciplinas());
			mv.addObject("cursos", cursoService.buscarTodosCursos());
			mv.addObject("professores", professorService.buscarPorId(idProfessor));
			return mv;
	}
	
	
	@PostMapping("/alterar")
	public ModelAndView salvarProfessorAlteracao(Professor professor) throws ObjectNotFoundException {
		professorService.salvarProfessorAlteracao(professor);
		
		return listaTodosProfessores();
		
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluirProfessor(@PathVariable("id") Integer idProfessor) throws ObjectNotFoundException{
			
		professorService.excluir(idProfessor);
			return listaTodosProfessores();
	}
	
	
	
}