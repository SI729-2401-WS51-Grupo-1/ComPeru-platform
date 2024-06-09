package pe.edu.upc.comperu_platform.orders.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class DeliveryMethod {
    private String method;

    public DeliveryMethod(String method) {
        this.method = method;
    }

    // Constructor sin argumentos requerido por JPA
    public DeliveryMethod() {}

    public String getMethod() {
        return method;
    }

    // Sobrescribir equals() y hashCode() para que la clase pueda ser usada como value object correctamente
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryMethod that = (DeliveryMethod) o;
        return Objects.equals(method, that.method);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method);
    }
}
