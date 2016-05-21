package backend_main.service;

import backend_main.entities.Greeting;
import backend_main.entities.Person;
import backend_main.repositories.GreetingRepository;
import backend_main.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepositoryService{

    @Autowired
    private PersonRepository person_repository_;

    @Autowired
    private GreetingRepository greeting_repository_;

    public Person save(final Person save_object){
        Person saved_object = this.person_repository_.save(save_object);
        return saved_object;
    }

    public Iterable<Person> getPersons(){
        return person_repository_.findAll();
    }

    public Greeting save(final Greeting save_object){
        Greeting saved_object = this.greeting_repository_.save(save_object);
        return saved_object;
    }

    public GreetingRepository getRepository() {
        return greeting_repository_;
    }
}
