package base;

import java.io.FileInputStream;
import java.io.IOException;
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
	public WebDriver driver = null; // keep variable from outside from excel, database, properties file, of file
									// hold variables.
	public WebDriverWait wait; // Test case should be done, not changeable and all variables keep outside
//public long implicitWait = 20;
//public long explicitWait = 30;
	protected Properties properties;// keep properties outside the method

	@BeforeMethod
	public void setup() {

		// initialize your properties here
		try {
			properties = new Properties(); // Properties object
			FileInputStream fis = new FileInputStream("src\\main\\java\\properties\\application.properties");// location of the file
																											
			properties.load(fis);// load file
		} catch (IOException e1) {// catch (FileNotFoundException e1)
			// handle exception
			e1.printStackTrace();
		}
		String browser = properties.getProperty("browser.name");

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
		// driver.manage().window().setPosition(new Point(-100,0));//Point is a object,
		// we created it inside method
		// driver.manage().window().maximize();
		String implicitTimeStr = properties.getProperty("wait.time.implicit");
		long implicitTime = Long.parseLong(implicitTimeStr);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitTime));

		wait = new WebDriverWait(driver,
				Duration.ofSeconds(Long.parseLong(properties.getProperty("wait.time.explicit"))));
	}

	@AfterMethod
	public void close() {
		driver.close();
	}
}
