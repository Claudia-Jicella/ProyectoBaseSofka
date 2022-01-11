package co.com.client.webproject.test.runners;

import co.com.sofka.test.utils.files.PropertiesFile;
import org.junit.BeforeClass;

import java.nio.file.Path;
import java.nio.file.Paths;

// TODO: configuracion y renombramiento del TestRunner (glue, feature, plugins)
public class TestRunner {

    @BeforeClass
    public static void setup() {

        Path propertiesFolder = Paths.get(System.getProperty("user.dir"), "src/main/resources/properties/");
        PropertiesFile propertiesFile = new PropertiesFile("default", propertiesFolder);
        // Seteo de la ruta en donde quedara la evidencia de acuerdo en el sistema opertivo que se este ejecutanto
        String rutaEvidencias;
        if(System.getProperty("os.name").contains("Windows")) {
            rutaEvidencias = propertiesFile.getFieldValue("files.evidence.windows");
        }else {
            rutaEvidencias = propertiesFile.getFieldValue("files.evidence.linux");
        }
        propertiesFile.updateFieldValue("files.evidence", rutaEvidencias);
    }


}
