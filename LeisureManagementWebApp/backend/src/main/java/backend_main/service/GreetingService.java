package backend_main.service;

import backend_main.entities.Greeting;
import backend_main.repositories.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository repository_;

    public Greeting save(final Greeting save_object){
        Greeting saved_object = this.repository_.save(save_object);
        return saved_object;
    }

    public GreetingRepository getRepository() {return repository_;}
}
