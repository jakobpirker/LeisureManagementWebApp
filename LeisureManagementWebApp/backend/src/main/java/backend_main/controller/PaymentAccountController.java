package backend_main.controller;

import backend_main.entities.PaymentAccount;
import backend_main.services.PaymentAccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paymentaccount")
public class PaymentAccountController  extends AbstractController<PaymentAccount, PaymentAccountService> {
}
