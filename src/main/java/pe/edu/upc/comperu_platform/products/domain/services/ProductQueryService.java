package pe.edu.upc.comperu_platform.products.domain.services;

import pe.edu.upc.comperu_platform.products.domain.model.aggregates.Product;
import pe.edu.upc.comperu_platform.products.domain.model.entities.ImageAsset;
import pe.edu.upc.comperu_platform.products.domain.model.queries.*;
import pe.edu.upc.comperu_platform.products.domain.model.valueobjects.ReviewId;

import java.util.List;
import java.util.Optional;

public interface ProductQueryService {

    Optional<Product> handle(GetProductByIdQuery query);
    List<Product> handle(GetAllProductsByEntrepreneurIdQuery query);
    Optional<Product> handle(GetProductByProductIdAndEntrepreneurIdQuery query);
    List<ImageAsset> handle(GetAllImagesByProductIdQuery query);
    List<Product> handle(GetAllProductsByCategoryIdQuery query);
    List<Product> handle(GetAllProductsByBrandIdQuery query);
    List<Product> handle(GetAllProductsBySearchQuery query);
    List<ReviewId> handle(GetAllReviewsByProductIdQuery query);

}















