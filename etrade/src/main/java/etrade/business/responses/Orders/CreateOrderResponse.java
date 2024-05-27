package etrade.business.responses.Orders;

import etrade.Entities.concretes.Client;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderResponse {

    private int productId;

    private String address;

    private Client client;

    private int orderDeliveryNumber;
}
