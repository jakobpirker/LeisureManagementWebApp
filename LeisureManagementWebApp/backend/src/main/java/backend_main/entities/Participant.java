package backend_main.entities;

import backend_main.entities.embedded_ids.PersonId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;

@Entity
//@JsonPropertyOrder({ "id", "Telefonnummer", "Adresse" })
public class Participant {

    @EmbeddedId
    @JsonUnwrapped
    private PersonId id;

    @OneToOne
    private Accommodation accommodation;

    public Participant(){
        this.id = new PersonId();
    }

    public PersonId getId() {
        return id;
    }

    public void setId(PersonId id) {
        this.id = id;
    }

    //---------------------------------------------------------------
    // serial- and deserializing specific content

    @Transient
    @JsonIgnore
    private String accommodation_id;

//    @JsonIgnore
//    @Transient
//    ObjectMapper mapper = new ObjectMapper();

    @JsonProperty("Unterkunft")
    public String getAccommodation() {
        if(this.accommodation != null)
        {
            return this.accommodation.getId();
        }
        else
        {
            return null;
        }
    }

    @JsonProperty("Unterkunft")
    public void setAccommodationId(String id_string) throws Exception {
        this.accommodation_id = id_string;
    }

    public String getAccommodationId(){
        return this.accommodation_id;
    }
    public void setAccommodation(Accommodation accommodation) { this.accommodation  = accommodation; }
}
