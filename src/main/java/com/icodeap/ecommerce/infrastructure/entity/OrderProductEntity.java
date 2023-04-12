package com.icodeap.ecommerce.infrastructure.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "railway.ordersproducts")
public class OrderProductEntity {
    @EmbeddedId
    private  OrderProductPK pk;
    private Integer quantity;
	public OrderProductPK getPk() {
		return pk;
	}
	public void setPk(OrderProductPK pk) {
		this.pk = pk;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderProductEntity [pk=" + pk + ", quantity=" + quantity + "]";
	}
    
    
    
}
