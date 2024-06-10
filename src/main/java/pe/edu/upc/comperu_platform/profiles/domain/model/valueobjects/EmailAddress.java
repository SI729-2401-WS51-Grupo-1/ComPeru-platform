package pe.edu.upc.comperu_platform.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;

@Embeddable
public record EmailAddress(@Email String address) {
  public EmailAddress() {
    this(null);
  }
}
