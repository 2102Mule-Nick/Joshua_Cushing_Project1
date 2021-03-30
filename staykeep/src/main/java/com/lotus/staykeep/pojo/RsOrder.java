package com.lotus.staykeep.pojo;

public class RsOrder {
	private int order_id;
	private int r_id;
	private float order_total;

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public float getOrder_total() {
		return order_total;
	}

	public void setOrder_total(float order_total) {
		this.order_total = order_total;
	}

	public RsOrder(int order_id, int r_id, float order_total) {
		super();
		this.order_id = order_id;
		this.r_id = r_id;
		this.order_total = order_total;
	}

	public RsOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "RsOrder [order_id=" + order_id + ", r_id=" + r_id + ", order_total=" + order_total + "]";
	}

}
