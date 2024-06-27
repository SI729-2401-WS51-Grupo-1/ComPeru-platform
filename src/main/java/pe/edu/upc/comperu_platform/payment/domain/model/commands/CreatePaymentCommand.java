package pe.edu.upc.comperu_platform.payment.domain.model.commands;

import java.util.List;

public record CreatePaymentCommand(
        String titularName,
        String cardNumber,
        String expirationDate,
        String cvv,
        String methodPayments,
        Double amount) {
}
