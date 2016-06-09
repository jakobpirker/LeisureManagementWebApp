package backend_main.services;

import backend_main.entities.Participant;
import backend_main.entities.embedded_ids.PersonId;
import backend_main.repositories.ParticipantRepository;
import org.springframework.stereotype.Service;

@Service
public class ParticipantService extends AbstractService<Participant, PersonId, ParticipantRepository>{

    public String getJsonStringObjectWithForeignIds() {
        return (object_mapper_.valueToTree(new Participant())).toString();
    }
}
