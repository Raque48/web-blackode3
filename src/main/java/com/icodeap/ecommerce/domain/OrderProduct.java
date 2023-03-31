package com.icodeap.ecommerce.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderProduct {
    private Product product;
    private Integer quantity;
    private Order order;

    public OrderProduct(Product product, Integer quantity, Order order) {
        this.product = product;
        this.quantity = quantity;
        this.order = order;
    }
    
    public OrderProduct(){}
    
    
    public BigDecimal getTotalPrice(){
        return this.product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "OrderProduct [product=" + product + ", quantity=" + quantity + ", order=" + order + "]";
	}
    

}
