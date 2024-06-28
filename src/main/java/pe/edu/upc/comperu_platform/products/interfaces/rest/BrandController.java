package pe.edu.upc.comperu_platform.products.interfaces.rest;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.comperu_platform.products.domain.model.queries.GetAllBrandsQuery;
import pe.edu.upc.comperu_platform.products.domain.model.queries.GetBrandByIdQuery;
import pe.edu.upc.comperu_platform.products.domain.services.BrandCommandService;
import pe.edu.upc.comperu_platform.products.domain.services.BrandQueryService;
import pe.edu.upc.comperu_platform.products.interfaces.rest.resources.BrandResource;
import pe.edu.upc.comperu_platform.products.interfaces.rest.resources.CreateBrandResource;
import pe.edu.upc.comperu_platform.products.interfaces.rest.transform.BrandResourceFromEntityAssembler;
import pe.edu.upc.comperu_platform.products.interfaces.rest.transform.CreateBrandCommandFromResourceAssembler;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/brands",produces = APPLICATION_JSON_VALUE)
@Tag(name = "Brands",description = "Brand Management Endpoints")

public class BrandController {

    private final BrandCommandService brandCommandService;

    private final BrandQueryService brandQueryService;


    public BrandController(BrandCommandService brandCommandService, BrandQueryService brandQueryService) {
        this.brandCommandService = brandCommandService;
        this.brandQueryService = brandQueryService;
    }

    @PostMapping
    public ResponseEntity<BrandResource> createBrand(@RequestBody CreateBrandResource createBrandResource){
        var createBrandCommand = CreateBrandCommandFromResourceAssembler.toCommandFromResource(createBrandResource);
        var brandId = brandCommandService.handle(createBrandCommand);
        if(brandId == 0L){
            return ResponseEntity.badRequest().build();
        }

        var getBrandByIdQuery = new GetBrandByIdQuery(brandId);
        var brand = brandQueryService.handle(getBrandByIdQuery);

        if(brand.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var brandResource= BrandResourceFromEntityAssembler.toResourceFromEntity(brand.get());
        return new ResponseEntity<>(brandResource, HttpStatus.CREATED);

    }


    @GetMapping("/{brandId}")
    public ResponseEntity<BrandResource> getBrandById(@PathVariable Long brandId){
        var getBrandByIdQuery = new GetBrandByIdQuery(brandId);
        var brand = brandQueryService.handle(getBrandByIdQuery);
        if(brand.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var brandResource= BrandResourceFromEntityAssembler.toResourceFromEntity(brand.get());
        return ResponseEntity.ok(brandResource);
    }

    @GetMapping
    public ResponseEntity<List<BrandResource>> getAllBrands(){
        var getAllBrandsQuery = new GetAllBrandsQuery();
        var brands = brandQueryService.handle(getAllBrandsQuery);
        var brandsResources = brands.stream().map(BrandResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(brandsResources);
    }


}
