package com.elianogueira.desafioselenium;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Desafio3 {

	private WebDriver driver = null;
	private WebDriverWait wait = null;
	
	@Before
	public void preCondicao() throws Exception {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		
		driver.get("http://eliasnogueira.com/arquivos_blog/selenium/desafio/3desafio/");
	}

	@Test
	public void testeDragAndDrop() {

		// necessario maximizar a pagina para o drap and drop dos itens
		driver.manage().window().maximize();
		
		// localiza os elementos
		WebElement iPhone = driver.findElement(By.cssSelector("img[alt='iPhone']"));
		WebElement iPodShuffle = driver.findElement(By.cssSelector("img[alt='iPod Shuffle']"));
		WebElement appleTV = driver.findElement(By.cssSelector("img[alt='Apple TV']"));
		WebElement carrinho = driver.findElement(By.cssSelector(".content.drop-here.ui-droppable"));
		
		// adiciona, via drag and drop, os itens no carrinho
		Actions action = new Actions(driver);
		Action dragAndDrop = null;
		
		dragAndDrop = action.clickAndHold(iPhone).moveToElement(carrinho).release().build();
		dragAndDrop.perform();
		
		dragAndDrop = action.clickAndHold(iPodShuffle).moveToElement(carrinho).release().build();
		dragAndDrop.perform();
		
		dragAndDrop = action.clickAndHold(appleTV).moveToElement(carrinho).release().build();
		dragAndDrop.perform();
		
		// espera os elementos serem adicionados ao carrinho
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#table_3 > tbody > tr > td")));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#table_4 > tbody > tr > td")));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#table_6 > tbody > tr > td")));
		
		// checkout
		driver.findElement(By.cssSelector(".button")).click();
		
		// validacoes
		assertEquals("1 x iPhone", driver.findElement(By.xpath("//h2[1]")).getText());
		assertEquals("1 x iPod Shuffle", driver.findElement(By.xpath("//h2[2]")).getText());
		assertEquals("1 x Apple TV", driver.findElement(By.xpath("//h2[3]")).getText());
		assertEquals("Total: R$ 749", driver.findElement(By.xpath("//h1[2]")).getText());
	}
	
	@After
	public void posCondicao() throws Exception {
		driver.quit();
	}

}
