package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepdef",
        tags = " @Signup or @Login or @Homepage or @Contact or @AboutUs or @Cart",
        plugin = {"pretty",
                "html:build/reports/cucumber/report.html",
                "json:build/reports/cucumber/report.json"}
)

public class Test {
}
