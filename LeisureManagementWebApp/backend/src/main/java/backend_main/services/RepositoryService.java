package backend_main.services;

import backend_main.entities.Greeting;
import backend_main.entities.Person;
import backend_main.entities.Address;

import backend_main.entities.embedded_ids.AddressId;
import backend_main.repositories.GreetingRepository;
import backend_main.repositories.PersonRepository;
import backend_main.repositories.AddressRepository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class RepositoryService{

    private static final Logger log = LoggerFactory.getLogger(RepositoryService.class);

    @Autowired
    private PersonRepository person_repository_;

    @Autowired
    private GreetingRepository greeting_repository_;

    @Autowired
    private AddressRepository address_repository_;

    public Person save(Person save_person){

        // try to insert the valid address-object from the DB by it's id (from JSON)
        if(save_person.getAddress() == null && save_person.getAddressId() != null)
        {
            save_person.setAddress(address_repository_.findById(save_person.getAddressId()));
        }
        return this.person_repository_.save(save_person);
    }

    public Iterable<Person> getPersons(){
        return person_repository_.findAll();
    }

    public Greeting save(Greeting save_object){
        return this.greeting_repository_.save(save_object);
    }

    public Iterable<Greeting> getGreetings(){
        return greeting_repository_.findAll();
    }

    public Address save(Address save_object){
        return this.address_repository_.save(save_object);
    }

    public Iterable<Address> getAddresses(){
        return address_repository_.findAll();
    }

    public String addAvailableForeignIdsToPerson() {

        ObjectMapper mapper = new ObjectMapper();

        JsonNode person = mapper.valueToTree(new Person());
        JsonNode address_ids = mapper.createArrayNode();

        Iterable<Address> addresses = address_repository_.findAll();

        for(Iterator<Address> i = addresses.iterator(); i.hasNext(); ) {
            ((ArrayNode) address_ids).add(mapper.valueToTree(i.next().getId()));
        }

        ((ObjectNode) person).put("Adresse", address_ids);
//        ((ObjectNode) person).

        return person.toString();
    }
}
