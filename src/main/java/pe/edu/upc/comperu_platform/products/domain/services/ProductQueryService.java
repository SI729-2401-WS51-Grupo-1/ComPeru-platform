package pe.edu.upc.comperu_platform.products.domain.services;

import pe.edu.upc.comperu_platform.products.domain.model.aggregates.Order;
import pe.edu.upc.comperu_platform.products.domain.model.aggregates.Product;
import pe.edu.upc.comperu_platform.products.domain.model.aggregates.Review;
import pe.edu.upc.comperu_platform.products.domain.model.entities.ImageAsset;
import pe.edu.upc.comperu_platform.products.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface ProductQueryService {
    List<Product> handle(GetAllProductsByEntrepreneurIdQuery query);
    Optional<Product> handle(GetProductByProductIdAndEntrepreneurIdQuery query);
    List<ImageAsset> handle(GetAllImagesByProductIdQuery query);

    List<Product> handle(GetProductsByCategoryIdAndEntrepreneurIdQuery query);
    List<Product> handle(GetProductsByBrandIdAndEntrepreneurIdQuery query);
    List<Product> handle(GetProductsBySearchAndEntrepreneurIdQuery query);
    List<Review> handle(GetAllReviewsByProductIdQuery query);
    Long handle(GetTotalReviewsByProductIdQuery query);
    Long handle(GetTotalReviewsByEntrepreneurIdQuery query);

    List<Order> handle(GetAllOrdersByProductIdQuery query);
    List<Order> handle(GetAllOrdersByEntrepreneurIdQuery query);

    Optional<Order> handle(GetOrderDetailsByOrderIdQuery query);
}















