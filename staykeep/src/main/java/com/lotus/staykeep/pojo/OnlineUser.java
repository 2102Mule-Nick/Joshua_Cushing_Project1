package com.lotus.staykeep.pojo;

public class OnlineUser {
	private int u_id;
	private String user_name;
	private String pass_word;
	private String email;

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public OnlineUser(int u_id, String user_name, String pass_word, String email) {
		super();
		this.u_id = u_id;
		this.user_name = user_name;
		this.pass_word = pass_word;
		this.email = email;
	}

	public OnlineUser() {
		super();
	}

	@Override
	public String toString() {
		return "OnlineUser [u_id=" + u_id + ", user_name=" + user_name + ", pass_word=" + pass_word + ", email=" + email
				+ "]";
	}

}