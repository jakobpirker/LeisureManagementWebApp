package backend_main.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PaymentAccount {

    @Id
    @JsonProperty("Depot")
    private String id;

    @JsonProperty("Betrag")
    private Integer currentamount;

    public PaymentAccount() {
        this.id = "";
        this.currentamount = 0;
    }

    public String getId() { return this.id; }
}
