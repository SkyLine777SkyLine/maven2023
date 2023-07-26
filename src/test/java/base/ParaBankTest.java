package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ParaBankTest extends BaseClass {
	
	@Test //Create new savings account
	public void Test1() {
		
		driver.get("https://parabank.parasoft.com/");
		driver.findElement(By.xpath("//div[@id = 'loginPanel']//input[@name='username']")).sendKeys("Irina_Skyline");
		
		driver.findElement(By.xpath("//div[@id = 'loginPanel']//input[@name='password']")).sendKeys("LetCodeit");
		
		driver.findElement(By.xpath("//div[@class = 'login']//input[@value='Log In']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Open New Account')]")).click();
		
		driver.findElement(By.xpath("//option[contains(text(),'SAVINGS')]")).click();
		driver.findElement(By.id("fromAccountId")).click();
		driver.findElement(By.xpath("//option[@label='16452']")).click();
		driver.findElement(By.xpath("//input[@value='Open New Account']")).click();
	}

}
