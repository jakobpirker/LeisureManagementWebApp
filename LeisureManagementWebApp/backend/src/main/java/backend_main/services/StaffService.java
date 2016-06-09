package backend_main.services;

import backend_main.entities.Staff;
import backend_main.entities.embedded_ids.PersonId;
import backend_main.repositories.StaffRepository;
import org.springframework.stereotype.Service;

@Service
public class StaffService extends AbstractService<Staff, PersonId, StaffRepository>{
    public String getJsonStringWithForeignIds() {
        return (object_mapper_.valueToTree(new Staff())).toString();
    }
}

