package pe.edu.upc.comperu_platform.shipping.domain.model.valueobjects;

public record ShippingProvider(String name, ShippingMethod method) {
   /* public static ShippingProvider createWithStandardMethod() {
        return new ShippingProvider("Standard Provider", ShippingMethod.STANDARD);
    }

    public static ShippingProvider createWithExpressMethod() {
        return new ShippingProvider("Express Provider", ShippingMethod.EXPRESS);
    }

    public static ShippingProvider createWithOvernightMethod() {
        return new ShippingProvider("Overnight Provider", ShippingMethod.OVERNIGHT);
    }*/
}