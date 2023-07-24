package base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
public WebDriver driver = null; //keep variable from outside from excel, database, properties file, of file hold variables. 
public WebDriverWait wait; //Test case should be done, not changeable and all variables keep outside
//public long implicitWait = 20;
//public long explicitWait = 30;
protected Properties properties;

	@BeforeMethod
	public void setup() {
		
			String browser = "chrome";

			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.firefox.driver", "C:\\webdrivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", "C:\\webdrivers\\msedgedriver.exe");
				driver = new EdgeDriver();
			}
			//
			//driver.manage().window().setPosition(new Point(-100,0));//Point is a object, we created it inside method
			//driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTimeImplicit));
			
			wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeExplicit)); //waitTimeExplicit
		}
	@AfterMethod
	public void close() {
		driver.close();
	}
	}

	
