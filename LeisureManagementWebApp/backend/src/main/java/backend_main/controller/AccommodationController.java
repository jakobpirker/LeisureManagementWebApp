package backend_main.controller;

import backend_main.entities.Accommodation;
import backend_main.services.AccommodationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accommodation")
public class AccommodationController extends AbstractController<Accommodation, AccommodationService>{
}
