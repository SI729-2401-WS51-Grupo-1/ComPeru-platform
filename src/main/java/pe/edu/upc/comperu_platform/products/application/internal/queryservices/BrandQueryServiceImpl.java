package pe.edu.upc.comperu_platform.products.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.comperu_platform.products.domain.model.entities.Brand;
import pe.edu.upc.comperu_platform.products.domain.model.queries.GetBrandByIdQuery;
import pe.edu.upc.comperu_platform.products.domain.services.BrandQueryService;
import pe.edu.upc.comperu_platform.products.infrastructure.persistence.jpa.repositories.BrandRepository;

import java.util.Optional;

@Service
public class BrandQueryServiceImpl implements BrandQueryService {

    private final BrandRepository brandRepository;

    public BrandQueryServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Optional<Brand> handle(GetBrandByIdQuery query) {
        return brandRepository.findById(query.brandId());
    }
}
