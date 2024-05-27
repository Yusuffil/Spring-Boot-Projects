package etrade.business.abstracts;


import etrade.business.requests.Order.CreateOrderRequest;
import etrade.business.requests.Order.UpdateOrderRequest;
import etrade.business.responses.Clients.CreateClientResponse;
import etrade.business.responses.Orders.CreateOrderResponse;
import etrade.business.responses.Orders.GetAllOrdersResponse;

import java.util.List;

public interface OrderService {
    List<GetAllOrdersResponse> getAll();

    CreateOrderResponse add(CreateOrderRequest createOrderRequest);

    void update(UpdateOrderRequest updateOrderRequest);

    void delete(int id);
}
