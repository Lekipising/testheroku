// Authors: Liplan Lekipising and catherine Muthoni
package com.autoparts.autoparts.controllers;
import java.util.List;
import com.autoparts.autoparts.classes.Orders;
import com.autoparts.autoparts.repository.OrdersRepository;
import com.autoparts.autoparts.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



// order - developer - products list
// product - skill - name, description, price, productID, type, count

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    OrdersRepository ordersRepository;

    // GET - one product
    @GetMapping(path = "{orderId}")
    public Orders getOneOrder(@PathVariable("orderId") Long orderId){
        return ordersService.getOneOrder(orderId);
    }

    // get all orders
    @GetMapping
    public List<Orders> getAllOrders(){
        return ordersService.getAllOrders();
    }
    

    // POST - add product
    @PostMapping
    public void addOrder(@RequestBody Orders orders){
        ordersService.addOrder(orders);
    }


    // DELETE - delete a product
    @DeleteMapping(path = "{orderId}")
    public void delOrder(@PathVariable("orderId") Long orderId){
        ordersService.delOrder(orderId);
    }

}
 
