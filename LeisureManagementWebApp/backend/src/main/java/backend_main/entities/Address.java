package backend_main.entities;

import backend_main.entities.embedded_ids.AddressId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import javax.persistence.*;

@Entity
@JsonPropertyOrder({ "Straße", "Stadt", "Postleitzahl" })
public class Address {

    @EmbeddedId
    @JsonUnwrapped
    private AddressId id;

    @OneToOne(mappedBy = "address", cascade=CascadeType.ALL)
    @JsonIgnore // uncommenting causes crash -> Person creates address, address creates Person again...
    private Person person;

    public Address(){
        id = new AddressId();
        person = null;
    }

    public AddressId getId(){
        return id;
    }

    public void setId(AddressId id) {
        this.id = id;
    }

}
