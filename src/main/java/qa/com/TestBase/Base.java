package qa.com.TestBase;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {
	public static WebDriver driver;
	public Properties prop;
	
	
	public Base() throws Exception{
		prop = new Properties();
		String propfile="E:\\Rakesh\\Automation\\Federal\\FEDMITHRA\\Cucumber\\src\\main\\java\\qa\\com\\config\\config.Properties";
		FileInputStream file = new FileInputStream(propfile);
		prop.load(file);
	}
	
	public void Intialization() {
		System.setProperty("webdriver.edge.driver", "E:\\Rakesh\\Automation\\Federal\\Driver\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		//driver.get("https://10.10.1.16/fedmithraportal");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id='details-button']")).click();
		driver.findElement(By.xpath("//*[@id='proceed-link']")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	}
	
	public void Teardown() {
		driver.close();
	}
}
