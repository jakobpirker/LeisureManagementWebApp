package backend_main.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue
    @Column
    @JsonIgnore     // NOTE: setter also not called!! -> Important for @GeneratedValue
    private Long id;

    @Column
    private String surname;

    @Column
    private String forename;

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
}
