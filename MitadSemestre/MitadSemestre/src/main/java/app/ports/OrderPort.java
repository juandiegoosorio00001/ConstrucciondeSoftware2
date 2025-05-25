package app.ports;

import app.domain.models.Order;
import java.util.List;

public interface OrderPort {
    void saveOrder(Order order);
    Order findOrderById(Long orderId);
    List<Order> findAllOrders(); 
    List<Order> findOrdersByPetId(Long petId);
    List<Order> findOrdersByVeterinarianId(Long veterinarianId); 
    void updateOrder(Order order);
    void deleteOrder(Long orderId);
}