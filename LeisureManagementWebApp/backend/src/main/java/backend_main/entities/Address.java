package backend_main.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue
    @Column
    @JsonIgnore
    private Long id;

    @Column
    private int postal_code;

    @Column
    private String city;

    @Column
    private String street;

    @Column
    private String add_description;

    @JsonProperty("Postleitzahl")
    public int getPostalCode() {
        return postal_code;
    }

    @JsonProperty("Postleitzahl")
    public void setPostalCode(int postal_code) {
        this.postal_code = postal_code;
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

    @JsonProperty("Beschreibung")
    public String getAdd_description() {
        return add_description;
    }

    @JsonProperty("Beschreibung")
    public void setAdd_description(String add_description) {
        this.add_description = add_description;
    }
}
