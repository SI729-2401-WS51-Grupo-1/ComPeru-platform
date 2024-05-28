package pe.edu.upc.comperu_platform.products.domain.model.aggregates;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import pe.edu.upc.comperu_platform.products.domain.model.entities.Brand;
import pe.edu.upc.comperu_platform.products.domain.model.entities.Category;
import pe.edu.upc.comperu_platform.products.domain.model.entities.ImageAsset;
import pe.edu.upc.comperu_platform.products.domain.model.valueobjects.*;

import java.util.Date;
import java.util.List;

@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Product extends AbstractAggregateRoot<Product> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;


    private String modelNumber;

    @Column(nullable = false)
    private String manufacturerNumber;

    @Column(nullable = false)
    @Embedded
    private Price price;

    @Column(nullable = false)
    private Boolean availability;

    @Column(nullable = false)
    private Integer stock;

    @Embedded
    private ProductRatingsMetricSet rating;

   @Embedded
   private ProductReviewsMetricSet totalReviews;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "entrepreneur_id")
    @NotNull
    private Entrepreneur entrepreneur;

    @Embedded
    private final GalleryAssets galleryAssets;


    @ManyToOne
    @JoinColumn(name= "next_product_id")
    private Product nextProduct;




    public void updateNextProduct(Product nextProduct){
        this.nextProduct=nextProduct;
    }

    public Product(){
        this.price=new Price();
        this.rating= new ProductRatingsMetricSet();
        this.totalReviews=new ProductReviewsMetricSet();
        this.nextProduct=null;
        this.galleryAssets = new GalleryAssets();

    }


    public Product(Brand brand , Category category, Entrepreneur entrepreneur, Product nextProduct ){
        this();
        this.brand=brand;
        this.category=category;
        this.entrepreneur=entrepreneur;
        this.nextProduct= nextProduct;
    }

    public Product(String name,
                   String description,
                   String modelNumber,
                   String manufacturerNumber,
                   Price price,
                   Boolean availability,
                   Integer stock,
                   ProductRatingsMetricSet rating,
                   ProductReviewsMetricSet totalReviews,
                   Brand brand,
                   Category category,
                   Entrepreneur entrepreneur, GalleryAssets galleryAssets
    ){
        this.name=name;
        this.description=description;
        this.modelNumber=modelNumber;
        this.manufacturerNumber=manufacturerNumber;
        this.price = price;
        this.availability=availability;
        this.stock=stock;
        this.rating=rating;
        this.totalReviews=totalReviews;
        this.brand=brand;
        this.category=category;
        this.entrepreneur=entrepreneur;
        this.galleryAssets = galleryAssets;
    }



}
