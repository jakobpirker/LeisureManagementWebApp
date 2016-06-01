package backend_main.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

@Entity
public class Person {

    private static final Logger log = LoggerFactory.getLogger(Person.class);
    //    @JsonIgnore
//    ObjectMapper mapper = new ObjectMapper();

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

    @Transient
    @JsonIgnore
    private Long address_id;

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

    @JsonProperty("Adresse")
    public Address getAddress() {
        return this.address;
    }

    @JsonProperty("Adresse")
    public void setAddress(String id_string) throws IllegalArgumentException {
        try {
            this.address_id = Long.parseLong(id_string);
        }
        catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Couldn't convert id_string to Long");
        }
        this.address = null;
    }

//    @JsonProperty("Adresse")
//    public void setAddress(String address_str) throws Exception {
//        //JSON from String to Object
//        Address address = mapper.readValue(address_str, Address.class);
//        log.info("Person.java: " + address.getCity());
//        this.address = address;
//    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonIgnore
    public Long getAddressId(){
        return address_id;
    }

}
