package com.lotus.frontdesk.pojo;

public class ServItem {
	private int item_id;
	private String item_name;
	private float price;

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public ServItem(int item_id, String item_name, float price) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.price = price;
	}

	public ServItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ServItem [item_id=" + item_id + ", item_name=" + item_name + ", price=" + price + "]";
	}
}
