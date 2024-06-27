package pe.edu.upc.comperu_platform.shipment.interfaces.rest.resources;

public record CreateShipmentResource(
        String firstName,
        String lastName,
        String email,
        String street,
        String number,
        String city,
        String postalCode,
        String country,
        String phoneNumber,
        String documentNumber
) {
}
