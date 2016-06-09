package backend_main.services;

import backend_main.entities.Accommodation;
import backend_main.entities.Participant;
import backend_main.entities.embedded_ids.PersonId;
import backend_main.repositories.AccommodationRepository;
import backend_main.repositories.ParticipantRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class ParticipantService extends AbstractService<Participant, PersonId, ParticipantRepository>{

    @Autowired
    private AccommodationRepository accommodation_repository_;

    @Override
    public Participant save(Participant save_participant){

        // try to insert the valid address-object from the DB by it's id (from JSON)
        if(save_participant.getAccommodation() == null && save_participant.getAccommodationId() != null)
        {
            save_participant.setAccommodation(accommodation_repository_.findOne(save_participant.getAccommodationId()));
        }
        return this.base_repository_.save(save_participant);
    }

    public String getJsonStringWithForeignIds() {

        JsonNode person = object_mapper_.valueToTree(new Participant());
        JsonNode address_ids = object_mapper_.createArrayNode();

        Iterable<Accommodation> accomodations = accommodation_repository_.findAll();

        for(Iterator<Accommodation> i = accomodations.iterator(); i.hasNext(); ) {
            ((ArrayNode) address_ids).add(object_mapper_.valueToTree(i.next().getId()));
        }

        ((ObjectNode) person).put("Unterkunft", address_ids);

        return person.toString();
    }
}
