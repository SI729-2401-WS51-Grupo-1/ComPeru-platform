package pe.edu.upc.comperu_platform.products.domain.model.valueobjects;


public record ReviewId(Long reviewId) {
    public ReviewId{
        if(reviewId <0 ){
            throw new IllegalArgumentException("Review Id cannot be negative");
        }
    }

    public ReviewId(){
        this(0L);
    }

}
