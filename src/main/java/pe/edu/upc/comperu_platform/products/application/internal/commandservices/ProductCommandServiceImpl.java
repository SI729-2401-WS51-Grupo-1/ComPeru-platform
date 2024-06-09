package pe.edu.upc.comperu_platform.products.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.comperu_platform.products.domain.model.aggregates.Product;
import pe.edu.upc.comperu_platform.products.domain.model.commands.*;
import pe.edu.upc.comperu_platform.products.domain.model.entities.Brand;
import pe.edu.upc.comperu_platform.products.domain.model.entities.Category;
import pe.edu.upc.comperu_platform.products.domain.model.entities.ImageAsset;
import pe.edu.upc.comperu_platform.products.domain.services.ProductCommandService;
import pe.edu.upc.comperu_platform.products.infrastructure.persistence.jpa.repositories.BrandRepository;
import pe.edu.upc.comperu_platform.products.infrastructure.persistence.jpa.repositories.CategoryRepository;
import pe.edu.upc.comperu_platform.products.infrastructure.persistence.jpa.repositories.ProductRepository;

@Service

public class ProductCommandServiceImpl implements ProductCommandService {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;

    public ProductCommandServiceImpl(ProductRepository productRepository, BrandRepository brandRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Long handle(CreateProductCommand command) {
        Brand brand = brandRepository.findById(command.brandId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid brand ID"));
        Category category = categoryRepository.findById(command.categoryId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid category ID"));

        Product product = new Product(command, brand, category);

        productRepository.save(product);
        return product.getId();
    }

    @Override
    public void handle(UpdateProductCommand command) {

        var productOptional = productRepository.findById(command.productId());
        if(productOptional.isEmpty()){
            throw new IllegalArgumentException("Product doesn't exist");
        }
            var product = productOptional.get();
        var brand = brandRepository.findById(command.brandId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid brand ID"));
        var category = categoryRepository.findById(command.categoryId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid category ID"));

        try {
            product.UpdateInformation(command.name(), command.description(), command.modelNumber(),
                    command.manufacturerNumber(), command.price(), command.availability(),
                    command.stock(), brand, category, command.entrepreneurId(), command.imageUrls());

            productRepository.save(product);

        }catch (Exception e){
            throw new IllegalArgumentException("Error while updating product: " + e.getMessage());
        }
    }

    @Override
    public void handle(DeleteProductCommand command) {
        if(!productRepository.existsById(command.productId())) {
            throw new IllegalArgumentException("Product does not exist");
        }

        try {
            productRepository.deleteById(command.productId());
        }catch (Exception e){
            throw new IllegalArgumentException("Error while deleting product: " + e.getMessage());
        }

    }

    @Override
    public void handle(AddImageToProductCommand command) {
        if(!productRepository.existsById(command.productId())){
            try {
                productRepository.findById(command.productId()).map( product -> {
                    product.AddImageToGallery(command.imageUrl());
                    productRepository.save(product);
                    System.out.println("Imag added to gallery");
                    return product;
                });
            }catch (Exception e){
                throw new IllegalArgumentException("Error while adding image to gallery: " + e.getMessage());

            }
        }
    }

    @Override
    public void handle(RemoveImageFromProductCommand command) {
        var productOpt = productRepository.findById(command.productId());
        if (productOpt.isEmpty()) {
            throw new IllegalArgumentException("Product doesn't exist");
        }

        var product = productOpt.get();
        product.RemoveImageToGallery(command.imageId());
        productRepository.save(product);
    }

    @Override
    public void handle(UpdateProductAvailabilityCommand command) {
        var productOpt = productRepository.findById(command.productId());
        if(productOpt.isEmpty()){
            throw new IllegalArgumentException("Product doesn't exist");
        }
        try {
            var product = productOpt.get();
            product.UpdateAvailability(command.availability());
            productRepository.save(product);
        }catch (Exception e){
            throw new IllegalArgumentException("Error while updating product : " + e.getMessage());
        }

    }

    @Override
    public void handle(UpdateProductStockCommand command) {
        var productOpt = productRepository.findById(command.productId());
        if(productOpt.isEmpty()){
            throw new IllegalArgumentException("Product doesn't exist");
        }
        try {
            var product = productOpt.get();
            product.UpdateStock(command.stock());
            productRepository.save(product);
        }catch (Exception e){
            throw new IllegalArgumentException("Error while updating product : " + e.getMessage());
        }
    }
}
