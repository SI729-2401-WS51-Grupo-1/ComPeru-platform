package pe.edu.upc.comperu_platform.shared.domain.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User extends AuditableModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;


    //falta el Address

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Entrepreneur> entrepreneurs;
//


    public User(){};

    public User(String username, String password, String email){
        this.username=username;
        this.password=password;
        this.email=email;
    }


}
