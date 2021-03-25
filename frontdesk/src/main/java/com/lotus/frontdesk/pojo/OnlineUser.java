package com.lotus.frontdesk.pojo;

public class OnlineUser {
	private int ou_id;
	private String email;
	private String phone;
	private String user_name;
	private String pass_word;
	private String g_id;

	public int getOu_id() {
		return ou_id;
	}

	public void setOu_id(int ou_id) {
		this.ou_id = ou_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPass_word() {
		return pass_word;
	}

	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}

	public String getG_id() {
		return g_id;
	}

	public void setG_id(String g_id) {
		this.g_id = g_id;
	}

	public OnlineUser(int ou_id, String email, String phone, String user_name, String pass_word, String g_id) {
		super();
		this.ou_id = ou_id;
		this.email = email;
		this.phone = phone;
		this.user_name = user_name;
		this.pass_word = pass_word;
		this.g_id = g_id;
	}

	public OnlineUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OnlineUser [ou_id=" + ou_id + ", email=" + email + ", phone=" + phone + ", user_name=" + user_name
				+ ", pass_word=" + pass_word + ", g_id=" + g_id + "]";
	}

}
