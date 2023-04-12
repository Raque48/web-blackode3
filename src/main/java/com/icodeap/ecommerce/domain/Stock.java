package com.icodeap.ecommerce.domain;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class Stock {
    private Integer id;
    private LocalDateTime dateCreated;
    private Integer unitIn;
    private Integer unitOut;
    private String description;
    private Integer balance;
    private Product product;
	
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Integer getUnitIn() {
		return unitIn;
	}
	public void setUnitIn(Integer unitIn) {
		this.unitIn = unitIn;
	}
	public Integer getUnitOut() {
		return unitOut;
	}
	public void setUnitOut(Integer unitOut) {
		this.unitOut = unitOut;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Stock [id=" + id + ", dateCreated=" + dateCreated + ", unitIn=" + unitIn + ", unitOut=" + unitOut
				+ ", description=" + description + ", balance=" + balance + ", product=" + product + "]";
	}

    

}
