package pe.edu.upc.comperu_platform.shared.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @NotNull
    private Country country;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<District> districts;

    public City(){}
    public City(String name){
        this.name=name;
    }
}
