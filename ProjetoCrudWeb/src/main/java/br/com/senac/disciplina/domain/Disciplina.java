package br.com.senac.disciplina.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Disciplina implements Serializable {

	
	private static final long serialVersionUID = -9188148431809422228L;

	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column (name = "nomeDisciplina")
	private String nome;

	@Column (name = "descricaoDisciplina")
	private String descricao;

	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
