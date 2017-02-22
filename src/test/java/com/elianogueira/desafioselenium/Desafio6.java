package com.elianogueira.desafioselenium;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Desafio6 {

	private static WebDriver driver;
	private static WebElement usuario;
	private static WebElement senha;
	
	/**
	 * A pre-condição está para todo o teste para que seja possível
	 *  - Iniciar o browser
	 *  - Preencher o campo usuario
	 *  - Manter o browser aberto para executar todos os testes
	 */
	@BeforeClass
	public static void preCondicaoTodosTestes() {
		/*
		 * É necessário que você  baixe o 'chromedriver' para sua máquina e altere o caminho
		 * da propriedade abaixo
		 * 
		 * Local para baixar o chromedriver
		 * https://sites.google.com/a/chromium.org/chromedriver/
		 * 
		 */
		System.setProperty("webdriver.chrome.driver", "/Users/eliasnogueira/Selenium/chromedriver");
		
		driver = new ChromeDriver();
		driver.get("http://eliasnogueira.com/arquivos_blog/selenium/desafio/6desafio/");
		
		usuario = driver.findElement(By.id("usuario"));
		senha = driver.findElement(By.id("senha"));
		
		usuario.sendKeys("elias");
	}
	
	@Test
	public void teste_PeloMenosUmaLetra() {
		senha.sendKeys("a");
		
		assertEquals("valid", driver.findElement(By.id("letra")).getAttribute("class"));
	}

	@Test
	public void teste_PeloMenosUmaLetraMaiuscula() {
		senha.sendKeys("E");
		
		assertEquals("valid", driver.findElement(By.id("maiuscula")).getAttribute("class"));
	}

	@Test
	public void teste_PeloMenosUmNumero() {
		senha.sendKeys("5");
		
		assertEquals("valid", driver.findElement(By.id("letra")).getAttribute("class"));
	}

	@Test
	public void teste_MaisQue8Caracteres() {
		/*
		 * Como cada sendKeys dos testes anteriores adicionam a tecla enviada
		 * é necessário limpar o campo apra garantir os 8 caracteres (limite) no campo
		 */
		senha.clear();
		senha.sendKeys("aE5@iw7y");
		
		assertEquals("valid", driver.findElement(By.id("tamanho")).getAttribute("class"));
	}
	@AfterClass
	public static void posCondicaoTodosTestes() {
		driver.quit();
	}

}
