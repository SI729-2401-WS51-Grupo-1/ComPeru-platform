package pe.edu.upc.comperu_platform.products.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.comperu_platform.products.domain.model.aggregates.Product;
import pe.edu.upc.comperu_platform.shared.domain.model.entities.User;

@Setter
@Getter
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Brand() {
    }

    public Brand(String name) {
        this.name = name;
    }

}
