package cano.chaparro.daniel.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= {"src/test/resources/features" },
        glue="cano/chaparro/daniel/stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@testcolor"
)
public class ApiRestTest {
}
