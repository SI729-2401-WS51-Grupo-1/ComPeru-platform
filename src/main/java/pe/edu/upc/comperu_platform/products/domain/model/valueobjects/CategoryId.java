package pe.edu.upc.comperu_platform.products.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record CategoryId(Long categoryId) {
// VALIDATION CATEGORY ID
    public CategoryId {
        if(categoryId<0){
            throw new IllegalArgumentException("Category categoryId cannot be negative");
        }
    }

    public CategoryId(){
        this(0L);
    }
}
