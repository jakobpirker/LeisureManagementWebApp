package backend_main.controller;

import backend_main.entities.Greeting;
import backend_main.service.RepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/greeting")
public class GreetingController{

    protected static final Logger log = LoggerFactory.getLogger(GreetingController.class);

    @Autowired
    protected RepositoryService repository_service_;

    @RequestMapping(method= RequestMethod.GET)
    public Greeting getRequest() {
        log.info("Get-Request received!");
        return new Greeting();
    }

    @RequestMapping(value="/list", method= RequestMethod.GET)
    public Iterable<Greeting> getGreetings() {
        log.info("Get-List-Request received!");
        Iterable<Greeting> test = repository_service_.getRepository().findAll();
        return test;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Greeting postRequest(@RequestBody Greeting new_object) {
        log.info("Post-Request received!");
        new_object = this.repository_service_.save(new_object);
        log.info("Object saved to DB!");
        return new_object;
    }
}
