package pe.edu.upc.comperu_platform.products.interfaces.rest.transform;

import pe.edu.upc.comperu_platform.products.domain.model.aggregates.Product;
import pe.edu.upc.comperu_platform.products.domain.model.entities.ImageAsset;
import pe.edu.upc.comperu_platform.products.interfaces.rest.resources.BrandResource;
import pe.edu.upc.comperu_platform.products.interfaces.rest.resources.CategoryResource;
import pe.edu.upc.comperu_platform.products.interfaces.rest.resources.ProductResource;

import java.util.ArrayList;
import java.util.List;

public class ProductResourceFromEntityAssembler {

    public static ProductResource toResourceFromEntity (Product entity){

        BrandResource brandResource = new BrandResource(entity.getBrand().getId(),entity.getBrand().getName());
        CategoryResource categoryResource = new CategoryResource(entity.getCategory().getId(),entity.getCategory().getName());
        List<String> imageUrls = new ArrayList<>();

        for (ImageAsset imageAsset : entity.getGalleryAssets().getImages()) {
            imageUrls.add(imageAsset.getUrl());
        }

        return new ProductResource(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getModelNumber(),
                entity.getManufacturerNumber(),
                entity.getPrice().priceValue(),
                entity.getAvailability(),
                entity.getStock(),
                brandResource,
                categoryResource,
                entity.getUserId().userId(),
                entity.getRating().averageRating(),
                imageUrls
                );
    }



}
