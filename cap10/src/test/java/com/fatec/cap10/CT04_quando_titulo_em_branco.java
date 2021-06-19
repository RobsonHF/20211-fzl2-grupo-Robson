package com.fatec.cap10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class CT04_quando_titulo_em_branco {

	@Test
	void ct02_quando_dados_validos_cadastra_com_sucesso() {
		// dado que nao existem livros cadastrados
		Biblioteca biblioteca = new Biblioteca();
		// quando um livro é cadastrado
		Livro umLivro = new Livro();
		umLivro.setAutor("Pressman");
		umLivro.setIsbn("1111");
		umLivro.setTitulo("");
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
