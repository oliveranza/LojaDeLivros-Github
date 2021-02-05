package com.spring.ifpb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ifpb.model.Autor;
import com.spring.ifpb.repository.AutorRepository;

@Controller
@RequestMapping(value="/Autor")
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;

	@GetMapping
	public List<Autor> listarAutores() {
		return autorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Autor buscarAutor(@PathVariable(value = "id")Long id) {
		return autorRepository.findById(id);
	}
	
	public String salvarAutor(Autor a) {
		autorRepository.save(a);
		return "Autor Salvo!";
	}
	
	@DeleteMapping
	public String deleteAutor(Autor a) {
		autorRepository.delete(a);
		return "Autor excluido com sucesso!";
	}

//	@DeleteMapping
//	public String deleteById(long id) {
//		autorRepository.deleteById(id);
//		return "Autor excluido com sucesso!";
//	}
	
	@PutMapping
	public String atualizarAutor(Autor a) {
		autorRepository.save(a);
		return "Autor Atualizado";
	}
	
}
