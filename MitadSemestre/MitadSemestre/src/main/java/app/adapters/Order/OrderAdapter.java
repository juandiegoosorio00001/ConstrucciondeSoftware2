package app.adapters.Order;

import java.util.List;

import org.springframework.stereotype.Service;

import app.domain.models.Order;
import app.ports.OrderPort;
@Service
public class OrderAdapter implements OrderPort {

	@Override
	public void saveOrder(Order order) {
		
	}

	@Override
	public Order findOrderById(long orderId) {
		return null;
	}

	@Override
	public List<Order> findOrdersByMascotId(long mascotId) {
		return null;
	}

	@Override
	public void updateOrder(Order order) {
		
	}

}
