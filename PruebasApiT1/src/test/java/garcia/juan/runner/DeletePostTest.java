package garcia.juan.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources\\features\\deletePostJson.feature",
        glue = "garcia.juan.stepdefinition",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@NoValidID"

)
public class DeletePostTest {
}
