package backend_main.repositories;

import backend_main.entities.Person;
import backend_main.entities.embedded_ids.PersonId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PersonRepository extends CrudRepository<Person, PersonId> {
}
