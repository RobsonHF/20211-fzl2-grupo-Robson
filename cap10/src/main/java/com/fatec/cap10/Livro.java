package com.fatec.cap10;

public class Livro {
	String isbn;
	String titulo;
	String autor;

	public Livro() {
	}

	public String getIsbn() {
		return isbn;
	}

	public String setIsbn(String isbn) {
		String mensagem = null;
		if (isbn.equals("")) {
			mensagem = "Informações inválidas";
		} else {
			this.isbn = isbn;
		}
		return mensagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}
}