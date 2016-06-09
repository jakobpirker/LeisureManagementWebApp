package backend_main.controller;

import backend_main.entities.Address;
import backend_main.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController{

    @Autowired
    protected AddressService repository_service_;

    @RequestMapping(method = RequestMethod.GET)
    public Address getRequest() {
        return new Address();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Address postRequest(@RequestBody Address new_address) {
        return this.repository_service_.save(new_address);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Iterable<Address> getList() {
        return repository_service_.getList();
    }
}
