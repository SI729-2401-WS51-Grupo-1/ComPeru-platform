package pe.edu.upc.comperu_platform.products.domain.model.aggregates;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
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


//    @Embedded
//    private BrandId brandId;

//    @Column(nullable = false)
//    @Embedded
//    private CategoryId categoryId;

    @ManyToOne
    @JoinColumn(name = "entrepreneur_id")
    @NotNull
    private Entrepreneur entrepreneur;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ImageAsset> images;


//    @Column(nullable = false)
//    @Embedded
//    EntrepreneurId entrepreneurId;


    public Product(){
        this.price=new Price();
        this.rating= new ProductRatingsMetricSet();
        this.totalReviews=new ProductReviewsMetricSet();
    }

//    public Product(Long brand_id,Long category_id,Long entrepreneur_id){
//        this();
////        this.brandId = new BrandId(brand_id);
////        this.categoryId = new CategoryId(category_id);
////        this.entrepreneurId= new EntrepreneurId(entrepreneur_id);
//    }

    public Product(Brand brand , Category category, Entrepreneur entrepreneur ){
        this();
        this.brand=brand;
        this.category=category;
        this.entrepreneur=entrepreneur;
//        this.brandId=brand_id;
//        this.categoryId=category_id;
//        this.entrepreneurId=entrepreneur_id;
    }


}
