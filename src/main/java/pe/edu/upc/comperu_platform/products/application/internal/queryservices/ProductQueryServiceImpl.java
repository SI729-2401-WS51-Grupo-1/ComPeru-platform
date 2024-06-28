package pe.edu.upc.comperu_platform.products.application.internal.queryservices;


import org.springframework.stereotype.Service;
import pe.edu.upc.comperu_platform.products.domain.model.aggregates.Product;
import pe.edu.upc.comperu_platform.products.domain.model.entities.ImageAsset;
import pe.edu.upc.comperu_platform.products.domain.model.queries.*;
import pe.edu.upc.comperu_platform.products.domain.model.valueobjects.UserId;
import pe.edu.upc.comperu_platform.products.domain.services.ProductQueryService;
import pe.edu.upc.comperu_platform.products.infrastructure.persistence.jpa.repositories.CategoryRepository;
import pe.edu.upc.comperu_platform.products.infrastructure.persistence.jpa.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductQueryServiceImpl implements ProductQueryService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductQueryServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Optional<Product> handle(GetProductByIdQuery query) {

        return productRepository.findById(query.productId());

    }

    @Override
    public List<Product> handle(GetAllProductsByEntrepreneurIdQuery query) {

        return productRepository.findByUserId(new UserId(query.entrepreneurId()));
    }

    @Override
    public Optional<Product> handle(GetProductByProductIdAndEntrepreneurIdQuery query) {

        return productRepository.findByIdAndUserId(query.productId(),query.entrepreneurId());

    }

    @Override
    public List<ImageAsset> handle(GetAllImagesByProductIdQuery query) {
        return productRepository.findById(query.productId())
                .map(product -> product.getGalleryAssets().getImages())
                .orElse(new ArrayList<>());
    }

    @Override
    public List<Product> handle(GetAllProductsByCategoryIdQuery query) {

        return productRepository.findByCategoryId(query.categoryId());

    }

    @Override
    public List<Product> handle(GetAllProductsByBrandIdQuery query) {


        return productRepository.findByBrandId(query.brandId());
    }

    @Override
    public List<Product> handle(GetAllProductsBySearchQuery query) {

        return productRepository.findByNameContainingIgnoreCase(query.searchTerm());
    }

    @Override
    public List<Product> handle(GetAllProductsQuery query) {
        return productRepository.findAll();
    }

//    @Override
//    public List<ReviewId> handle(GetAllReviewsByProductIdQuery query) {
//        return productRepository.findById(query.productId()).map(product -> product.getReviews().getReviews()).orElse(new ArrayList<>());
//    }
}
