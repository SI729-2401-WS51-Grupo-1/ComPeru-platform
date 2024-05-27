package pe.edu.upc.comperu_platform.products.domain.model.entities;

import jakarta.persistence.*;
import pe.edu.upc.comperu_platform.products.domain.model.aggregates.Product;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @OneToOne(mappedBy = "category")
    private Product product;
}
