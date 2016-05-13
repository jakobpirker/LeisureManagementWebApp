package backend_main.controller;

import backend_main.service.GeneralService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.ParameterizedType;

/**
 * Created by Jakob on 13.05.2016.
 */

@RestController
public class GeneralController<T> {

    protected static final Logger log = LoggerFactory.getLogger(GreetingController.class);

    @Autowired
    protected GeneralService<T> service_;

    @RequestMapping(method = RequestMethod.POST)
    public T postRequest(@RequestBody T new_object) {
        log.info("Post-Request received!");
        new_object = this.service_.save(new_object);
        log.info("Object saved to DB!");
        return new_object;
    }
}
