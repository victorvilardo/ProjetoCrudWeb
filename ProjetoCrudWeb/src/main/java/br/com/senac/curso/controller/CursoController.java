package br.com.senac.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.curso.domain.Curso;
import br.com.senac.curso.service.CursoService;
import javassist.tools.rmi.ObjectNotFoundException;


@Controller
@RequestMapping ("curso")
public class CursoController {

	@Autowired
	private CursoService cursoService;
	

	@GetMapping("/listarCursos")
	public ModelAndView listaTodosCursos() {
		
		
		ModelAndView mv = new ModelAndView("curso/listarCursos");
		
		
		mv.addObject("cursos", cursoService.buscarTodosCursos());

		
		return mv;
		
	}
	
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarCursos(){
		
		
		ModelAndView mv = new ModelAndView("curso/cadastrarCursos");
		
		mv.addObject("cursos", new Curso());
		return mv;
		
		
		
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarCurso(Curso curso) {
		cursoService.salvar(curso);
		
		return listaTodosCursos();
		
	}
	
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarCurso(@PathVariable("id") Integer idCurso) throws ObjectNotFoundException{
			
			ModelAndView mv = new ModelAndView("curso/alterarCurso");
		
			mv.addObject("cursos", cursoService.buscarPorId(idCurso));
			return mv;
	}
	
	
	@PostMapping("/alterar")
	public ModelAndView salvarCursoAlteracao(Curso curso) throws ObjectNotFoundException {
		cursoService.salvarCursoAlteracao(curso);
		
		return listaTodosCursos();
		
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluirCurso(@PathVariable("id") Integer idCurso) throws ObjectNotFoundException{
			
			cursoService.excluir(idCurso);
			return listaTodosCursos();
	}
	
	
	
}
