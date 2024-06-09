package pe.edu.upc.comperu_platform.shared.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @NotNull
    private City city;

    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
    private List<Address> address;

    public District(){
    }
    public District(String name){
        this.name=name;
    }
}
