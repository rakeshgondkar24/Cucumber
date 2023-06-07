package qa.com.TestBase;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {
	public WebDriver driver;
	public Properties prop;
	
	public Base() throws Exception{
		prop = new Properties();
	}
	
	public void Intialization() {
		System.setProperty("webdriver.edge.driver", "E:\\Rakesh\\Automation\\Federal\\Driver\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id='details-button']")).click();
		driver.findElement(By.xpath("//*[@id='proceed-link']")).click();
	}
	
}
