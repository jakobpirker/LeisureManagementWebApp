package backend_main.service;

import backend_main.entities.Greeting;
import backend_main.repositories.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jakob on 03.05.2016.
 */
@Service
public class GreetingService {

    @Autowired
    private GreetingRepository repository;

    public Greeting save(final Greeting greeting){
        Greeting savedGreeting = this.repository.save(greeting);
        return savedGreeting;
    }
}
