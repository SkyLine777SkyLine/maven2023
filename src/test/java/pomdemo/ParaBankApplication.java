package pomdemo;

import static org.testng.Assert.assertEquals;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseClass;
import page_objects.AccountDetailsPage;
import page_objects.LoginPage;

public class ParaBankApplication extends BaseClass{
	
	private String username = "Irina";
	private String password = "lop";
	private String accntNumber = "12345";
	private String accntType = "CHECKING";
	private String accntBalance = "-$2899.00";
	
	@Test
	public void testLogin() throws InterruptedException {
		driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
		
		LoginPage loginPage = new LoginPage(driver);
		AccountDetailsPage accountDetailsPage = new AccountDetailsPage(driver);

		loginPage.insertUsername(username);
		loginPage.insertPassword(password);
		loginPage.clickLoginBtn();
		
		//verify logged in successfully
		Assert.assertTrue(accountDetailsPage.isLogoutDisplayed());
		assertEquals(accountDetailsPage.getAccountNumber(), accntNumber);
		
		//Open the account details
		accountDetailsPage.openAccountDetails();
		
		//Check account type
		wait.until(ExpectedConditions.textToBePresentInElement(accountDetailsPage.getAccountTypeElement(), "CHECKING"));
	    Assert.assertEquals(accountDetailsPage.getAccountTypeValue(), accntType);
	    Assert.assertEquals(accountDetailsPage.getAccountBalance(), accntBalance);
	  
	   // Assert.assertEquals(driver.findElement(By.id("availableBalance")).getText(), "$1000.00");
	    
	 //accountDetailsPage.removeFirstChar(accntBalance);
	 //System.out.println(accntBalance);
	}

}
