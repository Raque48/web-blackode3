package com.icodeap.ecommerce.infrastructure.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Embeddable
public class OrderProductPK {
    @ManyToOne (fetch = FetchType.LAZY)
    private OrderEntity orderEntity;
    @ManyToOne (fetch = FetchType.LAZY)
    private  ProductEntity productEntity;
	public OrderEntity getOrderEntity() {
		return orderEntity;
	}
	public void setOrderEntity(OrderEntity orderEntity) {
		this.orderEntity = orderEntity;
	}
	public ProductEntity getProductEntity() {
		return productEntity;
	}
	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}
	@Override
	public String toString() {
		return "OrderProductPK [orderEntity=" + orderEntity + ", productEntity=" + productEntity + "]";
	}
    
    
}
