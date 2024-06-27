package pe.edu.upc.comperu_platform.shipment.domain.model.commands;

import java.util.Date;

public record CreateShipmentCommand(
        String firstName,
        String lastName,
        String street,
        String number,
        String city,
        String postalCode,
        String country,
        String phoneNumber,
        String documentNumber
) {
}
