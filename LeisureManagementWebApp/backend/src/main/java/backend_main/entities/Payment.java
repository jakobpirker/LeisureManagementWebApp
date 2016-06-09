package backend_main.entities;

import backend_main.entities.embedded_ids.PersonId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;

@Entity
public class Payment {

    @Id
    @GeneratedValue
    private Long id;

    @JsonProperty("Betrag")
    private Double amount;

    @JsonProperty("Zweck")
    private String purpose;

    @ManyToOne
    @JsonIgnore
    private PaymentAccount paymentaccount;

    @ManyToOne
    @JsonIgnore
    private Person person;

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

    @JsonIgnore
    public PaymentAccount getPaymentAccount() { return this.paymentaccount; }
    @JsonIgnore
    public void setPaymentAccount(PaymentAccount paymentaccount) { this.paymentaccount  = paymentaccount; }

    @JsonIgnore
    public Person getPerson() { return this.person; }
    @JsonIgnore
    public void setPerson(Person person) { this.person  = person; }

    //---------------------------------------------------------------
    // serial- and deserializing specific content

    @Transient
    @JsonIgnore
    private String payment_account_id;

    @JsonProperty("Depot")
    public String getPaymentAccountJson() {
        if(this.paymentaccount != null)
        {
            return this.paymentaccount.getId();
        }
        else
        {
            return null;
        }
    }

    @JsonProperty("Depot")
    public void setPaymentAccountId(String id_string) {
        this.payment_account_id = id_string;
    }

    @JsonIgnore
    public String getPaymentAccountId(){
        return this.payment_account_id;
    }

    @JsonIgnore
    @Transient
    ObjectMapper mapper = new ObjectMapper();

    @Transient
    @JsonIgnore
    private PersonId person_id;

    @JsonProperty("Person")
    public PersonId getPersonJson() {
        if(this.person != null)
        {
            return this.person.getId();
        }
        else
        {
            return null;
        }
    }

    @JsonProperty("Person")
    public void setPersonId(String id_string) throws Exception {
        if(id_string != null) {
            this.person_id = mapper.readValue(id_string, PersonId.class);
        }
        else {
            this.person_id = null;
        }
    }

    @JsonIgnore
    public PersonId getPersonId(){
        return this.person_id;
    }
}
