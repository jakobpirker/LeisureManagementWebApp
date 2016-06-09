package backend_main.services;

import backend_main.entities.Accommodation;
import backend_main.entities.Address;
import backend_main.entities.Person;
import backend_main.repositories.AccommodationRepository;
import backend_main.repositories.AddressRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class AccommodationService extends AbstractService<Accommodation, String, AccommodationRepository>{

    @Autowired
    private AddressRepository address_repository_;

    @Override
    public Accommodation save(Accommodation save_accomodation){

        // try to insert the valid address-object from the DB by it's id (from JSON)
        if(save_accomodation.getAddress() == null && save_accomodation.getAddressId() != null)
        {
            save_accomodation.setAddress(address_repository_.findOne(save_accomodation.getAddressId()));
        }
        return this.base_repository_.save(save_accomodation);
    }

    public String getJsonStringWithForeignIds() {

        JsonNode person = object_mapper_.valueToTree(new Accommodation());
        JsonNode address_ids = object_mapper_.createArrayNode();

        Iterable<Address> addresses = address_repository_.findAll();

        for(Iterator<Address> i = addresses.iterator(); i.hasNext(); ) {
            ((ArrayNode) address_ids).add(object_mapper_.valueToTree(i.next().getId()));
        }

        ((ObjectNode) person).put("Adresse", address_ids);

        return person.toString();
    }
}
