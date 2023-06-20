package com.hakkinen.desafio1.services;

import com.hakkinen.desafio1.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double total(Order order){
        double discountInPercent = (order.getDiscount() * 1/100);
        double totalValueDiscount = (order.getBasic() * discountInPercent);

        return order.getBasic() - totalValueDiscount + shippingService.shipment(order);
    }
}
