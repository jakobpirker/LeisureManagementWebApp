/*
 * Project eOCS
 * Copyright @@@
 *
 * Created by clackner on 09.02.2015.
 */

package core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author clackner
 * @version EOCS_VERSION-SNAPSHOT
 * @since EOCS_VERSION-SNAPSHOT
 */
@Controller
public class MainController {

    @RequestMapping(value = "/")
    public String main() {
        return "main";
    }
}
