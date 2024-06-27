package pe.edu.upc.comperu_platform.shipment.interfaces.rest.resources;

public record ShipmentResource(
        Long id,
        String fullName,
        String cityAddress,
        String phoneNumber,
        String documentNumber
) {
}
