package com.spring.ifpb;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.spring.ifpb.controller.AutorController;
import com.spring.ifpb.controller.LivroController;
import com.spring.ifpb.model.Autor;
import com.spring.ifpb.model.Livro;

@SpringBootApplication
public class LojaDeLivrosApplication implements CommandLineRunner {

	private LivroController lv;
	private AutorController ac;

	public LojaDeLivrosApplication(LivroController lv, AutorController ac) {
		this.lv = lv;
		this.ac=ac;
		
	}

	public static void main(String[] args) {
		SpringApplication.run(LojaDeLivrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		Autor a = new Autor();
//		a.setId(2);
//		a.setNome("Ze bola");
//		ac.salvarAutor(a);
//		
//		Livro l = new Livro();
//		l.setId(1);
//		l.setPreco(25);
//		l.setTitulo("livro de teste");
//		l.addAutor(a);
//		
//		lv.salvarLivro(l);
//		List<Livro> l1 = lv.listarLivros();
//		System.out.println("\n \n \n \n ID:"+l1.get(0).getId());
//		System.out.println("TITULO: "+l1.get(0).getTitulo());
//		System.out.println("preco: "+l1.get(0).getPreco());
		
//		PageRequest paginacao = PageRequest.of(0, 4, Sort.by(Sort.Direction.ASC, "id"));
//		List<Livro> livros = lv.listarLivros();
//		System.out.println(livros);
//		System.out.println("Pagina atual: " + livros.getNumber());
//		System.out.println("total de elementos: " + livros.getTotalElements());
//		livros.forEach(Page -> System.out.println(Page));
//		System.out.println(livros.toString());

		
		
		
		
	}

}
