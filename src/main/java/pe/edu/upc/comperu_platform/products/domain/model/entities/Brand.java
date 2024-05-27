package pe.edu.upc.comperu_platform.products.domain.model.entities;

import jakarta.persistence.*;
import pe.edu.upc.comperu_platform.products.domain.model.aggregates.Product;
import pe.edu.upc.comperu_platform.shared.domain.model.entities.User;

@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @OneToOne(mappedBy = "brand")
    private Product product;
}
