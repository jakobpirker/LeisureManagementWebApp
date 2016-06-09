package backend_main.controller;

import backend_main.entities.Participant;
import backend_main.services.ParticipantService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/participant")
public class ParticipantController extends AbstractController<Participant, ParticipantService>{
}
