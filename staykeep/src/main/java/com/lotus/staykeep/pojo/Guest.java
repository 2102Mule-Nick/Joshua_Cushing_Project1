package com.lotus.staykeep.pojo;

public class Guest {
	private int g_id;
	private String f_name;
	private String l_name;
	private String cc_num;

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

	public String getCc_num() {
		return cc_num;
	}

	public void setCc_num(String cc_num) {
		this.cc_num = cc_num;
	}

	public Guest(int g_id, String f_name, String l_name, String cc_num) {
		super();
		this.g_id = g_id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.cc_num = cc_num;
	}

	public Guest() {
		super();
	}

	@Override
	public String toString() {
		return "Guest [g_id=" + g_id + ", f_name=" + f_name + ", l_name=" + l_name + ", cc_num=" + cc_num + "]";
	};
}