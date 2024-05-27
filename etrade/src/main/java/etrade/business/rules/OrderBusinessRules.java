package etrade.business.rules;

import etrade.business.core.utilities.exceptions.BusinessException;
import etrade.dataAccess.abstracts.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class OrderBusinessRules {
    private OrderRepository orderRepository;

    public void checkIfDeliveryNumberExists(int deliveryNumber){

        var check= this.orderRepository.existsByOrderDeliveryNumber(deliveryNumber);
        if (check) {
            return;
        }
        throw new BusinessException("Order already exists");
    }
}
