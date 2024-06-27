package pe.edu.upc.comperu_platform.shipment.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Person (String firstName, String lastName) {
    public Person() {
        this(null, null);
    }

    public Person {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name cannot be null or blank");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be null or blank");
        }
    }
    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }
}
