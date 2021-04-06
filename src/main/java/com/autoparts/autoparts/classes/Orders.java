// Authors: Liplan Lekipising and catherine Muthoni
package com.autoparts.autoparts.classes;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.time.LocalTime;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderId")
	private Long orderId;

    @Column(name = "orderTime", nullable = false)
    LocalTime orderTime;

    @Column(name = "orderDate", nullable = false)
    Date orderDate;

    @Column(name = "egift")
    private boolean egift = false;

    @OneToMany(mappedBy = "orders")
    private List<OrderProduct> orderProduct;

    @OneToOne
    @JoinColumn(name="email", nullable = false)
    private Account account;

    @OneToOne
    @JoinColumn(name="shippingId", nullable = false)
    private Shipping shipping;


    // Orderid, productid, customerid, orderdate

    public Orders(){}

    public Orders(Account account, List<OrderProduct> orderProduct){
        this.orderDate = new Date(Calendar.getInstance().getTimeInMillis());
        this.orderTime = LocalTime.now();
        this.orderProduct = orderProduct;
        this.account = account;
    }


    public Long getOrderId() {
        return orderId;
    }


    public void setProductId(List<OrderProduct> orderProduct) {
        this.orderProduct = orderProduct;
    }

    public void setAccount(Account account){
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public List<OrderProduct> getProduct() {
        return orderProduct;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public LocalTime getOrderTime() {
        return orderTime;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderTime(LocalTime orderTime) {
        this.orderTime = orderTime;
    }

    public void setEgift(boolean egift) {
        this.egift = egift;
    }

    public boolean getEgift(){
        return egift;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public Optional<Orders> map(Object object) {
        return null;
    }

}
