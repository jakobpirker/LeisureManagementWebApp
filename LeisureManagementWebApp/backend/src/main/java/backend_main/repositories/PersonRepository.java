package backend_main.repositories;

import backend_main.entities.Person;
import backend_main.entities.embedded_ids.PersonId;

public interface PersonRepository extends AbstractRepository<Person, PersonId> {
}
