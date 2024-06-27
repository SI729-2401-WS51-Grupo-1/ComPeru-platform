package pe.edu.upc.comperu_platform.payment.interfaces.rest.resources;

import java.util.List;

public record PaymentResource(
        Long id,
        String titularName,
        String cardNumber,
        String expirationDate,
        String cvv,
        String methodPayments,
        Double amount) {}
