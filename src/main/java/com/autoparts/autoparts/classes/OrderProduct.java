// Authors: Liplan Lekipising and catherine Muthoni
package com.autoparts.autoparts.classes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderProduct")
public class OrderProduct {
    
    @Id
    @Column(name = "orderProductId")
    private long orderProductId;
    
    @ManyToOne
    @JoinColumn(name="ordersId", nullable = false)
    private Orders orders;

    @ManyToOne
    @JoinColumn(name="productId", nullable = false)
    private Products products;

    Date dateCreated;
    

    private int quantity;

    private long price;

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Orders getOrders() {
        return orders;
    }

    public long getPrice() {
        return price;
    }

    public Products getProducts() {
        return products;
    }

    public int getQuantity() {
        return quantity;
    }

    public long getOrderProductId() {
        return orderProductId;
    }


}
