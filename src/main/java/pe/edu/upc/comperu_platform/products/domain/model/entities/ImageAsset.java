package pe.edu.upc.comperu_platform.products.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import pe.edu.upc.comperu_platform.products.domain.model.aggregates.Product;

@Entity
public class ImageAsset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String url;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @NotNull
    private Product product;

    public ImageAsset(){

    }
    public ImageAsset(String name, String url){
        this.name=name;
        this.url=url;
    }

}