package pe.edu.upc.comperu_platform.products.domain.model.queries;

public record GetAllProductsBySearchAndEntrepreneurIdQuery(String searchTerm, Long entrepreneurId) {
}
