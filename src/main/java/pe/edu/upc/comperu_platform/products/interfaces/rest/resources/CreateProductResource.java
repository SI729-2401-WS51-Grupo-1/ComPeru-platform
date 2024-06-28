package pe.edu.upc.comperu_platform.products.interfaces.rest.resources;


import java.util.List;

public record CreateProductResource(String name,
                                    String description,
                                    String modelNumber,
                                    String manufacturerNumber,
                                    Double price,
                                    Boolean availability,
                                    Integer stock,
                                    Long brandId,
                                    Long categoryId,
                                    Long userId,
                                    List<String> imageUrls) {
}
