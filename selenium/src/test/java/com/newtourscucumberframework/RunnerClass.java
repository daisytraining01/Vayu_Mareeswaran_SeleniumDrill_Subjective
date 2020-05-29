package com.newtourscucumberframework;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)

@CucumberOptions(
		features = {"classpath:features"}, 
		glue = {"stepDefinition"},
		tags= {"@Launch,@Login,@DiffrentData"},
		plugin= {"pretty","html:target/Results/Cucumber"},
		dryRun = false, 
		monochrome= true
		)
public class RunnerClass {

}
