// ROBSON HENRIQUE FERREIRA | RA: 1110481823026

package com.fatec.cap10;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class CT01_quando_dados_validos_cadastra_com_sucesso {
  private WebDriver driver;
  JavascriptExecutor js;
  @BeforeEach
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    new HashMap<String, Object>();
  }
  @AfterEach
  public void tearDown() {
    driver.quit();
  }
  @Test
  void ct01_quando_dados_validos_cadastra_com_sucesso() {
  //dado que nao existem livros cadastrados
  Biblioteca biblioteca = new Biblioteca();
  //quando um livro é cadastrado
  Livro umLivro = new Livro();
  umLivro.setAutor("Pressman");
  umLivro.setIsbn("1111");
  umLivro.setTitulo("Engenharia de Software");
  biblioteca.save(umLivro);
  //entao o total de livros cadastrados igual 1
  assertEquals (1, biblioteca.size());
  }
}
