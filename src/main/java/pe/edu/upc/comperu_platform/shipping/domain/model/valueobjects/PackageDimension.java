package pe.edu.upc.comperu_platform.shipping.domain.model.valueobjects;

public record PackageDimension(double height, double width, double depth) {
    public PackageDimension() {
        this(0.0, 0.0, 0.0);
    }
}