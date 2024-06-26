package pe.edu.upc.comperu_platform.orders.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import pe.edu.upc.comperu_platform.orders.domain.model.aggregates.Orders;
import pe.edu.upc.comperu_platform.shared.domain.model.entities.AuditableModel;

@Getter
@Entity
public class OrderDiscountItem extends AuditableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    @NotNull
    private Orders orders;

    @NotNull
    private Long productId;

    public OrderDiscountItem(Orders orders, Long productId) {
        this.orders = orders;
        this.productId = productId;
    }

    public OrderDiscountItem() {
        this.productId = null;
    }
}
