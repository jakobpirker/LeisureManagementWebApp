package backend_main.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class PaymentAccount {

    @Id
    @JsonProperty("Depot")
    private String id;

    @JsonProperty("Betrag")
    private Integer currentamount;

    @OneToMany(mappedBy = "paymentaccount", cascade= CascadeType.ALL)
    @JsonIgnore
    private List<Payment> payments;

    public PaymentAccount() {
        this.id = "";
        this.currentamount = 0;
    }

    public String getId() { return this.id; }
}
