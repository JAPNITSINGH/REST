package com.accolite.REST_Demo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
//@JsonRootName
public class MenuItem {
	
	private String itemName;
	private int cost;
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
}
