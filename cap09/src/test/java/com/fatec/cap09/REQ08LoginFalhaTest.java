// ROBSON HENRIQUE FERREIRA | RA: 1110481823026

package com.fatec.cap09;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.util.HashMap;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class REQ08LoginFalhaTest {
  private WebDriver driver;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @SuppressWarnings("deprecation")
@Test
  public void rEQ08LoginFalha() {
    driver.get("https://ts-scel.herokuapp.com/login");
    driver.manage().window().setSize(new Dimension(1294, 1040));
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).sendKeys("joseee");
    driver.findElement(By.name("password")).sendKeys("123");
    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    assertThat(driver.findElement(By.cssSelector(".vsc-initialized > div")).getText(), is("Invalid username and password."));
  }
}
