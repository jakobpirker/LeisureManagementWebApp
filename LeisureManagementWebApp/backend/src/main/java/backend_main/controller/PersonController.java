package backend_main.controller;

import backend_main.entities.Address;
import backend_main.entities.Person;
import backend_main.entities.embedded_ids.AddressId;
import backend_main.repositories.AddressRepository;
import backend_main.services.RepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController{

    private static final Logger log = LoggerFactory.getLogger(Person.class);

    @Autowired
    private AddressRepository address_repository_;

    @Autowired
    protected RepositoryService service_;

    @RequestMapping(method = RequestMethod.GET)
    public Person getRequest() {
        return new Person();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Person postRequest(@RequestBody Person new_person) {
        log.info("before *.save(new_person)");
//        log.info(Long.toString(new_person.getAddressId()));
        new_person = this.service_.save(new_person);
        log.info("after *.save(new_person)");
        return new_person;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Iterable<Person> getList() {
        return service_.getPersons();
    }

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public Address getTest1() {
        return address_repository_.findById(new AddressId("34 t", "graz", 11));
    }

//    @RequestMapping(value = "/test2", method = RequestMethod.GET)
//    public Iterable<Address> getTest2() {
//        return service_.getAddressesByCity("graz");
//    }
}
