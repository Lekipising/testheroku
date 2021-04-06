// Authors: Liplan Lekipising and catherine Muthoni
package com.autoparts.autoparts.services;
import java.util.List;
import java.util.Optional;
import com.autoparts.autoparts.classes.Orders;
import com.autoparts.autoparts.repository.OrdersRepoI;
import com.autoparts.autoparts.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    OrdersRepoI ordersRepoI;

    // create order
    public void addOrder(Orders orders){
        ordersRepository.save(orders);
    }

    // view an order
    public Orders getOneOrder(Long orderId){
        return ordersRepository.findById(orderId).get();
    }


    public List<Orders> getAllOrders(){
        return (List<Orders>) ordersRepository.findAll();
    }

    public Orders updateOrder(Long orderId){
        return ordersRepository.findById(orderId).get();
    }

    // delete order
    public void delOrder(Long orderId){
        boolean exists = ordersRepository.existsById(orderId);
        if (exists){
            ordersRepository.deleteById(orderId);
        }
        else {
            throw new IllegalStateException("ID doesn't exist"); 
        }
    }
    
}
