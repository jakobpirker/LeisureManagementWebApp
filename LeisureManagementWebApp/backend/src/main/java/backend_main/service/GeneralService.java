package backend_main.service;

import backend_main.repositories.GeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jakob on 13.05.2016.
 */

@Service
public class GeneralService<T> {

    @Autowired
    private GeneralRepository<T> repository_;

    public T save(final T save_object){
        T saved_object = this.repository_.save(save_object);
        return saved_object;
    }
}
