// ROBSON HENRIQUE FERREIRA | RA: 1110481823026

package com.fatec.cap09;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.util.HashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class REQ05MantemAlunoCEPTest {
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
  @SuppressWarnings("deprecation")
@Test
  public void rEQ05MantemAlunoCEP() {
    driver.get("https://ts-scel.herokuapp.com/login");
    driver.manage().window().setSize(new Dimension(1294, 1040));
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).sendKeys("jose");
    driver.findElement(By.name("password")).sendKeys("123");
    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    driver.findElement(By.linkText("Alunos")).click();
    driver.findElement(By.id("ra")).click();
    driver.findElement(By.id("ra")).sendKeys("1234");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("robson");
    driver.findElement(By.id("email")).sendKeys("robson");
    driver.findElement(By.id("cep")).sendKeys("07272540");
    driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
    assertThat(driver.findElement(By.cssSelector("td:nth-child(6)")).getText(), is("Rua Cassilândia"));
  }
}
