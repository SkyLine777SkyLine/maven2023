package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver =null;
	//Locators
	By usernameBox = By.name("username");
	By passwordBox = By.name("password");
	By loginBtn = By.xpath("//input[@value='Log In']");
	
	//constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		}
	//Action of elements
public void insertUsername(String username) {
	driver.findElement(usernameBox).sendKeys(username);
}
public void insertPassword(String password) {
	driver.findElement(passwordBox).sendKeys(password);
}
public void clickLoginBtn() {
	driver.findElement(loginBtn).click();
}
}


