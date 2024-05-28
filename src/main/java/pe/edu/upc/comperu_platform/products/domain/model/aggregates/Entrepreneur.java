package pe.edu.upc.comperu_platform.products.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import pe.edu.upc.comperu_platform.products.domain.model.valueobjects.Inventory;
import pe.edu.upc.comperu_platform.shared.domain.model.entities.User;

import java.util.List;

@Entity
public class Entrepreneur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private final Inventory inventory;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    public Entrepreneur(){
        this.inventory= new Inventory();
    }

}
