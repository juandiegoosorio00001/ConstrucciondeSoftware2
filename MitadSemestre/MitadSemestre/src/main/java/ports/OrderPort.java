package ports;

import java.util.List;

import app.domain.models.Order;

public interface OrderPort {
    
    void saveOrder(Order order);
    
    Order findOrderById(long orderId);
    
    List<Order> findOrdersByMascotId(long mascotId);
    void updateOrder(Order order);
}