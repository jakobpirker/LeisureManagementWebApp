package backend_main.repositories;

import backend_main.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

    Person findById(Long id);
}
