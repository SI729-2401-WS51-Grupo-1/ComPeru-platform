package pe.edu.upc.comperu_platform.products.interfaces.rest;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.comperu_platform.products.domain.model.queries.GetAllCategoriesQuery;
import pe.edu.upc.comperu_platform.products.domain.model.queries.GetCategoryByIdQuery;
import pe.edu.upc.comperu_platform.products.domain.services.CategoryCommandService;
import pe.edu.upc.comperu_platform.products.domain.services.CategoryQueryService;
import pe.edu.upc.comperu_platform.products.interfaces.rest.resources.CategoryResource;
import pe.edu.upc.comperu_platform.products.interfaces.rest.resources.CreateCategoryResource;
import pe.edu.upc.comperu_platform.products.interfaces.rest.transform.CategoryResourceFromEntityAssembler;
import pe.edu.upc.comperu_platform.products.interfaces.rest.transform.CreateCategoryCommandFromResourceAssembler;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/categories",produces = APPLICATION_JSON_VALUE)
@Tag(name = "Categories",description = "Category Management Endpoints")

public class CategoryController {

    private final CategoryCommandService categoryCommandService;

    private final CategoryQueryService categoryQueryService;


    public CategoryController(CategoryCommandService categoryCommandService, CategoryQueryService categoryQueryService) {
        this.categoryCommandService = categoryCommandService;
        this.categoryQueryService = categoryQueryService;
    }

    @PostMapping
    public ResponseEntity<CategoryResource> createCategory(@RequestBody CreateCategoryResource createCategoryResource){
        var createCategoryCommand = CreateCategoryCommandFromResourceAssembler.toCommandFromResource(createCategoryResource);
        var categoryId = categoryCommandService.handle(createCategoryCommand);
        if(categoryId == 0L){
            return  ResponseEntity.badRequest().build();
        }

        var getCategoryByIdQuery = new GetCategoryByIdQuery(categoryId);
        var category = categoryQueryService.handle(getCategoryByIdQuery);

        if(category.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var categoryResource = CategoryResourceFromEntityAssembler.toResourceFromEntity(category.get());
        return new ResponseEntity<>(categoryResource, HttpStatus.CREATED);
    }


    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryResource> getCategoryById(@PathVariable Long categoryId){
        var getCategoryByIdQuery = new GetCategoryByIdQuery(categoryId);
        var category = categoryQueryService.handle(getCategoryByIdQuery);
        if(category.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var categoryResource = CategoryResourceFromEntityAssembler.toResourceFromEntity(category.get());
        return ResponseEntity.ok(categoryResource);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResource>> getAllCategories(){
        var getAllCategoriesQuery = new GetAllCategoriesQuery();
        var categories = categoryQueryService.handle(getAllCategoriesQuery);
        var categoriesResources = categories.stream().map(CategoryResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(categoriesResources);
    }

}
