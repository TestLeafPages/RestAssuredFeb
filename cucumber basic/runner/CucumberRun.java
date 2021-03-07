package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/feature/IncidentManagement.feature"}
				,glue = {"steps"}
				,monochrome = true)
public class CucumberRun extends AbstractTestNGCucumberTests{

}
