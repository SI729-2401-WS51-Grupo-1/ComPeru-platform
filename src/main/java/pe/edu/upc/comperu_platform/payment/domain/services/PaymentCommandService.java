package pe.edu.upc.comperu_platform.payment.domain.services;

import pe.edu.upc.comperu_platform.payment.domain.model.aggregates.Payment;
import pe.edu.upc.comperu_platform.payment.domain.model.commands.CreatePaymentCommand;

import java.util.Optional;

public interface PaymentCommandService {
    Optional<Payment> handle(CreatePaymentCommand command);
}
