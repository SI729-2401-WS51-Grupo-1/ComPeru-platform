package pe.edu.upc.comperu_platform.products.domain.model.entities;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
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

    @NotNull
    private String url;


    @ManyToOne
    @JoinColumn(name = "product_id")
    @NotNull
    private Product product;


    public ImageAsset(){
        this.url= "";
    }
    public ImageAsset(Product product, String url){
        this.product = product;
        this.url=url;
    }

    @Override
    public String toString() {
        return "ImageAsset{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", product=" + product +
                '}';
    }
//    public void updateNextImage(ImageAsset nextImage){
//        this.nextImage = nextImage;
//    }

}