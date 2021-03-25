package com.lotus.frontdesk.pojo;

public class ServRow {
	private int row_id;
	private int item_id;
	private int order_id;

	public int getRow_id() {
		return row_id;
	}

	public void setRow_id(int row_id) {
		this.row_id = row_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public ServRow(int row_id, int item_id, int order_id) {
		super();
		this.row_id = row_id;
		this.item_id = item_id;
		this.order_id = order_id;
	}

	public ServRow() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ServRow [row_id=" + row_id + ", item_id=" + item_id + ", order_id=" + order_id + "]";
	}

}
