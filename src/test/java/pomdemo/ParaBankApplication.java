package pomdemo;

import static org.testng.Assert.assertEquals;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseClass;
import page_objects.AccountDetailsPage;
import page_objects.LoginPage;
import utilities.ExcelReader;

public class ParaBankApplication extends BaseClass{
	
	private String accntNumber = "13677";
	private String accntType = "CHECKING";
	private String accntBalance = "$$515.50";
	
	@Test(dataProvider = "dataProv1")
	public void testLogin(String username, String password) throws InterruptedException {
		driver.get(properties.getProperty("aplication.url.qa"));
	
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
	}
	   // Assert.assertEquals(driver.findElement(By.id("availableBalance")).getText(), "$1000.00");
	    
	 //accountDetailsPage.removeFirstChar(accntBalance);
	 //System.out.println(accntBalance);
		@DataProvider
		public Object[][] dataProv1() {
			ExcelReader excelReader = new ExcelReader("src\\main\\java\\testdata\\TestParaBank.xlsx", "Sheet1");
			return excelReader.getTableData("Table2");
	}

}
