package backend_main.entities.embedded_ids;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@JsonPropertyOrder({"Nachname", "Vorname"})
public class PersonId implements Serializable {

    private String lastname;
    private String firstname;

    public PersonId(){
        this.lastname = "";
        this.firstname = "";
    }

    @JsonProperty("Nachname")
    public String getLastName() {
        return lastname;
    }

    @JsonProperty("Nachname")
    public void setLastName(String surname) {
        this.lastname = surname;
    }

    @JsonProperty("Vorname")
    public String getFirstName() {
        return firstname;
    }

    @JsonProperty("Vorname")
    public void setFirstName(String forename) {
        this.firstname = forename;
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
