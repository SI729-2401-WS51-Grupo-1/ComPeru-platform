package pe.edu.upc.comperu_platform.orders.domain.model.valueobjects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;
import pe.edu.upc.comperu_platform.orders.domain.model.entities.OrderDiscountItem;


import java.util.ArrayList;
import java.util.List;

public class OrderDiscount {

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<OrderDiscountItem> orderDiscountItems;

    public OrderDiscount() {this.orderDiscountItems = new ArrayList<>();}

    public OrderDiscountItem getOrderDiscountItem() {
        if (orderDiscountItems != null && !orderDiscountItems.isEmpty()) {
            return orderDiscountItems.get(0);
        }
        return null;
    }

    public void setOrderDiscountItem(OrderDiscountItem orderDiscountItem) {
        if(orderDiscountItem == null) {
            orderDiscountItems = new ArrayList<>();
        }else {
            orderDiscountItems.clear();
        }
        orderDiscountItems.add(orderDiscountItem);
    }
}
