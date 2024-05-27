package pe.edu.upc.comperu_platform.products.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Price(double priceValue) {
//VALIDATOR PRICE
    public Price {
        if(priceValue<0){
            throw new IllegalArgumentException("Price  cannot be negative");
        }
    }

    public Price(){
        this(0.0);
    }
}
