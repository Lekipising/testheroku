// Authors: Liplan Lekipising and catherine Muthoni
package com.autoparts.autoparts.controllers;
import java.util.List;
import com.autoparts.autoparts.classes.OrderProduct;
import com.autoparts.autoparts.repository.OrderProductRepository;
import com.autoparts.autoparts.services.OrderProductService;
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
@RequestMapping(path = "/orderproduct")
public class OrderProductController {

    @Autowired
    private OrderProductService orderProductService;

    @Autowired
    OrderProductRepository orderProductRepository;

    // GET - one product
    @GetMapping(path = "{OrderProductId}")
    public OrderProduct getOneOrderProduct(@PathVariable("OrderProductId") Long OrderProductId){
        return orderProductService.getOneOrderProduct(OrderProductId);
    }

    // get all rderProduct
    @GetMapping
    public List<OrderProduct> getAllOrderProduct(){
        return orderProductService.getAllOrderProduct();
    }
    

    // POST - add product
    @PostMapping
    public void addOrder(@RequestBody OrderProduct orderProduct){
        orderProductService.addOrderProduct(orderProduct);
    }

    // update product details

    // DELETE - delete a product
    @DeleteMapping(path = "{OrderProductId}")
    public void delOrderProduct(@PathVariable("OrderProductId") Long OrderProductId){
        orderProductService.delOrderProduct(OrderProductId);
    }

}
 
