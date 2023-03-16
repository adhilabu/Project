package com.products.catalogue.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Items {

	@Id
	@GeneratedValue
	private Long id;

	private String itemCode;

	private String itemName;

	private String categoryL1;

	private String categoryL2;

	private String upc;

	private String parentCode;

	private String mrpPrice;

	private String size;

	private String enabled;

	public Items(Long id, String itemCode, String itemName, String categoryL1, String categoryL2, String upc,
			String parentCode, String mrpPrice, String size, String enabled) {
		super();
		this.id = id;
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.categoryL1 = categoryL1;
		this.categoryL2 = categoryL2;
		this.upc = upc;
		this.parentCode = parentCode;
		this.mrpPrice = mrpPrice;
		this.size = size;
		this.enabled = enabled;
	}

	public Items() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCategoryL1() {
		return categoryL1;
	}

	public void setCategoryL1(String categoryL1) {
		this.categoryL1 = categoryL1;
	}

	public String getCategoryL2() {
		return categoryL2;
	}

	public void setCategoryL2(String categoryL2) {
		this.categoryL2 = categoryL2;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getMrpPrice() {
		return mrpPrice;
	}

	public void setMrpPrice(String mrpPrice) {
		this.mrpPrice = mrpPrice;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

}
