package backend_main.services;

import backend_main.entities.Payment;
import backend_main.entities.PaymentAccount;
import backend_main.entities.Person;
import backend_main.repositories.PaymentAccountRepository;
import backend_main.repositories.PaymentRepository;
import backend_main.repositories.PersonRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class PaymentService  extends AbstractService<Payment, Long, PaymentRepository> {

    @Autowired
    private PaymentAccountRepository pa_repository_;

    @Autowired
    private PersonRepository person_repository_;

    @Override
    public Payment save(Payment save_payment){

        // try to insert the valid address-object from the DB by it's id (from JSON)
        if(save_payment.getPaymentAccount() == null && save_payment.getPaymentAccountId() != null)
        {
            save_payment.setPaymentAccount(pa_repository_.findOne(save_payment.getPaymentAccountId()));
        }

        if(save_payment.getPerson() == null && save_payment.getPersonId() != null)
        {
            save_payment.setPerson(person_repository_.findOne(save_payment.getPersonId()));
        }

        return this.base_repository_.save(save_payment);
    }

    public String getJsonStringWithForeignIds() {

        JsonNode person = object_mapper_.valueToTree(new Payment());
        JsonNode payment_account_ids = object_mapper_.createArrayNode();
        JsonNode person_ids = object_mapper_.createArrayNode();

        Iterable<PaymentAccount> accomodations = pa_repository_.findAll();
        Iterable<Person> persons = person_repository_.findAll();

        for(Iterator<PaymentAccount> i = accomodations.iterator(); i.hasNext(); ) {
            ((ArrayNode) payment_account_ids).add(object_mapper_.valueToTree(i.next().getId()));
        }

        for(Iterator<Person> i = persons.iterator(); i.hasNext(); ) {
            ((ArrayNode) person_ids).add(object_mapper_.valueToTree(i.next().getId()));
        }

        ((ObjectNode) person).put("Depot", payment_account_ids);
        ((ObjectNode) person).put("Person", person_ids);

        return person.toString();
    }}
