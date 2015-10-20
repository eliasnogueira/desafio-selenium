package com.elianogueira.desafioselenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Desafio5 {

	private WebDriver driver;
	
	@Before
	public void preCondicao() {
		driver = new FirefoxDriver();
		driver.get("http://eliasnogueira.com/arquivos_blog/selenium/desafio/5desafio/");
	}
	
	@After
	public void posCondicao() {
		driver.quit();
	}
	
	@Test
	public void testePreenchimentoCamposDinamicos() {
		/*
		 * Preenche os campos utilizando as funcoes  text() e following-sibling
		 */
		driver.findElement(By.xpath("//label[text() = 'Username']/following-sibling::div/input")).sendKeys("eliasn");
		driver.findElement(By.xpath("//label[text() = 'Username (repetir)']/following-sibling::div/input")).sendKeys("elias");
		driver.findElement(By.xpath("//label[text() = 'Password']/following-sibling::div/input")).sendKeys("12345");
		driver.findElement(By.xpath("//label[text() = 'Password (repetir)']/following-sibling::div/input")).sendKeys("12345");
		
		driver.findElement(By.id("submitBtn2")).click();
		
		/*
		 * Validar o resultado por não ter preenchido o campo username igual
		 */
		assertEquals("Os campos não tem o mesmo valor!", driver.findElement(By.id("submitBtn2")).getText());
	}

}
