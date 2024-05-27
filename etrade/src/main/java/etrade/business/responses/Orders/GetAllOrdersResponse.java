package etrade.business.responses.Orders;

import etrade.Entities.concretes.Client;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllOrdersResponse {

    private int id;

    private String adress;

    private Client client;
}
