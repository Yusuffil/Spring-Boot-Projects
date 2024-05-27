package etrade.dataAccess.abstracts;

import etrade.Entities.concretes.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    boolean existsByOrderDeliveryNumber(int id);

}
