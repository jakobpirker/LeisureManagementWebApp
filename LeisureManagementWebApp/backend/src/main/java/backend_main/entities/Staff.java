package backend_main.entities;

import backend_main.entities.embedded_ids.PersonId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Staff {

    @EmbeddedId
    @JsonUnwrapped
    private PersonId id;

    @OneToMany(mappedBy = "staff", cascade= CascadeType.ALL)
    @JsonIgnore
    private List<Task> tasks;

    public Staff() {
        this.id = new PersonId();
    }

    public PersonId getId() {
        return id;
    }
}
