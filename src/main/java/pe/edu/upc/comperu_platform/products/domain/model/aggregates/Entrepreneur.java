package pe.edu.upc.comperu_platform.products.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import pe.edu.upc.comperu_platform.shared.domain.model.entities.User;

import java.util.List;

@Entity
public class Entrepreneur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "entrepreneur", cascade = CascadeType.ALL)
    private List< Product> products;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    public Entrepreneur(){}

}
