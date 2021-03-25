package com.lotus.frontdesk.pojo;

public class Guest {
	private int g_id;
	private String f_name;
	private String l_name;

	public int getG_id() {
		return g_id;
	}

	public void setG_id(int g_id) {
		this.g_id = g_id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public Guest(int g_id, String f_name, String l_name) {
		super();
		this.g_id = g_id;
		this.f_name = f_name;
		this.l_name = l_name;
	}

	public Guest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Guest [g_id=" + g_id + ", f_name=" + f_name + ", l_name=" + l_name + "]";
	}

}
