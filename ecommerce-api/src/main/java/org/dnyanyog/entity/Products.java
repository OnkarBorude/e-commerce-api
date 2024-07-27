package org.dnyanyog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
public class Products {
	
	@GeneratedValue
	@Id
	@Column
	private Integer product_id;
	
	@Column
	private String productName;
	
	@Column
	private Integer productQuantity;
	
	@Column
	private Long productPrice;
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
	public Long getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Long productPrice) {
		this.productPrice = productPrice;
	}
	

}
