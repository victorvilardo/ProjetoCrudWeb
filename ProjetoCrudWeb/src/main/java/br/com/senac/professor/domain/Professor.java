package br.com.senac.professor.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.senac.curso.domain.Curso;
import br.com.senac.disciplina.domain.Disciplina;

@Entity
public class Professor implements Serializable {

	
	private static final long serialVersionUID = -9188148431809422228L;

	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column (name = "nomeProfessor")
	private String nome;

	@Column (name = "sobrenomeProfessor")
	private String sobrenome;

	@OneToOne
	@JoinColumn (name= "id_disciplina")
	private Disciplina disciplina;

	@ManyToOne
	@JoinColumn (name= "id_curso")
	private Curso curso;
	
	
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
	
	
}