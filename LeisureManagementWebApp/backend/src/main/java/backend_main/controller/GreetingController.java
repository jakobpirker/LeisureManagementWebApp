package backend_main.controller;

import backend_main.entities.Greeting;
import backend_main.service.GreetingService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private static final Logger log = LoggerFactory.getLogger(GreetingController.class);

    @Autowired
    private GreetingService greetingService;

    @RequestMapping(value = "/greeting", method= RequestMethod.GET)
    public Greeting greeting() {
        log.info("Get-Request received!");

        Greeting current_greeting = new Greeting();
        return current_greeting;
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.POST)
    public Greeting post_greeting(@RequestBody Greeting new_greeting) {
        log.info("Post-Request received!");
        log.info("Greeting-Id: " + new_greeting.getId());
        log.info("Greeting-Content: " + new_greeting.getContent());
        new_greeting = this.greetingService.save(new_greeting);
        log.info("Greeting saved to DB!");

        return new_greeting;
    }
}
