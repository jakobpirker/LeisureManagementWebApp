package backend_main.services;

import backend_main.entities.PaymentAccount;
import backend_main.repositories.PaymentAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentAccountService extends AbstractService<PaymentAccount, String, PaymentAccountRepository>{
    public String getJsonStringWithForeignIds() {
        return (object_mapper_.valueToTree(new PaymentAccount())).toString();
    }
}
