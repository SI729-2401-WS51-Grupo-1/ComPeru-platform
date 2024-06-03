package pe.edu.upc.comperu_platform.products.application.internal.queryservices;


import org.springframework.stereotype.Service;
import pe.edu.upc.comperu_platform.products.domain.model.aggregates.Product;
import pe.edu.upc.comperu_platform.products.domain.model.entities.ImageAsset;
import pe.edu.upc.comperu_platform.products.domain.model.queries.*;
import pe.edu.upc.comperu_platform.products.domain.model.valueobjects.EntrepreneurId;
import pe.edu.upc.comperu_platform.products.domain.model.valueobjects.ReviewId;
import pe.edu.upc.comperu_platform.products.domain.services.ProductQueryService;
import pe.edu.upc.comperu_platform.products.infrastructure.persistence.jpa.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductQueryServiceImpl implements ProductQueryService {

    private final ProductRepository productRepository;

    public ProductQueryServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public Optional<Product> handle(GetProductByIdQuery query) {

        return productRepository.findById(query.productId());

    }

    @Override
    public List<Product> handle(GetAllProductsByEntrepreneurIdQuery query) {

        return productRepository.findByEntrepreneurId(query.entrepreneurId());
    }

    @Override
    public Optional<Product> handle(GetProductByProductIdAndEntrepreneurIdQuery query) {

        return productRepository.findByIdAndEntrepreneurId(query.productId(),query.entrepreneurId());

    }

    @Override
    public List<ImageAsset> handle(GetAllImagesByProductIdQuery query) {
        return productRepository.findById(query.productId())
                .map(product -> product.getGalleryAssets().getImages())
                .orElse(new ArrayList<>());
    }

    @Override
    public List<Product> handle(GetAllProductsByCategoryIdQuery query) {

        return null;
    }

    @Override
    public List<Product> handle(GetAllProductsByBrandIdQuery query) {
        return null;
    }

    @Override
    public List<Product> handle(GetAllProductsBySearchQuery query) {
        return null;
    }

    @Override
    public List<ReviewId> handle(GetAllReviewsByProductIdQuery query) {
        return null;
    }
}
