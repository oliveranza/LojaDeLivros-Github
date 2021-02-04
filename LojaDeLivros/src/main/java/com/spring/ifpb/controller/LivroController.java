package com.spring.ifpb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ifpb.repository.LivroRepository;
import com.spring.ifpb.model.Livro;

@Controller
@RequestMapping(value = "/Livros")
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;

	@GetMapping
	public List<Livro> listarLivros() {
		return livroRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Livro> buscarLivro(@PathVariable(value = "id")Integer id) {
		return livroRepository.findById(id);
	}

	@PostMapping
	public String salvarLivro(Livro l) {
		livroRepository.save(l);
		return "Livro Salvo!";
	}
	
	@DeleteMapping
	public String deleteLivro(Livro l) {
		livroRepository.delete(l);
		return "Livro excluido com sucesso!";
	}

//	@DeleteMapping
//	public String deleteById(Integer id) {
//		livroRepository.deleteById(id);
//		return "Livro excluido com sucesso!";
//	}
	
	@PutMapping
	public String atualizarLivro(Livro l) {
		livroRepository.save(l);
		return "livro Atualizado";
	}
	
}