package pe.edu.upc.comperu_platform.orders.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import pe.edu.upc.comperu_platform.orders.domain.model.commands.CreateOrderCommand;
import pe.edu.upc.comperu_platform.orders.domain.model.valueobjects.*;
import pe.edu.upc.comperu_platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Getter
@Entity
public class Orders extends AuditableAbstractAggregateRoot<Orders> {

    @Getter
    @Embedded
    private UserId userId;

    private String orderTitle;

    @Embedded
    private ShippingAddress shippingAddress;

    private String deliveryMethod;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Embedded
    private final OrderDiscount orderDiscount;

    private Long totalOrder;

    public Orders() {
        this.orderTitle = Strings.EMPTY;
        this.deliveryMethod = Strings.EMPTY;
        this.totalOrder = 0L;
        this.orderDiscount = new OrderDiscount();
    }

    public Orders(UserId userId, String orderTitle,ShippingAddress shippingAddress, String deliveryMethod, Long totalOrder) {
        this();
        this.userId = userId;
        this.orderTitle = orderTitle;
        this.shippingAddress = shippingAddress;
        this.deliveryMethod = deliveryMethod;
        this.orderStatus = OrderStatus.PENDING;
        this.totalOrder = totalOrder;
    }

    public Orders(CreateOrderCommand command) {
        this();
        this.orderTitle =  command.orderTittle();
        this.deliveryMethod = command.deliveryMethod();
        this.totalOrder = command.totalOrder();
    }

    /**
     * Updates the Order information
     * return the update order
     */
    public Orders updateInformation(String orderTitle, String deliveryMethod, Long totalOrder) {
        this.orderTitle = orderTitle;
        this.deliveryMethod = deliveryMethod;
        this.totalOrder = totalOrder;
        return this;
    }


}
