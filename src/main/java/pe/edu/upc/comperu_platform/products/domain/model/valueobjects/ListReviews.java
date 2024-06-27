//package pe.edu.upc.comperu_platform.products.domain.model.valueobjects;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Embeddable;
//import jakarta.persistence.OneToMany;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Setter
//@Getter
//@Embeddable
//public class ListReviews {
//
//    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
//    private final List<ReviewId> reviews;
//
//    public ListReviews(){this.reviews = new ArrayList<>();}
//
//    public void addReview(Long reviewId){
//        this.reviews.add(new ReviewId(reviewId));
//    }
//
//    public void removeReview(Long id){
//        var reviewRemove = new ReviewId();
//        for(ReviewId review : reviews){
//            if(review.reviewId().equals(id)){
//                reviewRemove = new ReviewId(id);
//            }
//        }
//        if(reviewRemove.reviewId() != 0L){
//            reviews.remove(reviewRemove);
//        }
//    }
//    public boolean isEmpty(){return reviews.isEmpty();}
//}
