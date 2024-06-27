package pe.edu.upc.comperu_platform.shipment.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record CityAddress(
        String street,
        String number,
        String city,
        String postalCode,
        String country
) {
    public CityAddress() {
        this(null, null, null, null, null);
    }

    public CityAddress(String street, String city, String postalCode, String country) {
        this(street, null, city, postalCode, country);
    }

    public String getStreetAddress() {
        return String.format("%s %s, %s, %s, %s", street, number, city, postalCode, country);
    }

    public CityAddress {
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