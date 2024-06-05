package pe.edu.upc.comperu_platform.products.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.comperu_platform.products.domain.model.commands.CreateBrandCommand;
import pe.edu.upc.comperu_platform.products.domain.model.entities.Brand;
import pe.edu.upc.comperu_platform.products.domain.services.BrandCommandService;
import pe.edu.upc.comperu_platform.products.infrastructure.persistence.jpa.repositories.BrandRepository;

@Service
public class BrandCommandServiceImpl implements BrandCommandService {

    private final BrandRepository brandRepository;

    public BrandCommandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Long handle(CreateBrandCommand command) {
        Brand brand = new Brand(command.name());
        brandRepository.save(brand);
        return brand.getId();
    }
}
