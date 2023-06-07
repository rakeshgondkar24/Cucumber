package qa.com.stepDefinition;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	WebDriver driver = null;
	public static Properties prop;
	
	@SuppressWarnings("deprecation")
	@Given("^the users launch the browser and loads Fedmithra web app$")
	public void goToFedApp() {
		System.setProperty("webdriver.edge.driver","E:\\Rakesh\\Automation\\Federal\\Driver\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id='details-button']")).click();
		driver.findElement(By.xpath("//*[@id='proceed-link']")).click();
		String title = driver.getTitle();
		System.out.println("loginpage title: " + title);
	}
	
	@When("user enters {string} and {string}")
	public void enterCredential(String username,String password) {
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		WebElement uname = driver.findElement(By.xpath("//input[@id='userId']"));
		System.out.println("Username:"+uname.isEnabled());
		WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
		System.out.println("Username:"+pass.isEnabled());
		if(uname.isEnabled()) {
			uname.sendKeys(username);
			if(pass.isEnabled()) {
				pass.sendKeys(password);
			}else {
				System.out.println("pass field is not enabled");
			}
		}else {
			System.out.println("uname field is not enabled");
		}
		
		
	}
	
	@And("^Clicks on login button$")
	public void clickBtn() {
		WebElement login = driver.findElement(By.xpath("//input[@id='loginBtn']"));
		login.click();
	}
	
	@Then("^home page is getting redirected$")
	public void Vvalidate() {
		String name = driver.getTitle();
		System.out.println("Title: "+name);
		System.out.println("TestPass");
	}
	
	@Then("^Error message should display$")
	public void Ivalidate() {
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		String ExpectedMessage="User not exist";
		String ActualMessage = driver.findElement(By.xpath("//*[text()='User not exist']")).getText();
		if(ActualMessage.equals(ExpectedMessage)) {
			System.out.println("TestPass");
		}else {
			System.out.println("TestFail");
			System.out.println("ActualMessage is: "+ ActualMessage);
		}
	}
	
}
