package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "D:\\May_maven_cucumbmer\\Features",
		glue = {"stepDefintion"},
		dryRun = false,
	//	tags = "@End2End",
		monochrome = true,
		plugin = {"pretty","html:Reports/index.html","junit:Reports/cucumber.xml","json:Reports/cucumber.json"}
		)
public class TestRunner {

}
