package pe.edu.upc.comperu_platform.payment.domain.services;

import pe.edu.upc.comperu_platform.payment.domain.model.aggregates.Payment;
import pe.edu.upc.comperu_platform.payment.domain.model.queries.GetAllPaymentsQuery;

import java.util.List;
import java.util.Optional;

public interface PaymentQueryService {
    List<Payment> handle(GetAllPaymentsQuery query);
}
