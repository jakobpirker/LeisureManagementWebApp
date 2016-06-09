package backend_main.controller;

import backend_main.entities.Staff;
import backend_main.services.StaffService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
public class StaffController extends AbstractController<Staff, StaffService>{
}
