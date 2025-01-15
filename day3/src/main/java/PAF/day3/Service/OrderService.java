package PAF.day3.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PAF.day3.Models.Orders;
import PAF.day3.Repository.OrdersRepository;

@Service
public class OrderService {
    @Autowired
    private OrdersRepository ordersRepository;

    public Orders getOrderDetailsWithDiscount(int orderId){
        return ordersRepository.getOrderDetailsWithDiscount(orderId);

    }
}
