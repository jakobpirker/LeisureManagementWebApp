package backend_main.repositories;

import backend_main.entities.Address;

import org.springframework.data.repository.CrudRepository;

public interface AddressRepository  extends CrudRepository<Address, Long> {

    Address findById(Long id);
}
