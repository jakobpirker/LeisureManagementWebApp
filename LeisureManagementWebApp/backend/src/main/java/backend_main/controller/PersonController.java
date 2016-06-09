package backend_main.controller;

import backend_main.entities.Person;
import backend_main.services.PersonService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController extends AbstractController<Person, PersonService>{
}
