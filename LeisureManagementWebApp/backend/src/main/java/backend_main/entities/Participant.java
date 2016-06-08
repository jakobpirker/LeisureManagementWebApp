package backend_main.entities;

import backend_main.entities.embedded_ids.PersonId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import javax.persistence.*;

@Entity
//@JsonPropertyOrder({ "id", "Telefonnummer", "Adresse" })
public class Participant {

    @EmbeddedId
    @JsonUnwrapped
    private PersonId id;

    public Participant(){
        this.id = new PersonId();
    }

//    private Integer openpayment;

//    public Integer getOpenpayment() {
//        return openpayment;
//    }
//
//    public void setOpenpayment(Integer openpayment) {
//        this.openpayment = openpayment;
//    }

    public PersonId getId() {
        return id;
    }

    public void setId(PersonId id) {
        this.id = id;
    }
}
