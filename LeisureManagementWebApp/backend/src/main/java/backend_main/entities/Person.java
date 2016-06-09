package backend_main.entities;

import backend_main.entities.embedded_ids.AddressId;
import backend_main.entities.embedded_ids.PersonId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonPropertyOrder({ "id", "Telefonnummer", "Adresse" })
public class Person {

    @EmbeddedId
    @JsonUnwrapped
    private PersonId id;

    @JsonProperty("Telefonnummer")
    private String telnumber;

    @JsonProperty("Anwesenheit")
    private Boolean isattendant;

    @OneToOne
    private Address address;

    @OneToMany
    @JsonIgnore
    private List<Payment> payments;

    public Person() {
        this.telnumber = "";
        this.address = null;
        this.isattendant = false;
        this.id = new PersonId();
    }

    public PersonId getId() {
        return id;
    }

    public void setAddress(Address address) {
        this.address = address;
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
