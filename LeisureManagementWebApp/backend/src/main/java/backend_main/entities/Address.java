package backend_main.entities;

import backend_main.entities.embedded_ids.AddressId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import javax.persistence.*;

@Entity
//@IdClass(AddressId.class)
//@JsonPropertyOrder({ "Strasse", "Stadt", "Postleitzahl" })
public class Address {

    @EmbeddedId
    @JsonUnwrapped
    private AddressId id;

    @OneToOne(mappedBy = "address", cascade=CascadeType.ALL)
    @JsonIgnore // uncommenting causes crash -> Person creates address, address creates Person again...
    private Person person;

//    @JsonProperty("Strasse")
//    public String getStreet() {
//        return id.getStreet();
//    }
//
//    @JsonProperty("Strasse")
//    public void setStreet(String street) {
//        this.street = street;
//    }
//
//    @JsonProperty("Stadt")
//    public String getCity() {
//        return city;
//    }
//
//    @JsonProperty("Stadt")
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    @JsonProperty("Postleitzahl")
//    public Integer getPostalCode() {
//        return this.postalcode;
//    }
//
//    @JsonProperty("Postleitzahl")
//    public void setPostalCode(Integer postalcode) {
//        this.postalcode = postalcode;
//    }


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public AddressId getId(){
        return id;
    }

    public void setId(AddressId id) {
        this.id = id;
    }

}
