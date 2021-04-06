// Authors: Liplan Lekipising and catherine Muthoni
package com.autoparts.autoparts.classes;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "products")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productId")
	private Long productId;

	@OneToMany(mappedBy = "products")
    private List<OrderProduct> orderProduct;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "img_path", nullable = false)
	private String imgpath;

	// private String description;
	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "price", nullable = false)
	private double price;

	@Column(name = "count", nullable = false)
	private int count;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdDate", nullable = false)
	private Date createdDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updatedDate", nullable = false)
	private Date updatedDate;

	public String getName() {
		return this.name;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double newPrice) {
		this.price = newPrice;
	}
	
	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public Long getProductId() {
		return this.productId;
	}
	
	public int getCount() {
		return this.count;
	}
	public void setCount(int newCount) {
		this.count = newCount;
	}

	

	public Products(){}

	public Products(String name, double price, int count, String description) {
		this.name = name;
		this.description = description;
		this.price = price;
		// this.productId = productId;
		// this.category = category;
		this.count = count;
		// this.discount = discount;
		// this.createdDate = new Date(Calendar.getInstance().getTimeInMillis());
		
	}
	
	
	public void sellProduct() {
		//Call place order method
		this.setCount(this.getCount() - 1);
	}

	@Override
	public String toString(){
		return "Name : " + this.name + "Count : " + this.count + " Price : " + this.price;
	}

}
