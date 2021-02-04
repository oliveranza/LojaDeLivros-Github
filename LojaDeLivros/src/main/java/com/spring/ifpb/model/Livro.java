package com.spring.ifpb.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Livro")
public class Livro {
	
	@Id
	@Column(name="id_livro")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String titulo;
	
	private long preco;
	
	@ManyToOne
	private Editora editora;
	
	@ManyToOne
	private Categoria categoria;
	
	@ManyToMany
	private List<Autor> autores;

	
	public void addAutor(Autor a) {
		autores=new ArrayList<>();
		autores.add(a);
	}
	
	
	public long getPreco() {
		return preco;
	}

	public void setPreco(long preco) {
		this.preco = preco;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Categoria getCategorai() {
		return categoria;
	}

	public void setCategorai(Categoria categorai) {
		this.categoria = categorai;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	} 

}
