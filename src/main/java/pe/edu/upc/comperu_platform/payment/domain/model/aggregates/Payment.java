package pe.edu.upc.comperu_platform.payment.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import pe.edu.upc.comperu_platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
public class Payment extends AuditableAbstractAggregateRoot<Payment> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false,length = 50)
    private String titularName;

    @Column(nullable = false,length = 50)
    private String cardNumber;

    @Column(nullable = false,length = 50)
    private String expirationDate;

    @Column(nullable = false,length = 50)
    private String cvv;

    @Column(nullable = false,length = 50)
    private String methodPayments;

    @Column(nullable = false,length = 50)
    private Double amount;


    public Payment(String titularName, String cardNumber, String expirationDate, String cvv, String methodPayments, Double amount) {
        this.titularName = titularName;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.methodPayments = methodPayments;
        this.amount = amount;
    }


}
