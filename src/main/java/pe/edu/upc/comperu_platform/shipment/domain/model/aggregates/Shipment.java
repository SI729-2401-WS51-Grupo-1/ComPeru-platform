package pe.edu.upc.comperu_platform.shipment.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import pe.edu.upc.comperu_platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import pe.edu.upc.comperu_platform.shipment.domain.model.commands.CreateShipmentCommand;
import pe.edu.upc.comperu_platform.shipment.domain.model.valueobjects.CityAddress;
import pe.edu.upc.comperu_platform.shipment.domain.model.valueobjects.Person;

import java.util.Date;

@Getter
@Entity
public class Shipment extends AuditableAbstractAggregateRoot<Shipment> {

    @Embedded
    private Person name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "address_street")),
            @AttributeOverride(name = "number", column = @Column(name = "address_number")),
            @AttributeOverride(name = "city", column = @Column(name = "address_city")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "address_postal_code")),
            @AttributeOverride(name = "country", column = @Column(name = "address_country"))})
    private CityAddress address;

    @Column(nullable = false, length = 50)
    private String phoneNumber;

    @Column(nullable = false, length = 50)
    private String documentNumber;


    public Shipment(String firstName, String lastName, String street, String number, String city, String postalCode, String country, String phoneNumber, String documentNumber) {
        this.name = new Person(firstName, lastName);
        this.address = new CityAddress(street, number, city, postalCode, country);
        this.phoneNumber = phoneNumber;
        this.documentNumber = documentNumber;
    }

    public Shipment(CreateShipmentCommand command) {
        this.name = new Person(command.firstName(), command.lastName());
        this.address = new CityAddress(command.street(), command.number(), command.city(), command.postalCode(), command.country());
        this.phoneNumber = command.phoneNumber();
        this.documentNumber = command.documentNumber();
    }

    public Shipment() {
    }

    public void updateName(String firstName, String lastName) {
        this.name = new Person(firstName, lastName);
    }
    public void updateAddress(String street, String number, String city, String postalCode, String country) {
        this.address = new CityAddress(street, number, city, postalCode, country);
    }
    public void updatePhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void updateDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }



    public String getFullName() {
        return name.getFullName();
    }
    public String getCityAddress() {
        return address.getStreetAddress();
    }

}