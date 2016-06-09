package backend_main.services;

import backend_main.entities.Address;
import backend_main.entities.embedded_ids.AddressId;
import backend_main.repositories.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends AbstractService<Address, AddressId, AddressRepository> {

    public String getJsonStringWithForeignIds() {
        return (object_mapper_.valueToTree(new Address())).toString();
    }
}
