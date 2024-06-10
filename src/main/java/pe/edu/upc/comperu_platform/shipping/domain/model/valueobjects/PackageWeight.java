package pe.edu.upc.comperu_platform.shipping.domain.model.valueobjects;

public record PackageWeight(double weight) {
    public PackageWeight() {
        this(0.0);
    }
}
