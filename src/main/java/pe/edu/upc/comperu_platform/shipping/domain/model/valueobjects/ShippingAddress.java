package pe.edu.upc.comperu_platform.shipping.domain.model.valueobjects;


public record ShippingAddress(
    String address,
    String city,
    String postalCode,
    String country
) {

}