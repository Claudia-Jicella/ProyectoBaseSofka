package co.com.client.webproject.test.stepdefinition;

import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.sofka.test.actions.Action;
import co.com.sofka.test.utils.files.PropertiesFile;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class StepsDefinition {

    // Utilidades Globales
    // archivo propiedades por defecto
    private PropertiesFile globalProps = Action.getPropertiesFiles();

    // archivo propiedades personalizado
    /*
    private Path propertiesFolder = Paths.get("src/main/resources/properties");
    private PropertiesFile customProps = new PropertiesFile("custom", propertiesFolder);
    */

    // Datos del flujo
    private TestInfo testInfo;


    @Before
    public void setUp(Scenario scenario) {

        //Se instancia el elemento que nos permitirá obtener información durante ejecución del ambiente,
        //escenario actual, y parametros desde el archivo .feature
        testInfo = new TestInfo(scenario);

    }

    @After
    public void tearDown() {
        // Cerrar el driver
    }


}
