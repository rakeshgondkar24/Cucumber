package qa.com.runner;

import org.junit.runner.RunWith;
import io.cucumber.core.*;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.*;


@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\rakesh.g\\OneDrive - Atyati Technologies Pvt Ltd\\Documents\\PROJECTS\\fedral\\self\\FEDAUTO\\FEDCRED\\Cucumber\\src\\main\\java\\qa\\com\\feature", 
glue="qa/com/stepDefinition", 
tags="@loggedinuser",
plugin= {"pretty","html:target/cucumber-reports"})
public class Runner {

}
