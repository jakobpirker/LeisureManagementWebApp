package backend_main.services;

import backend_main.entities.Address;
import backend_main.entities.embedded_ids.AddressId;
import backend_main.repositories.AddressRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class AddressService extends AbstractService<Address, AddressId, AddressRepository>{

    public String getJsonStringObjectWithForeignIds() {
        return (object_mapper_.valueToTree(new Address())).toString();
    }
}
