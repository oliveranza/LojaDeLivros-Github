package com.spring.ifpb;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.ifpb.controller.AutorController;
import com.spring.ifpb.controller.CDDController;
import com.spring.ifpb.controller.CategoriaController;
import com.spring.ifpb.controller.EditoraController;
import com.spring.ifpb.controller.LivroController;
import com.spring.ifpb.controller.PrateleiraController;
import com.spring.ifpb.controller.UsuarioController;
import com.spring.ifpb.model.Autor;
import com.spring.ifpb.model.CDD;
import com.spring.ifpb.model.Categoria;
import com.spring.ifpb.model.Editora;
import com.spring.ifpb.model.Livro;
import com.spring.ifpb.model.Prateleira;
import com.spring.ifpb.model.Usuario;
import com.spring.ifpb.repository.LivroRepository;
import com.spring.ifpb.resouces.CategoriaLivro;

@SpringBootApplication
public class LojaDeLivrosApplication implements CommandLineRunner {

	private AutorController ac;
	private EditoraController ec;
	private CategoriaController cc;
	private CDDController cddc;
	private PrateleiraController pc;
	private UsuarioController uc;
	private LivroController lc;
	private LivroRepository lr;

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	public LojaDeLivrosApplication(LivroController lc, AutorController ac, EditoraController ec, CategoriaController cc,
			CDDController cddc, PrateleiraController pc, UsuarioController uc, LivroRepository lr) {
		this.ac = ac;
		this.ec = ec;
		this.cc = cc;
		this.cddc = cddc;
		this.pc = pc;
		this.uc = uc;
		this.lc = lc;
		this.lr = lr;
	}

	public static void main(String[] args) {
		SpringApplication.run(LojaDeLivrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * criando e salvando instancias de autor, editora e categoria, para salvar no
		 * bd e para poder atribuir a um livro para poder salva-lo no BD
		 */

		Autor a = new Autor();
		a.setId(1l);
		a.setNome("Roger Pressman");
		System.out.println(ac.salvarAutor(a));

		Editora ed = new Editora();
		ed.setNome("Atica");
		ec.salvarLivro(ed);

		Categoria ct = new Categoria();
		ct.setDescricao(CategoriaLivro.BIOGRAFIA);
		cc.salvarCategoria(ct);

		/*
		 * criando 4 instancias de livro para salvar no BD
		 */

		Livro l1 = new Livro();
		l1.setPreco(new BigDecimal(40.00));
		l1.setTitulo("livro de teste 1");
		l1.addAutor(a);
		l1.setEditora(ed);
		l1.setCategorai(ct);
		lc.salvarLivro(l1);

//		Livro l2 = new Livro();
//		l2.setPreco(new BigDecimal(50.00));
//		l2.setTitulo("livro de teste 2");
//		l2.addAutor(a);
//		l2.setEditora(ed);
//		l2.setCategorai(ct);
//		lc.salvarLivro(l2);
//		
//		Livro l3 = new Livro();
//		l3.setPreco(new BigDecimal(45.00));
//		l3.setTitulo("livro de teste 3");
//		l3.addAutor(a);
//		l3.setEditora(ed);
//		l3.setCategorai(ct);
//		lc.salvarLivro(l3);
//		
//		Livro l4 = new Livro();
//		l4.setPreco(new BigDecimal(50.00));
//		l4.setTitulo("livro de teste 4");
//		l4.addAutor(a);
//		l4.setEditora(ed);
//		l4.setCategorai(ct);
//		lc.salvarLivro(l4);

		Usuario u = new Usuario();
		u.setCPF(10048986496l);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dt = sdf.parse("06/07/1993");
		u.setDtNacimento(dt);
		u.setEmail("oliveranza@gmail.com");
		u.setNome("Oliver Ranza");
		u.setSenha("Senha120*");
		System.out.println(ANSI_CYAN + uc.salvarUsuario(u)+ ANSI_RESET);
		
		CDD cdd = new CDD();
		cdd.setEstado("PB");
		cdd.setCidade("Monteiro");
		cddc.salvarCDD(cdd);
		
		Prateleira pt = new Prateleira();
		pt.setLocalizacao("A33");
		pt.setCdd(cdd);
		pt.addLivro(l1);
		pc.salvarPrateleira(pt);
		
		cdd.addPrateleira(pt);
		cddc.salvarCDD(cdd);
		
		
		
		
		
		
		
		
		
		
		
		
//
//		/*
//		 * variável para definir o numero da pagina que será exibida
//		 */
//		int numDaPag = 0;
//
//		/*
//		 * exibindo resultado de forma paginada e organizada por preço
//		 */
//		Pageable paginacao = PageRequest.of(numDaPag, 3, Sort.by(Sort.Direction.ASC, "preco"));
//		Page<Livro> livros = lr.findByPrecoLessThan(new BigDecimal(55), paginacao);
//		System.out.println(ANSI_RED+"_____________________________________________________________"+ANSI_RESET);
//		System.out.println(ANSI_GREEN+ livros);
//		System.out.println("Pagina atual: " + livros.getNumber());
//		System.out.println("total de elementos: " + livros.getTotalElements());
//		livros.forEach(livro -> System.out.println("id: " + livro.getId() + " - " + livro.getTitulo()+" - preço: "+ livro.getPreco()));
//		System.out.println(ANSI_RED+"-------------------------------------------------------------"+ANSI_RESET);
//
//		Livro livro1 = new Livro(); 			// criando livro para teste de e atualização e posteriormente exclusão
//		livro1.setId(3l);
//		lc.deleteLivro(livro1);					// excluir livro
//		
//		livro1 = lc.buscarLivro(4l); 			// metodo de buscar livro no BD
//		livro1.setPreco(new BigDecimal(60));
//		lc.atualizarLivro(livro1); 				// alterar preco do livro
//
//		
//		/*
//		 * exibindo os livro apos exclusão e atualização
//		 */
//		livros = lr.findByPrecoLessThan(new BigDecimal(55), paginacao);
//		System.out.println(ANSI_RED+"_____________________________________________________________"+ANSI_RESET);
//		System.out.println(ANSI_GREEN+livros);
//		System.out.println("Pagina atual: " + livros.getNumber());
//		System.out.println("total de elementos: " + livros.getTotalElements());
//		livros.forEach(livro -> System.out.println("id: " + livro.getId() + " - " + livro.getTitulo()+" - preço: "+ livro.getPreco()));
//		System.out.println(ANSI_RED+"-------------------------------------------------------------"+ANSI_RESET);		

	}

}
