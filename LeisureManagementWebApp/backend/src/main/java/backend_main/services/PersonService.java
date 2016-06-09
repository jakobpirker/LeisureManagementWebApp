package backend_main.services;

import backend_main.entities.Address;
import backend_main.entities.Person;
import backend_main.entities.embedded_ids.PersonId;
import backend_main.repositories.AddressRepository;
import backend_main.repositories.PersonRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class PersonService extends AbstractService<Person, PersonId, PersonRepository>{

    @Autowired
    private AddressRepository address_repository_;

    @Override
    public Person save(Person save_person){

        // try to insert the valid address-object from the DB by it's id (from JSON)
        if(save_person.getAddress() == null && save_person.getAddressId() != null)
        {
            save_person.setAddress(address_repository_.findOne(save_person.getAddressId()));
        }
        return this.base_repository_.save(save_person);
    }

    public String getJsonStringObjectWithForeignIds() {

        JsonNode person = object_mapper_.valueToTree(new Person());
        JsonNode address_ids = object_mapper_.createArrayNode();

        Iterable<Address> addresses = address_repository_.findAll();

        for(Iterator<Address> i = addresses.iterator(); i.hasNext(); ) {
            ((ArrayNode) address_ids).add(object_mapper_.valueToTree(i.next().getId()));
        }

        ((ObjectNode) person).put("Adresse", address_ids);

        return person.toString();
    }
}
