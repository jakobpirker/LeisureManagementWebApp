package backend_main.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue
    @Column
    @JsonIgnore
    private Long id;

    @Column
    private Integer postalcode;

    @Column
    private String city;

    @Column
    private String street;

    @OneToOne(mappedBy = "address", cascade=CascadeType.ALL)
    @JsonIgnore // uncommenting causes crash -> Person creates address, address creates Person again...
    private Person person;

    @JsonProperty("Postleitzahl")
    public Integer getPostalCode() {
        return this.postalcode;
    }

    @JsonProperty("Postleitzahl")
    public void setPostalCode(Integer postalcode) {
        this.postalcode = postalcode;
    }

    @JsonProperty("Stadt")
    public String getCity() {
        return city;
    }

    @JsonProperty("Stadt")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("Strasse")
    public String getStreet() {
        return street;
    }

    @JsonProperty("Strasse")
    public void setStreet(String street) {
        this.street = street;
    }


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
