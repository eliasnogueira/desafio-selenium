package com.elianogueira.desafioselenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Desafio2 {

	private WebDriver driver = null;
	private WebDriverWait wait = null;
	
	@Before
	public void preCondicao() throws Exception {
		/**
		 * É necessário que você  baixe o 'chromedriver' para sua máquina e altere o caminho
		 * da propriedade abaixo
		 * 
		 * Local para baixar o chromedriver
		 * https://sites.google.com/a/chromium.org/chromedriver/
		 * 
		 */
		System.setProperty("webdriver.chrome.driver", "/Users/eliasnogueira/Selenium/chromedriver");
		
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		
		driver.get("http://eliasnogueira.com/arquivos_blog/selenium/desafio/2desafio/");
	}

	@Test
	public void testeEdicaoDeCamposInLine() {
		
		// dados para preechimento
		String nome = "Elias Nogueira";
		String email = "elias.nogueira@gmail.com";
		String telefone = "11 91234 5678";
		
		// alterando o nome
		WebElement nomeDisplay = driver.findElement(By.id("name_rg_display_section"));
		nomeDisplay.click();
		WebElement elementoPessoa = driver.findElement(By.id("nome_pessoa"));
		elementoPessoa.clear();
		elementoPessoa.sendKeys(nome);

		driver.findElement(By.cssSelector("#name_hv_editing_section > input[value='Salvar']")).click();
		wait.until(ExpectedConditions.visibilityOf(nomeDisplay));
		
		
		// alterando o e-mail
		WebElement emailDisplay = driver.findElement(By.id("email_rg_display_section"));
		emailDisplay.click();
		WebElement elementoEmail = driver.findElement(By.id("email_value"));
		elementoEmail.clear();
		elementoEmail.sendKeys(email);
		
		driver.findElement(By.cssSelector("#email_hv_editing_section > input[value='Salvar']")).click();
		wait.until(ExpectedConditions.visibilityOf(emailDisplay));
		
		// alterando o telefone
		WebElement telefoneDisplay = driver.findElement(By.id("phone_rg_display_section"));
		telefoneDisplay.click();
		WebElement elementoTelefone = driver.findElement(By.id("phone_value"));
		elementoTelefone.clear();
		elementoTelefone.sendKeys(telefone);
		
		driver.findElement(By.cssSelector("#phone_hv_editing_section > input[value='Salvar']")).click();
		wait.until(ExpectedConditions.visibilityOf(telefoneDisplay));
		
		// validacoes
		assertEquals(nome, driver.findElement(By.id("name_rg_display_section")).getText());
		assertEquals("Email: " + email, driver.findElement(By.id("email_rg_display_section")).getText());
		assertEquals("Telefone: " + telefone, driver.findElement(By.id("phone_rg_display_section")).getText());
		
	}
	
	@After
	public void posCondicao() throws Exception {
		driver.quit();
	}
}
