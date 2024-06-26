package pe.edu.upc.comperu_platform.shipping.domain.model.commands;
import pe.edu.upc.comperu_platform.shipping.domain.model.valueobjects.ShippingAddress;

import java.util.Date;

public record CreateShipmentCommand(
        Date shipmentDate,
        double shipmentCost,
        Long TrackingNumber,
        double packageWeight,
        ShippingAddress address
) {
}
