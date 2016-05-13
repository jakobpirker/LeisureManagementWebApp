package backend_main.controller;

import backend_main.entities.Greeting;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController extends GeneralController<Greeting>{

    @RequestMapping(method= RequestMethod.GET)
    public Greeting getRequest() {
        log.info("Get-Request received!");
        return new Greeting();
    }
}
