package backend_main.repositories;

import backend_main.entities.Greeting;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Jakob on 03.05.2016.
 */
@Repository
public class GreetingRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Greeting save(final Greeting greeting) {
            em.persist(greeting);
            return greeting;
    }
}
