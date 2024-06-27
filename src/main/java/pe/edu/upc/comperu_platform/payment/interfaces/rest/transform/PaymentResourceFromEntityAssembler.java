package pe.edu.upc.comperu_platform.payment.interfaces.rest.transform;


import pe.edu.upc.comperu_platform.payment.domain.model.aggregates.Payment;
import pe.edu.upc.comperu_platform.payment.interfaces.rest.resources.PaymentResource;

public class PaymentResourceFromEntityAssembler {
    public static PaymentResource toResourceFromEntity(Payment payment) {
        return new PaymentResource(
                payment.getId(),
                payment.getTitularName(),
                payment.getCardNumber(),
                payment.getExpirationDate(),
                payment.getCvv(),
                payment.getMethodPayments(),
                payment.getAmount()
        );
    }
}
