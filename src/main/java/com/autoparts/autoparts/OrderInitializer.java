// Authors: Liplan Lekipising and catherine Muthoni
package com.autoparts.autoparts;

import java.util.ArrayList;

import com.autoparts.autoparts.classes.Account;
import com.autoparts.autoparts.classes.OrderProduct;
import com.autoparts.autoparts.classes.Orders;
import com.autoparts.autoparts.classes.Products;
import com.autoparts.autoparts.classes.Shipping;
import com.autoparts.autoparts.repository.AccountRepository;
import com.autoparts.autoparts.repository.OrderProductRepository;
import com.autoparts.autoparts.repository.OrdersRepository;
import com.autoparts.autoparts.repository.ProductsRepository;
import com.autoparts.autoparts.repository.ShippingRepository;
import com.autoparts.autoparts.services.ProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OrderInitializer implements CommandLineRunner{

    @Override
    public void run(String... args) throws Exception {
        
        ProductsRepository productsRepository;
        OrderProductRepository orderProductRepository;
        OrdersRepository ordersRepository;
        AccountRepository accountRepository;
        ShippingRepository shippingRepository;


        Products products = new Products();
        Products products2 = new Products();
        products.setCount(3);
        products.setName("Engine");
        products.setPrice(2131);
        // save database
        




        products2.setCount(2);
        products2.setName("Brake");
        products2.setPrice(2131);

        Account account = new Account();
        account.setPhoneNumber("myemail@gmail.com");
        account.setFirstName("firstName");
        account.setSecondName("secondName");
        account.setPassword("password");
        account.setPhoneNumber("phoneNumber");


        OrderProduct orderProduct = new OrderProduct();
        OrderProduct orderProduct1 = new OrderProduct();

        ArrayList<OrderProduct> myOrders = new ArrayList<OrderProduct>();
        myOrders.add(orderProduct1);
        myOrders.add(orderProduct);

        Orders order = new Orders();

        Shipping shipping = new Shipping();
        shipping.setAddress("address");
        shipping.setEmail(account);
        shipping.setOrders(order);
        shipping.setShipmentStage("shipmentStage");
        shipping.setShippingDays(5);


        order.setAccount(account);
        order.setProductId(myOrders);
        order.setShipping(shipping);
        

        

    }

}
