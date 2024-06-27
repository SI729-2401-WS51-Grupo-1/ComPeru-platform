package pe.edu.upc.comperu_platform.payment.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.comperu_platform.payment.domain.model.aggregates.Payment;
import pe.edu.upc.comperu_platform.payment.domain.model.commands.CreatePaymentCommand;
import pe.edu.upc.comperu_platform.payment.domain.services.PaymentCommandService;
import pe.edu.upc.comperu_platform.payment.infrastructure.persistence.jpa.repositories.PaymentRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentCommandServiceImpl implements PaymentCommandService {
    private final PaymentRepository paymentRepository;

    public PaymentCommandServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    /**
     * This method will handle the {@link CreatePaymentCommand} and will create the roles if not exists
     * @param command {@link CreatePaymentCommand}
     * @return Optional<Payment>
     * @see CreatePaymentCommand
     */
    @Override
    public Optional<Payment> handle(CreatePaymentCommand command) {
        if (paymentRepository.existsByTitularNameAndCardNumber(command.titularName(), command.cardNumber()) ||
            paymentRepository.existsByTitularNameAndCardNumberAndMethodPayments(command.titularName(), command.cardNumber(), command.methodPayments())){
            throw new IllegalArgumentException("Payment already exists");
        }

        var payment = new Payment(command.titularName(),
                command.cardNumber(),
                command.expirationDate(),
                command.cvv(),
                command.methodPayments(),
                command.amount());

        try {
            paymentRepository.save(payment);
        }catch (Exception e){
            throw  new IllegalArgumentException("Error while saving schedule" + e.getMessage());
        }
        return Optional.of(payment);
    }
}
