package br.com.senac.disciplina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import br.com.senac.disciplina.domain.Disciplina;
import br.com.senac.disciplina.service.DisciplinaService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping ("disciplina")
public class DisciplinaController {

	@Autowired
	private DisciplinaService disciplinaService;
	

	@GetMapping("/listarDisciplinas")
	public ModelAndView listaTodasDisciplinas() {
		
		
		ModelAndView mv = new ModelAndView("disciplina/listarDisciplinas");
		
		
		mv.addObject("disciplinas", disciplinaService.buscarTodasDisciplinas());

		
		return mv;
		
	}
	
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarDisciplinas(){
		
		
		ModelAndView mv = new ModelAndView("disciplina/cadastrarDisciplinas");
		
		mv.addObject("disciplinas", new Disciplina());
		return mv;
		
		
		
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarDisciplina(Disciplina disciplina) {
		disciplinaService.salvar(disciplina);
		
		return listaTodasDisciplinas();
		
	}
	
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarDisciplina(@PathVariable("id") Integer idDisciplina) throws ObjectNotFoundException{
			
			ModelAndView mv = new ModelAndView("disciplina/alterarDisciplina");
		
			mv.addObject("disciplinas", disciplinaService.buscarPorId(idDisciplina));
			return mv;
	}
	
	
	@PostMapping("/alterar")
	public ModelAndView salvarCursoAlteracao(Disciplina disciplina) throws ObjectNotFoundException {
		disciplinaService.salvarDisciplinaAlteracao(disciplina);
		
		return listaTodasDisciplinas();
		
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluirDisciplina(@PathVariable("id") Integer idDisciplina) throws ObjectNotFoundException{
			
			disciplinaService.excluir(idDisciplina);
			return listaTodasDisciplinas();
	}
	
	
	
}