package com.icodeap.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@ToString
public class ItemCart {
    private Integer idProduct;
    //nombre
    private String nameProduct;
    //cantidad
    private Integer quantity;
    //precio
    private BigDecimal price;

    //precio de un item paso un entero lo casteo con con quantiti valor total
    public BigDecimal getTotalPriceItem(){
        return price.multiply(BigDecimal.valueOf(quantity));
    }

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void Inicializar(Integer idProduct,String nameProduct,Integer quantity,BigDecimal price) {
		this.idProduct=idProduct;
		this.nameProduct=nameProduct;
		this.price=price;
		this.quantity=quantity;
	}
	public ItemCart() {
		 
		
	}
	@Override
	public String toString() {
		return "ItemCart [idProduct=" + idProduct + ", nameProduct=" + nameProduct + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
    
}
