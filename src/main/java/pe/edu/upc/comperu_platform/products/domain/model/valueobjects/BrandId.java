package pe.edu.upc.comperu_platform.products.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record BrandId(Long brandId) {
    //VALIDATION BRAND ID
    public BrandId {
        if(brandId<0){
            throw new IllegalArgumentException("Brand brandId cannot be negative");
        }
    }

    public BrandId(){
        this(0L);
    }

}
