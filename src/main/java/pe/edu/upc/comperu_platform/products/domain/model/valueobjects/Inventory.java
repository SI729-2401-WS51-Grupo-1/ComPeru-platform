//package pe.edu.upc.comperu_platform.products.domain.model.valueobjects;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Embeddable;
//import jakarta.persistence.OneToMany;
//import pe.edu.upc.comperu_platform.products.domain.model.aggregates.Entrepreneur;
//import pe.edu.upc.comperu_platform.products.domain.model.aggregates.Product;
//import pe.edu.upc.comperu_platform.products.domain.model.entities.Brand;
//import pe.edu.upc.comperu_platform.products.domain.model.entities.Category;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Embeddable
//public class Inventory {
//
//    @OneToMany(mappedBy = "entrepreneur", cascade = CascadeType.ALL)
//    private List<Product> products;
//
//    public Inventory(){
//        this.products = new ArrayList<>();
//    }
//
//    public void addProduct(Brand _brand, Category _category, Entrepreneur _entrepreneur, Product _nextProduct){
//        Product new_product =  new Product(_brand, _category,_entrepreneur,_nextProduct);
//        products.add(new_product);
//    }
//
//    public void addProduct(Brand _brand, Category _category, Entrepreneur _entrepreneur){
//        Product new_product =  new Product(_brand, _category,_entrepreneur,null);
//        Product originalLastProduct = null;
//        if(!products.isEmpty()){
//            originalLastProduct = getLastItemInProducts();
//        }
//        products.add(new_product);
//
//        if(originalLastProduct !=null) originalLastProduct.updateNextProduct(new_product);
//
//    }
//
//    private Product getProductWithId(Long productId){
//        return products.stream().filter(productItem -> productItem.getId().equals(productId)).findFirst().orElse(null);
//    }
//
//    public Product getLastItemInProducts(){
//        return products.stream().filter(item -> item.getNextProduct() == null).findFirst().orElse(null);
//    }
//
//
//    public boolean isEmpty(){
//        return products.isEmpty();
//    }
//
//}
