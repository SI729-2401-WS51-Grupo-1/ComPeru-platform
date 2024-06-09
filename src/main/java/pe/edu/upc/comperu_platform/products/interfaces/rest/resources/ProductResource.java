package pe.edu.upc.comperu_platform.products.interfaces.rest.resources;

import java.util.List;

public record ProductResource(Long id,
                              String name,
                              String description,
                              String modelNumber,
                              String manufacturerNumber,
                              Double price,
                              Boolean availability,
                              Integer stock,
                              BrandResource brand,
                              CategoryResource category,
                              Long entrepreneurId,
                              List<String> imageUrls

                              ) {
}
