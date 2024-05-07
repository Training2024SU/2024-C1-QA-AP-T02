package co.com.sofka.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/PostRegistroRegres.feature",
        glue = "co.com.sofka.stepdefinition",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@test1",
        publish = true
)
public class RegresPostTest {
}
