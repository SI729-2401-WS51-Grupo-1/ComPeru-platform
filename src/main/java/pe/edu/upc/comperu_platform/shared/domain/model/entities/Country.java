package pe.edu.upc.comperu_platform.shared.domain.model.entities;

import jakarta.persistence.*;
import pe.edu.upc.comperu_platform.products.domain.model.entities.ImageAsset;

import java.util.List;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<City> cities;

    public Country(){}
    public Country(String name){
        this.name=name;
    }

}
