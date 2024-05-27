package etrade.business.concretes;


import etrade.Entities.concretes.Order;
import etrade.business.abstracts.OrderService;
import etrade.business.core.utilities.mappers.ModelMapperService;
import etrade.business.requests.Order.CreateOrderRequest;
import etrade.business.requests.Order.UpdateOrderRequest;
import etrade.business.responses.Orders.CreateOrderResponse;
import etrade.business.responses.Orders.GetAllOrdersResponse;
import etrade.business.rules.OrderBusinessRules;
import etrade.dataAccess.abstracts.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class OrderManager implements OrderService {

    private OrderRepository orderRepository;
    private ModelMapperService modelMapperService;
    private OrderBusinessRules orderBusinessRules;

    @Override
    public List<GetAllOrdersResponse> getAll() {
        List<Order> orders = this.orderRepository.findAll();
        List<GetAllOrdersResponse> orderResponses = orders.stream().
                map(order -> this.modelMapperService.forResponse().
                        map(order, GetAllOrdersResponse.class)).collect(Collectors.toList());
        return orderResponses;
    }

    public CreateOrderResponse add(CreateOrderRequest createOrderRequest){
        orderBusinessRules.checkIfDeliveryNumberExists(createOrderRequest.getOrderDeliveryNumber());
        Order order = this.modelMapperService.forRequest().map(createOrderRequest, Order.class);
        this.orderRepository.save(order);
        CreateOrderResponse orderResponse = new CreateOrderResponse();
        orderResponse.setOrderDeliveryNumber(createOrderRequest.getOrderDeliveryNumber());

        return orderResponse;
    }

    @Override
    public void update(UpdateOrderRequest updateorderRequest) {
        var order = modelMapperService.forRequest().map(updateorderRequest,Order.class);
        orderRepository.save(order);
    }

    @Override
    public void delete(int id) {
        orderRepository.deleteById(id);
    }

}
