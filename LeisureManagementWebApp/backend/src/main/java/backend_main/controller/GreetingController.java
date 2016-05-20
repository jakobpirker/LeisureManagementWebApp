package backend_main.controller;

import backend_main.entities.Greeting;
import backend_main.service.GeneralService;
import backend_main.service.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController{

    protected static final Logger log = LoggerFactory.getLogger(GreetingController.class);

    @Autowired
    protected GreetingService service_;

    @RequestMapping(method= RequestMethod.GET)
    public Greeting getRequest() {
        log.info("Get-Request received!");
        return new Greeting();
    }

    @RequestMapping(value="/list", method= RequestMethod.GET)
    public Iterable<Greeting> getGreetings() {
        log.info("Get-List-Request received!");
//        Long id = 1L;
//        Greeting test = service_.getRepository().findById(id);
//        log.info("Greeting ID: " + String.valueOf(test.getId()));
//        log.info("Greeting content: " + test.getContent());
//        log.info("Greeting add_cont: " + test.getAddContent());
        Iterable<Greeting> test = service_.getRepository().findAll();
//        for(Iterator<Greeting> i = test.iterator(); i.hasNext(); ) {
//            Greeting item = i.next();
//            log.info("Greeting ID: " + String.valueOf(item.getId()));
//            log.info("Greeting content: " + item.getContent());
//            log.info("Greeting add_cont: " + item.getAddContent());
//        }
        return test;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Greeting postRequest(@RequestBody Greeting new_object) {
        log.info("Post-Request received!");
        new_object = this.service_.save(new_object);
        log.info("Object saved to DB!");
        return new_object;
    }
}
