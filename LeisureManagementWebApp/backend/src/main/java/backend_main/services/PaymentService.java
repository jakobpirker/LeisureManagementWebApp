package backend_main.services;

import backend_main.entities.Payment;
import backend_main.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService  extends AbstractService<Payment, Long, PaymentRepository> {

    public String getJsonStringWithForeignIds() {
        return (object_mapper_.valueToTree(new Payment())).toString();
    }
}
