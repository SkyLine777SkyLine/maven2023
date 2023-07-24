package sync;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;

public class SeleniumWaits extends BaseClass {
		
		//Create explicit wait:
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
//	@Test
	public void alertDelay() {
	driver.get("file:///C:/Users/ipros/Desktop/waits.html");
		
		//1.Delayed Alert:
		driver.findElement(By.id("alert")).click();
		//I need wait here:
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();

}
//	@Test
	public void textMsg() {
		driver.get("file:///C:/Users/ipros/Desktop/waits.html");
		driver.findElement(By.id("populate-text")).click();
		
		//Wait here:
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("h2")), "Selenium Webdriver"));
		String text = driver.findElement(By.id("h2")).getText();
		
		Assert.assertEquals(text, "Selenium Webdriver");
				}
	@Test
	
	public void hiddenButton() {
		driver.get("file:///C:/Users/ipros/Desktop/waits.html");
		driver.findElement(By.id("display-other-button")).click();
		
		//Wait here:
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hidden")));
		
		driver.findElement(By.id("hidden")).click();
		
	}
	//@Test
	public void enableButton() {
		driver.get("file:///C:/Users/ipros/Desktop/waits.html");
		driver.findElement(By.id("enable-button")).click();
	
		//Wait here:
		wait.until(ExpectedConditions.elementToBeClickable(By.id("enable-button")));
		driver.findElement(By.id("disable")).click();
	}
	//@Test
	public void elementIsSelected() {
		driver.get("file:///C:/Users/ipros/Desktop/waits.html");
		driver.findElement(By.id("checkbox")).click();
		
		//Wait here:
		wait.until(ExpectedConditions.elementToBeSelected(By.id("ch")));
	
		//driver.findElement(By.id("ch")).click();
		Assert.assertTrue(driver.findElement(By.id("ch")).isSelected());
	}
	
}
