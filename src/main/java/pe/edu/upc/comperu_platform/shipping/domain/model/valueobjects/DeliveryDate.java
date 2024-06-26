package pe.edu.upc.comperu_platform.shipping.domain.model.valueobjects;

import java.util.Date;

public record DeliveryDate(Date date) {
    public DeliveryDate() {
        this(new Date());
    }
}