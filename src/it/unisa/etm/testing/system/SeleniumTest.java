package it.unisa.etm.testing.system;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class SeleniumTest {

	@Test
	public void inHome() {
		WebDriver browser;   

		browser = new ChromeDriver();    
		browser.get("http://localhost:8080/ETMPlatform/");   
		
		WebElement header = browser.findElement(By.id("site-header"));   

		assertTrue((header.isDisplayed()));   

		browser.close();
	}

}
