package pe.edu.upc.comperu_platform.shared.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    private String address;

    @ManyToOne
    @JoinColumn(name = "district_id")
    @NotNull
    private District district;
    @OneToOne(mappedBy = "address")
    private User user;

    public Address(){}

    public Address(String address){
        this.address=address;
    }

}
