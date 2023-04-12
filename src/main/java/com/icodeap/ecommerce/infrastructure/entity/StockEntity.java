package com.icodeap.ecommerce.infrastructure.entity;

import com.icodeap.ecommerce.domain.Product;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Table(name = "railway.stock")
@NoArgsConstructor
@Data
public class StockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime dateCreated;
    private Integer unitIn;
    private Integer unitOut;
    private String description;
    private Integer balance;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ProductEntity productEntity;
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
	public ProductEntity getProductEntity() {
		return productEntity;
	}
	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}
	@Override
	public String toString() {
		return "StockEntity [id=" + id + ", dateCreated=" + dateCreated + ", unitIn=" + unitIn + ", unitOut=" + unitOut
				+ ", description=" + description + ", balance=" + balance + ", productEntity=" + productEntity + "]";
	}
    
    
}
