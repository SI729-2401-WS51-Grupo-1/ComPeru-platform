package pe.edu.upc.comperu_platform.payment.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.comperu_platform.payment.domain.model.aggregates.Payment;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    boolean existsByTitularNameAndCardNumber(String titularName, String cardNumber);
    boolean existsByTitularNameAndCardNumberAndMethodPayments(String titularName, String cardNumber, String methodPayments);
}
