package backend_main.entities;

import backend_main.entities.embedded_ids.AddressId;
import backend_main.entities.embedded_ids.PersonId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;

@Entity
@JsonPropertyOrder({ "id", "Telefonnummer", "Adresse" })
public class Person {

    @EmbeddedId
    @JsonUnwrapped
    private PersonId id;

    private String telnumber;

    @OneToOne
    private Address address;

    @OneToOne
    private Participant participant;

    public Person() {
        this.telnumber = "";
        this.address = null;
        this.id = new PersonId();
    }

    public PersonId getId() {
        return id;
    }

    public void setId(PersonId id) {
        this.id = id;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonProperty("Telefonnummer")
    public String getTelnumber() {
        return telnumber;
    }

    @JsonProperty("Telefonnummer")
    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    //---------------------------------------------------------------
    // serial- and deserializing specific content

    @Transient
    @JsonIgnore
    private AddressId address_id;

    @JsonIgnore
    @Transient
    ObjectMapper mapper = new ObjectMapper();

    @JsonProperty("Adresse")
    public AddressId getAddress() {
        if(this.address != null)
        {
            return this.address.getId();
        }
        else
        {
            return null;
        }
    }

    @JsonProperty("Adresse")
    public void setAddressId(String id_string) throws Exception {
        if(id_string != null) {
            this.address_id = mapper.readValue(id_string, AddressId.class);
        }
        else {
            this.address_id = null;
        }
    }

    public AddressId getAddressId(){
        return this.address_id;
    }
}
