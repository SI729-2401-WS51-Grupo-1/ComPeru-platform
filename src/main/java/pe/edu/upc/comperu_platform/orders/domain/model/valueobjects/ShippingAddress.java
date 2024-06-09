package pe.edu.upc.comperu_platform.orders.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ShippingAddress(
        String street,
        String number,
        String city,
        String postalCode,
        String country
) {
    public ShippingAddress() {
        this(null, null, null, null, null);
    }

    public ShippingAddress(String street, String city, String postalCode, String country) {
        this(street, null, city, postalCode, country);
    }

    public String getShippingAddress() {
        return String.format("%s %s, %s, %s, %s", street, number, city, postalCode, country);
    }

    public ShippingAddress {
        if (street == null || street.isBlank()) {
            throw new IllegalArgumentException("Street must not be null or blank");
        }
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("City must not be null or blank");
        }
        if (postalCode == null || postalCode.isBlank()) {
            throw new IllegalArgumentException("Postal code must not be null or blank");
        }
        if (country == null || country.isBlank()) {
            throw new IllegalArgumentException("Country must not be null or blank");
        }
    }
}
