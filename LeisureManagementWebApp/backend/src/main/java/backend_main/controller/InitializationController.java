package backend_main.controller;

import backend_main.utils.JavaScriptEntityLink;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/init")
public class InitializationController {

    private List<JavaScriptEntityLink> entities_ = new ArrayList<JavaScriptEntityLink>();;

    public InitializationController(){
        this.entities_.add(new JavaScriptEntityLink("Personen", "http://localhost:8080/person", "http://localhost:8080/person/list"));
        this.entities_.add(new JavaScriptEntityLink("Adressen", "http://localhost:8080/address", "http://localhost:8080/address/list"));
        this.entities_.add(new JavaScriptEntityLink("Teilnehmer", "http://localhost:8080/participant", "http://localhost:8080/participant/list"));
    }

    @RequestMapping(value = "/entities", method = RequestMethod.GET)
    public List<JavaScriptEntityLink> getEntities() {
        return this.entities_;
    }
}
