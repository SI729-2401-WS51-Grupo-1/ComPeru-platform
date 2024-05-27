package pe.edu.upc.comperu_platform.products.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public enum VerifiedStatus {
    //STATUS FOR ENTREPENEUR

    PENDING,
    VERIFIED,
    REJECTED,
    SUSPENDED
}
