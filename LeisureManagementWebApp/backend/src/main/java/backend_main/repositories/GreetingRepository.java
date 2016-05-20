package backend_main.repositories;

import org.springframework.data.repository.CrudRepository;

import backend_main.entities.Greeting;

import java.util.List;

public interface GreetingRepository extends CrudRepository<Greeting, Long> {

    Greeting findById(Long id);
}
