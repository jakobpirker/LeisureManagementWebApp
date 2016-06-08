package backend_main.entities.embedded_ids;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@JsonPropertyOrder({"Nachname", "Vorname"})
public class PersonId implements Serializable {

    private String surname;
    private String forename;

    public PersonId(){
        this.surname = "";
        this.forename = "";
    }

    public PersonId(String surname, String forename){
        this.surname = surname;
        this.forename = forename;
    }

    @JsonProperty("Nachname")
    public String getSurname() {
        return surname;
    }

    @JsonProperty("Nachname")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @JsonProperty("Vorname")
    public String getForename() {
        return forename;
    }

    @JsonProperty("Vorname")
    public void setForename(String forename) {
        this.forename = forename;
    }

    @Override
    public boolean equals(Object obj){
        return (obj!=null &&
                obj instanceof PersonId &&
                surname.equals(((PersonId)obj).getSurname())  &&
                forename.equals(((PersonId)obj).getSurname()));
    }

    @Override
    public int hashCode(){
        return (forename + surname).hashCode();
    }
}
