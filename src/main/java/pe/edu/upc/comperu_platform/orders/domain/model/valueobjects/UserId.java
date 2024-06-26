package pe.edu.upc.comperu_platform.orders.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Value object representing the user id.
 */

@Embeddable
public record UserId(Long userId) {

    public UserId {
        if (userId < 0){
            throw new IllegalArgumentException("User Id cannot be negative");
        }
    }

    public UserId() {this(0L);}
}
