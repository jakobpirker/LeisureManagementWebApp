package backend_main.repositories;

import backend_main.entities.Person;
import backend_main.entities.embedded_ids.PersonId;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, PersonId> {
}
