package backend_main.controller;

import backend_main.entities.Address;
import backend_main.services.AddressService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController extends AbstractController<Address, AddressService> {
}
