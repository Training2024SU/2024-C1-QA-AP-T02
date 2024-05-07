package co.com.prueba.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "co.com.prueba.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@test4",
        publish = true
)
public class FormularioTest {

}
