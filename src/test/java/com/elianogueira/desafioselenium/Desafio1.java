package com.elianogueira.desafioselenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Desafio1 {

	private WebDriver driver = null;

	@Before
	public void preCondicao() throws Exception {
		driver = new FirefoxDriver();
		driver.get("http://eliasnogueira.com/arquivos_blog/selenium/desafio/1desafio/");
	}

	@Test
	public void testeSomaNumerosAleatorios() {
		
		// pega os dos valores na tela e guarda em uma variável
		String valor1 = driver.findElement(By.id("number1")).getText();
		String valor2 = driver.findElement(By.id("number2")).getText();

		// transforma os resultados em um número inteiro para a soma
		int resultadoInt = Integer.parseInt(valor1) + Integer.parseInt(valor2);

		driver.findElement(By.name("soma")).sendKeys(String.valueOf(resultadoInt));
		driver.findElement(By.name("submit")).click();

		assertEquals("CORRETO", driver.findElement(By.id("resultado")).getText());
	}

	@After
	public void posCondicao() throws Exception {
		driver.quit();
	}

}
