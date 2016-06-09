package backend_main.entities.embedded_ids;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@JsonPropertyOrder({"Nachname", "Vorname"})
public class PersonId implements Serializable {

    @JsonProperty("Nachname")
    private String lastname;

    @JsonProperty("Vorname")
    private String firstname;

    public PersonId(){
        this.lastname = "";
        this.firstname = "";
    }

    @JsonIgnore
    public String getLastName() {
        return lastname;
    }

    @JsonIgnore
    public String getFirstName() {
        return firstname;
    }

    @Override
    public boolean equals(Object obj){
        return (obj!=null &&
                obj instanceof PersonId &&
                lastname.equals(((PersonId)obj).getLastName())  &&
                firstname.equals(((PersonId)obj).getFirstName()));
    }

    @Override
    public int hashCode(){
        return (firstname + lastname).hashCode();
    }
}
