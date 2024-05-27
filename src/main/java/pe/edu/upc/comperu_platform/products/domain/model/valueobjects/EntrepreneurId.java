package pe.edu.upc.comperu_platform.products.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record EntrepreneurId(Long entrepreneurId) {
    //VALIDATION ENTREPRENEUR ID
    public EntrepreneurId {
        if(entrepreneurId<0){
            throw new IllegalArgumentException("Entrepreneur entrepreneurId cannot be negative");
        }
    }

    public EntrepreneurId(){
        this(0L);
    }
}
