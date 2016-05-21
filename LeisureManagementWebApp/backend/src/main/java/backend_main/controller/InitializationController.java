package backend_main.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/init")
public class InitializationController {

    // TODO: change to Object List with Name, get-url and list-url
    private List<String> entities_;

    public InitializationController(){
        this.entities_.add("Greeting");
        this.entities_.add("Person");
    }

    @RequestMapping(value = "/entities", method = RequestMethod.GET)
    public List<String> getEntities() {
        return this.entities_;
    }
}
