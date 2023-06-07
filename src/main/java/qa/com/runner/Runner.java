package qa.com.runner;

import org.junit.runner.RunWith;
import io.cucumber.core.*;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.*;


@RunWith(Cucumber.class)
@CucumberOptions(features="E:\\Rakesh\\Automation\\Federal\\FED00A\\cucumberfed\\src\\main\\java\\qa\\com\\feature", 
glue="qa/com/stepDefinition", 
tags="@invaliddata",
plugin= {"pretty","html:target/cucumber-reports"})

public class Runner {

}
