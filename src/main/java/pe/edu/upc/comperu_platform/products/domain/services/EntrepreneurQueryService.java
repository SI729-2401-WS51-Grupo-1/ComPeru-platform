package pe.edu.upc.comperu_platform.products.domain.services;

import pe.edu.upc.comperu_platform.products.domain.model.aggregates.Entrepreneur;
import pe.edu.upc.comperu_platform.products.domain.model.entities.Brand;
import pe.edu.upc.comperu_platform.products.domain.model.entities.Category;
import pe.edu.upc.comperu_platform.products.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface EntrepreneurQueryService {
    Optional<Entrepreneur> handle(GetEntrepreneurByIdQuery query);
    String handle(GetVerifiedStatusByEntrepreneurIdQuery query);
    Long handle(GetTotalProductsByEntrepreneurIdQuery query);
    Long handle(GetAverageRatingByEntrepreneurIdQuery query);
    List<Category> handle(GetAllCategoriesByEntrepreneurIdQuery query);
    List<Brand> handle(GetAllBrandsByEntrepreneurIdQuery query);

}





