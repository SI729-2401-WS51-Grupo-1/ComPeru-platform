package pe.edu.upc.comperu_platform.products.interfaces.acl;


import org.springframework.stereotype.Service;
import pe.edu.upc.comperu_platform.products.domain.model.commands.UpdateRatingProductCommand;
import pe.edu.upc.comperu_platform.products.domain.model.queries.GetProductByIdQuery;
import pe.edu.upc.comperu_platform.products.domain.services.ProductCommandService;
import pe.edu.upc.comperu_platform.products.domain.services.ProductQueryService;

@Service
public class ProductContextFacade {

    private final ProductCommandService productCommandService;
    private final ProductQueryService productQueryService;


    public ProductContextFacade(ProductCommandService productCommandService, ProductQueryService productQueryService) {
        this.productCommandService = productCommandService;
        this.productQueryService = productQueryService;
    }


    public Long updateRatingInProduct(Long productId,double newRating){
        var updateRatingCommand = new UpdateRatingProductCommand(productId,newRating);
        var productOpt = productCommandService.handle(updateRatingCommand);
        System.out.println(productOpt.get().getRating());
        return productOpt.get().getId();

    }
}
