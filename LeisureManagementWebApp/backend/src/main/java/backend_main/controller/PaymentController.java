package backend_main.controller;

import backend_main.entities.Payment;
import backend_main.services.PaymentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController extends AbstractController<Payment, PaymentService>{
}
