package backend_main.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Payment {

    @Id
    @GeneratedValue
    private Long id;

    @JsonProperty("Betrag")
    private Double amount;

    @JsonProperty("Zweck")
    private String purpose;

    public Payment() {
        this.id = 0L;
        this.amount = 0D;
        this.purpose = "";
    }

    // explicit declaration to avoid conflict with @GeneratedValue
    @JsonProperty("ID")
    public Long getId() {
        return id;
    }

    @JsonProperty("ID")
    public void setId(Long id) {
        // do nothing -> auto-generated
    }
}
