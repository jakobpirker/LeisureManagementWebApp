package backend_main.entities;

import backend_main.entities.embedded_ids.AddressId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

@Entity
@JsonPropertyOrder({ "Nachname", "Vorname", "Adresse" })
public class Person {

    private static final Logger log = LoggerFactory.getLogger(Person.class);

    @Id
    @GeneratedValue
    @Column
    @JsonIgnore
    private Long id;

    @Column
    private String surname;

    @Column
    private String forename;

    @OneToOne
//    @JoinColumn(name = "address_id")
    private Address address;

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("Vorname")
    public String getForename() {
        return forename;
    }

    @JsonProperty("Vorname")
    public void setForename(String forename) {
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

//    @JsonProperty("Adresse")
//    public void setAddress(String id_string){ // throws IllegalArgumentException {
//        try {
//            this.address_id = Long.parseLong(id_string);
//        }
//        catch (NumberFormatException ex) {
////            throw new IllegalArgumentException("Couldn't convert id_string to Long");
//        }
//        this.address = null;
//        log.info("after address = null");
//    }

    @JsonProperty("Adresse")
    public void setAddressId(String id_string) throws Exception {
        //JSON from String to Object
        log.info(id_string);
        this.address_id = mapper.readValue(id_string, AddressId.class);
    }

    public AddressId getAddressId(){
        return this.address_id;
    }
}
