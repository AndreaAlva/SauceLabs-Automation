import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
/*@CucumberOptions(
        features = "src/test/resources/HomePage.feature",
        glue = {"StepDefinitions"},
        tags = "@CartNumberisincremented"

)*/
@CucumberOptions(
        features = "src/test/resources/HomePage.feature",
        glue = {"StepDefinitions"},
        tags = "@LowtoHighsort"

)
public class TestRunner {
}