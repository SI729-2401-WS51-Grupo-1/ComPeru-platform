package pe.edu.upc.comperu_platform.products.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.comperu_platform.products.domain.model.aggregates.Product;

@Getter
@Setter
@Entity
public class ImageAsset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @NotNull
    private Product product;

    public ImageAsset(){
    }
    public ImageAsset( String url){
        this.url=url;
    }

}