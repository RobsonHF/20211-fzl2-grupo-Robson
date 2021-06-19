package com.fatec.cap10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class CT05_quando_autor_em_branco {

	@Test
	void ct02_quando_dados_validos_cadastra_com_sucesso() {
		// dado que nao existem livros cadastrados
		Biblioteca biblioteca = new Biblioteca();
		// quando um livro é cadastrado
		Livro umLivro = new Livro();
		umLivro.setAutor("");
		umLivro.setIsbn("1111");
		umLivro.setTitulo("Engenharia de Software");
		biblioteca.save(umLivro);
		List<Livro> lista = biblioteca.getLivros();
		// entao
		Livro re = new Livro();
		re.setAutor("Pressman");
		re.setIsbn("1111");
		re.setTitulo("Engenharia de Software");
		assertTrue(re.equals(lista.get(0)));
	}

}
