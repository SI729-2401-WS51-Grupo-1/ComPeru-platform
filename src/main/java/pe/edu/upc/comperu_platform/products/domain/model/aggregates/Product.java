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
import pe.edu.upc.comperu_platform.products.domain.model.commands.CreateProductCommand;
import pe.edu.upc.comperu_platform.products.domain.model.entities.Brand;
import pe.edu.upc.comperu_platform.products.domain.model.entities.Category;
import pe.edu.upc.comperu_platform.products.domain.model.entities.ImageAsset;
import pe.edu.upc.comperu_platform.products.domain.model.valueobjects.*;
import pe.edu.upc.comperu_platform.products.infrastructure.persistence.jpa.repositories.BrandRepository;

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

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Embedded
    private final GalleryAssets galleryAssets;

    @Embedded
    private ListReviews reviews;

    @Embedded
    private EntrepreneurId entrepreneurId;

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
        this.reviews = new ListReviews();

    }


    public Product(Brand brand , Category category, Product nextProduct,EntrepreneurId entrepreneurId ){
        this();
        this.brand=brand;
        this.category=category;
        this.nextProduct= nextProduct;
        this.entrepreneurId = entrepreneurId;
    }

    public Product(String name,
                   String description,
                   String modelNumber,
                   String manufacturerNumber,
                   Double price,
                   Boolean availability,
                   Integer stock,
                   Brand brand,
                   Category category,
                   Long entrepreneurId
                                                 ) {
        this();
        this.name = name;
        this.description = description;
        this.modelNumber = modelNumber;
        this.manufacturerNumber = manufacturerNumber;
        this.price = new Price(price);
        this.availability = availability;
        this.stock = stock;
        this.brand = brand;
        this.category = category;
        this.entrepreneurId = new EntrepreneurId(entrepreneurId);

    }

    public Product(CreateProductCommand command, Brand brand, Category category) {
        this();
        this.name = command.name();
        this.description = command.description();
        this.modelNumber = command.modelNumber();
        this.manufacturerNumber = command.manufacturerNumber();
        this.price = new Price(command.price());
        this.availability = command.availability();
        this.stock = command.stock();
        this.brand = brand;
        this.category = category;
        this.entrepreneurId = new EntrepreneurId(command.entrepreneurId());

        // Añadir las imágenes a la galería
        command.imageUrls().forEach(url -> this.galleryAssets.getImages().add(new ImageAsset(url)));
    }

    public void UpdateInformation(String name, String description,
                                  String modelNumber,
                                  String manufacturerNumber,
                                  Double price, Boolean availability,
                                  Integer stock,Brand brand,
                                  Category category,Long entrepreneurId,
                                  List<String>imageUrls){

        this.name = name;
        this.description = description;
        this.modelNumber = modelNumber;
        this.manufacturerNumber = manufacturerNumber;
        this.price = new Price(price);
        this.availability = availability;
        this.stock = stock;
        this.brand = brand;
        this.category = category;
        this.entrepreneurId = new EntrepreneurId(entrepreneurId);
        imageUrls.forEach(url -> this.galleryAssets.getImages().add(new ImageAsset(url)));

    }

    public void AddImageToGallery(String url){
        this.galleryAssets.AddAsset(url);
    }

    public void RemoveImageToGallery(Long Id){
        this.galleryAssets.RemoveAsset(Id);
    }
    public void UpdateStock(Integer stock){
        this.stock = stock;
    }
    public void UpdateAvailability(Boolean availability){
        this.availability = availability;
    }
}
