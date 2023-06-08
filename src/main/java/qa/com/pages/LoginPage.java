package qa.com.pages;
import qa.com.TestBase.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage extends Base{
	@FindBy(xpath="//input[@id='userId']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='loginBtn']")
	WebElement loginbutton;
	
	public LoginPage() throws Exception {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void Login(String uname, String passwd) {
		try {
			if(username.isDisplayed()) {
				if(username.isEnabled()) {
					username.sendKeys(uname);
					if(password.isDisplayed()) {
						if(password.isEnabled()) {
							password.sendKeys(passwd);
						}else {
							System.out.println("password field is not enabled");
						}
					}else {
						System.out.println("password field is not displayed");
					}
				}else {
					System.out.println("username field is not enabled");
				}
			}else {
				System.out.println("Username field is not displayed");
			}
			//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
			/*username.sendKeys(uname);
			//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
			password.sendKeys(passwd);*/
		}catch(Exception e) {
			System.out.println("This is from LoginPage Login() method");
			e.printStackTrace();
		}
	}
	
	public void btnLogin() {
		try {
			if(loginbutton.isEnabled()) {
				loginbutton.click();
			}else {
				System.out.println("Login button is not enabled");
			}
		}catch(Exception e) {
			System.out.println();
			e.printStackTrace();
		}
	}

}
