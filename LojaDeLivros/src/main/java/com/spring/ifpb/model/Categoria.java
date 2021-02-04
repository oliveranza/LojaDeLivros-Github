package com.spring.ifpb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spring.ifpb.resouces.CategoriaLivro;

@Entity
@Table(name="tb_categoria")
public class Categoria {
	
	@Id
	@Column(name="id_categoria")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private CategoriaLivro descricao;

	
	
	
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CategoriaLivro getDescricao() {
		return descricao;
	}

	public void setDescricao(CategoriaLivro descricao) {
		this.descricao = descricao;
	}

	
}
