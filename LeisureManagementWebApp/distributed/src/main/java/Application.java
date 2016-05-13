import backend_main.configuration.BackendConfiguration;
import backend_main.configuration.PersistenceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableAutoConfiguration(exclude = {
        DataSourceTransactionManagerAutoConfiguration.class,
        DataSourceAutoConfiguration.class
})
@Import(value = { BackendConfiguration.class, CoreWebuiModule.class })
@ComponentScan("core.controller")
public class Application {

    /*
        Einerseits werden die statischen Resourcen erreichbar sein via Default per Boot über:
            host:8080/<filename oder foldername inside resources/static/...>

        Und zusätzlich werden die anderen Resourcen (im Templates-Folder) per Thymeleaf gemappt.

        Und zuguterletzt werden die originalen API-Calls aufgerufen über die spez. URIs
     */

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}