package qa.com.stepDefinition;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.com.TestBase.*;
import qa.com.pages.*;

public class StepDefinition extends Base{
	//WebDriver driver = null;
	public static Properties prop;
	public LoginPage login;
	
	public StepDefinition() throws Exception{
		super();
	}
	
	@Before
	@Given("^the users launch the browser and loads Fedmithra web app$")
	public void setUp() {
		Intialization();
	}
	
	
	@When("user enters {string} and {string}")
	public void enterCredential(String Username,String Password) throws Exception {
		/*driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
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
		}*/
		login = new LoginPage();
		try {
			login.Login(Username, Password);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@And("^Clicks on login button$")
	public void clickBtn() throws Exception {
		//WebElement login = driver.findElement(By.xpath("//input[@id='loginBtn']"));
		//login.click();
		login = new LoginPage();
		login.btnLogin();
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
	
	@After
	public void cleanUp() {
		Teardown();
	}
	
}
