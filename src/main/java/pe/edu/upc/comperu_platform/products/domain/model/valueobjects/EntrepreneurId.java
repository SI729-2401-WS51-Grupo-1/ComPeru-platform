package pe.edu.upc.comperu_platform.products.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record EntrepreneurId(Long entrepreneurId) {
    public EntrepreneurId {
        if (entrepreneurId < 0) {
            throw new IllegalArgumentException("Profile profileId cannot be negative");
        }
    }
    public EntrepreneurId() {
        this(0L);
    }

}
