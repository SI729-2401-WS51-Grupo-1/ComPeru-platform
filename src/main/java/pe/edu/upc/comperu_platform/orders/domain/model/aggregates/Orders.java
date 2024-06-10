package pe.edu.upc.comperu_platform.orders.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import pe.edu.upc.comperu_platform.orders.domain.model.valueobjects.*;
import pe.edu.upc.comperu_platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Getter
@Entity
public class Orders extends AuditableAbstractAggregateRoot<Orders> {

    @Embedded
    private UserId userId;

    @Embedded
    private ShippingAddress shippingAddress;

    @Embedded
    private DeliveryMethod deliveryMethod;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Embedded
    private final OrderDiscount orderDiscount;

    @Embedded
    private TotalOrder totalOrder;

    public Orders() {
        this.orderDiscount = new OrderDiscount();
    }

    public Orders(UserId userId, ShippingAddress shippingAddress, DeliveryMethod deliveryMethod) {
        this();
        this.userId = userId;
        this.shippingAddress = shippingAddress;
        this.deliveryMethod = deliveryMethod;
        this.orderStatus = OrderStatus.PENDING;

        //this.totalOrder = new TotalOrder(BigDecimal.ZERO, BigDecimal.ZERO);
    }

}
