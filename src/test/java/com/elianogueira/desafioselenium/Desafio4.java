package com.elianogueira.desafioselenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Desafio4 {

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
		
		driver.get("http://eliasnogueira.com/arquivos_blog/selenium/desafio/4desafio/");
	}

	@Test
	public void testeAutoPreenchimentoCampos() {
		
		WebElement cep = driver.findElement(By.id("cep"));
		cep.sendKeys("01310200");
		
		// dispara o evento onblur do campo cep
		new Actions(driver).moveToElement(cep).click().perform();
		
		driver.findElement(By.id("numero")).sendKeys("1578");
		driver.findElement(By.id("complemento")).sendKeys("MASP");
		
		wait.until(ExpectedConditions.textToBePresentInElementValue(By.id("rua"), "Avenida: Paulista"));
		
		// validando os dados que foram preenchidos automaticamente
		assertEquals("Avenida: Paulista", driver.findElement(By.id("rua")).getAttribute("value"));
		assertEquals("Bela Vista", driver.findElement(By.id("bairro")).getAttribute("value"));
		assertEquals("São Paulo", driver.findElement(By.id("cidade")).getAttribute("value"));
		assertEquals("SP", driver.findElement(By.id("estado")).getAttribute("value"));
	}
	
	@After
	public void posCondicao() throws Exception {
		driver.quit();
	}

}
