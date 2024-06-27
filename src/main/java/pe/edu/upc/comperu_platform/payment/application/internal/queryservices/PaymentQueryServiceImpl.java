package pe.edu.upc.comperu_platform.payment.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.comperu_platform.payment.domain.model.aggregates.Payment;
import pe.edu.upc.comperu_platform.payment.domain.model.queries.GetAllPaymentsQuery;
import pe.edu.upc.comperu_platform.payment.domain.model.queries.GetPaymentByIdQuery;
import pe.edu.upc.comperu_platform.payment.domain.services.PaymentQueryService;
import pe.edu.upc.comperu_platform.payment.infrastructure.persistence.jpa.repositories.PaymentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentQueryServiceImpl implements PaymentQueryService {
    private final PaymentRepository paymentRepository;

    public PaymentQueryServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }


    @Override
    public List<Payment> handle(GetAllPaymentsQuery query) {
        return paymentRepository.findAll();
    }
}
