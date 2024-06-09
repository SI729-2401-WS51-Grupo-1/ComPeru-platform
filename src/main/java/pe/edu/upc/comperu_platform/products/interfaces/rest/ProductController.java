package pe.edu.upc.comperu_platform.products.interfaces.rest;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.comperu_platform.products.domain.model.queries.GetProductByIdQuery;
import pe.edu.upc.comperu_platform.products.domain.services.ProductCommandService;
import pe.edu.upc.comperu_platform.products.domain.services.ProductQueryService;
import pe.edu.upc.comperu_platform.products.interfaces.rest.resources.CreateProductResource;
import pe.edu.upc.comperu_platform.products.interfaces.rest.resources.ProductResource;
import pe.edu.upc.comperu_platform.products.interfaces.rest.resources.UpdateStockProductResource;
import pe.edu.upc.comperu_platform.products.interfaces.rest.transform.CreateProductCommandFromResourceAssembler;
import pe.edu.upc.comperu_platform.products.interfaces.rest.transform.ProductResourceFromEntityAssembler;
import pe.edu.upc.comperu_platform.products.interfaces.rest.transform.UpdateProductCommandFromResourceAssembler;
import pe.edu.upc.comperu_platform.products.interfaces.rest.transform.UpdateProductStockCommandFromResourceAssembler;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/products",produces = APPLICATION_JSON_VALUE)
@Tag(name = "Products",description = "Product Management Endpoints")
public class ProductController {

    private final ProductCommandService productCommandService;
    private final ProductQueryService productQueryService;

    public ProductController(ProductCommandService productCommandService, ProductQueryService productQueryService){
        this.productCommandService = productCommandService;
        this.productQueryService=productQueryService;
    }


    @PostMapping
    public ResponseEntity<ProductResource> createProduct(@RequestBody CreateProductResource createProductResource){
        var createProductCommand = CreateProductCommandFromResourceAssembler.toCommandFromResource(createProductResource);
        var productId = productCommandService.handle(createProductCommand);
        if(productId == 0L){
            return ResponseEntity.badRequest().build();
        }
        var getProductByIdQuery = new GetProductByIdQuery(productId);
        var product = productQueryService.handle(getProductByIdQuery);

        if (product.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var productResource = ProductResourceFromEntityAssembler.toResourceFromEntity(product.get());
        return new ResponseEntity<>(productResource, HttpStatus.CREATED);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResource> getProductById(@PathVariable Long productId){
        var getProductByIdQuery = new GetProductByIdQuery(productId);
        var product= productQueryService.handle(getProductByIdQuery);
        if(product.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var productResource = ProductResourceFromEntityAssembler.toResourceFromEntity(product.get());
        return ResponseEntity.ok(productResource);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductResource> updateProduct(@PathVariable Long productId,@RequestBody CreateProductResource createProductResource){
        var updateProductCommand = UpdateProductCommandFromResourceAssembler.toCommandFromResource(productId,createProductResource);
        var updateProduct = productCommandService.handle(updateProductCommand);
        if(updateProduct.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var productResource = ProductResourceFromEntityAssembler.toResourceFromEntity(updateProduct.get());
        return ResponseEntity.ok(productResource);
    }

    @PutMapping("/{productId}/stock")
    public ResponseEntity<ProductResource> updateStockProduct(@PathVariable Long productId, @RequestBody UpdateStockProductResource updateStockProductResource) {
        var updateStockProductCommand = UpdateProductStockCommandFromResourceAssembler.ToCommandFromResource(productId, updateStockProductResource);
        var updateProduct = productCommandService.handle(updateStockProductCommand);
        if (updateProduct.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var productResource = ProductResourceFromEntityAssembler.toResourceFromEntity(updateProduct.get());
        return ResponseEntity.ok(productResource);
    }


}
