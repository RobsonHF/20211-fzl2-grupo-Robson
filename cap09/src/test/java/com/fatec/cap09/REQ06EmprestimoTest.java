// ROBSON HENRIQUE FERREIRA | RA: 1110481823026

package com.fatec.cap09;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class REQ06EmprestimoTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @BeforeEach
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @AfterEach
  public void tearDown() {
    driver.quit();
  }
  public String waitForWindow(int timeout) {
    try {
      Thread.sleep(timeout);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Set<String> whNow = driver.getWindowHandles();
    @SuppressWarnings("unchecked")
	Set<String> whThen = (Set<String>) vars.get("window_handles");
    if (whNow.size() > whThen.size()) {
      whNow.removeAll(whThen);
    }
    return whNow.iterator().next();
  }
  @SuppressWarnings("deprecation")
@Test
  public void rEQ06Emprestimo() {
    driver.get("https://ts-scel.herokuapp.com/login");
    driver.manage().window().setSize(new Dimension(1294, 1040));
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).sendKeys("jose");
    driver.findElement(By.name("password")).sendKeys("123");
    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    driver.findElement(By.linkText("Empréstimo")).click();
    driver.findElement(By.id("isbn")).click();
    driver.findElement(By.id("isbn")).sendKeys("1111");
    driver.findElement(By.id("ra")).sendKeys("1234");
    driver.findElement(By.cssSelector(".row:nth-child(2)")).click();
    driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
    assertThat(driver.findElement(By.cssSelector(".text-danger")).getText(), is("Emprestimo registrado"));
    vars.put("window_handles", driver.getWindowHandles());
    driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();
    vars.put("win9949", waitForWindow(2000));
    driver.switchTo().window(vars.get("win9949").toString());
    assertThat(driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(5)")).getText(), is("2021/06/26"));
    driver.findElement(By.cssSelector("tr:nth-child(1) .btn")).click();
  }
}
