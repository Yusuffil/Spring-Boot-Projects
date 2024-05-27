package etrade.webApi.controllers;

import etrade.business.abstracts.ClientService;
import etrade.business.abstracts.OrderService;
import etrade.business.requests.Order.CreateOrderRequest;
import etrade.business.requests.Order.UpdateOrderRequest;
import etrade.business.responses.Clients.CreateClientResponse;
import etrade.business.responses.Clients.GetAllClientsResponse;
import etrade.business.responses.Orders.CreateOrderResponse;
import etrade.business.responses.Orders.GetAllOrdersResponse;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
@Data
public class OrdersController {

    private OrderService orderService;

    @GetMapping()
    public List<GetAllOrdersResponse> getAll(){
        return orderService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateOrderResponse add(@RequestBody @Valid CreateOrderRequest createOrderRequest){

        return orderService.add(createOrderRequest);
    }

    @PutMapping
    public void a(@RequestBody @Valid UpdateOrderRequest updateOrderRequest){

        orderService.update(updateOrderRequest);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        orderService.delete(id);
    }
}
