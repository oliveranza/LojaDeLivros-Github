package com.spring.ifpb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public Optional<Autor> buscarAutor(@PathVariable(value = "id")Integer id) {
		return autorRepository.findById(id);
	}

	
	public String salvarAutor(Autor a) {
		autorRepository.save(a);
		return "Autor Salvo!";
	}
	
	
}
