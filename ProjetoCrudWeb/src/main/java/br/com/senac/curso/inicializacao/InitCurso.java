package br.com.senac.curso.inicializacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.curso.domain.Curso;
import br.com.senac.curso.service.CursoService;



@Component
public class InitCurso implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	CursoService cursoService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {


		Curso curso1 = new Curso(); 
		curso1.setNome("Bootcamp DevWeb");
		curso1.setDescricao("Curso focado no desenvolvimento web");
		cursoService.salvar(curso1);
		
		Curso curso2 = new Curso(); 
		curso2.setNome("HackJAVA");
		curso2.setDescricao("Curso fullstack JAVA");
		cursoService.salvar(curso2);
		
		
		List <Curso> listaCursos = cursoService.buscarTodosCursos();
				
			for(Curso curso: listaCursos) {
				
				System.out.println(curso.getNome());
			}
				
			
	
	}

}