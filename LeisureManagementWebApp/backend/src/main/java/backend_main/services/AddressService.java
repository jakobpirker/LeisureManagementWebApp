package backend_main.services;

import backend_main.entities.Address;
import backend_main.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository address_repository_;

    public Address save(Address save_object){
        return this.address_repository_.save(save_object);
    }

    public Iterable<Address> getList(){
        return address_repository_.findAll();
    }
}
