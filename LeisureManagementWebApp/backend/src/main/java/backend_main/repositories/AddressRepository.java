package backend_main.repositories;

import backend_main.entities.Address;

import backend_main.entities.embedded_ids.AddressId;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository  extends CrudRepository<Address, AddressId> {
}
