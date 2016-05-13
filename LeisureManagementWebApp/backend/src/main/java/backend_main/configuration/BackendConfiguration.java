/*
 * Project eOCS
 * Copyright @@@
 *
 * Created by clackner on 09.02.2015.
 */

package backend_main.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(value = "backend_main")
@Import(PersistenceConfiguration.class)
public class BackendConfiguration {
}
