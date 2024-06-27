package pe.edu.upc.comperu_platform.payment.interfaces.rest.transform;

import pe.edu.upc.comperu_platform.payment.domain.model.commands.CreatePaymentCommand;
import pe.edu.upc.comperu_platform.payment.interfaces.rest.resources.CreatePaymentResource;

import java.util.ArrayList;

public class CreatePaymentCommandFromResourceAssembler {
    public static CreatePaymentCommand toCommandFromResource(CreatePaymentResource createPaymentResource) {
        return new CreatePaymentCommand(
                createPaymentResource.titularName(),
                createPaymentResource.cardNumber(),
                createPaymentResource.expirationDate(),
                createPaymentResource.cvv(),
                createPaymentResource.methodPayments(),
                createPaymentResource.amount()
        );
    }
}
