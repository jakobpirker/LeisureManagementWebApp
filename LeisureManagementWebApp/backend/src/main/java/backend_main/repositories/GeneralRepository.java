package backend_main.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Jakob on 13.05.2016.
 */

@Repository
public class GeneralRepository<T> {

    @PersistenceContext
    private EntityManager em_;

    @Transactional
    public T save(final T save_object) {
        em_.persist(save_object);
        return save_object;
    }
}
