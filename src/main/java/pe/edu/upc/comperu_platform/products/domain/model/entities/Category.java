package pe.edu.upc.comperu_platform.products.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.comperu_platform.products.domain.model.aggregates.Product;

import java.util.List;

@Setter
@Getter
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
    public Category() {
    }
    public Category(String name) {
        this.name = name;
    }

}