package co.com.sofka.runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/rest.feature", // Ruta de los archivos .feature
        glue = "co.com.sofka.stepdefinitions", // Paquete donde se encuentran las clases de step definitions
        snippets = CucumberOptions.SnippetType.CAMELCASE
       // tags = "@test1"// Etiqueta para ejecutar solo escenarios específicos (opcional)
        // plugin = {"pretty", "html:target/cucumber-reports"} // Generación de reportes
)

public class SingleUserTest {
}
