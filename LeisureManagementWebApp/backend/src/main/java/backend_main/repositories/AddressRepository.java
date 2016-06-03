package backend_main.repositories;

import backend_main.entities.Address;

import backend_main.entities.embedded_ids.AddressId;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository  extends CrudRepository<Address, Long> {

//    Address findById(AddressId id);
    Address findByCityAndStreetAndPostalcode(String city, String street, Integer postalcode);
    Iterable<Address> findByCity(String city);
}
