package com.elianogueira.desafioselenium;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Desafio5 {

	private WebDriver driver = null;
	
	@Before
	public void preCondicao() throws Exception {
		driver = new FirefoxDriver();
		
		driver.get("http://eliasnogueira.com/arquivos_blog/selenium/desafio/5desafio/");
	}

	@Test
	public void testeCaminhoFeliz() {
		
		// cria as localizacoes de xpath
		String xpathUsername = "//label[text() = 'Username']/following-sibling::div/input";
		String xpathUsernameRepetir = "//label[text() = 'Username (repetir)']/following-sibling::div/input";
		String xpathPassword = "//label[text() = 'Password']/following-sibling::div/input";
		String xpathPasswordRepetir = "//label[text() = 'Password (repetir)']/following-sibling::div/input"; 
		
		// cria as variaveis de usuario e senha
		String usuario = "elias";
		String senha = "123456";
		
		// preenche o usuario e senha
		driver.findElement(By.xpath(xpathUsername)).sendKeys(usuario);
		driver.findElement(By.xpath(xpathUsernameRepetir)).sendKeys(usuario);
		
		driver.findElement(By.xpath(xpathPassword)).sendKeys(senha);
		driver.findElement(By.xpath(xpathPasswordRepetir)).sendKeys(senha);
		
		// Faz as validacoes para confirmar que os campos foram preenchidos
		// dificilmente fazemo validações destas, mas esta aqui apenas em carater ditatico
		assertEquals(usuario, driver.findElement(By.xpath(xpathUsername)).getAttribute("value"));
		assertEquals(usuario, driver.findElement(By.xpath(xpathUsernameRepetir)).getAttribute("value"));
		assertEquals(senha, driver.findElement(By.xpath(xpathPassword)).getAttribute("value"));
		assertEquals(senha, driver.findElement(By.xpath(xpathPasswordRepetir)).getAttribute("value"));
	}
	
	@After
	public void posCondicao() throws Exception {
		driver.quit();
	}

}
