package com.lotus.frontdesk.pojo;

import java.sql.Date;
import java.sql.Time;

public class Stay {
	private int s_id;
	private int num_nights;
	private Time ch_i_time;
	private Date ch_i_date;
	private Time ch_o_time;
	private Date ch_o_date;
	private int g_id;
	private int r_id;
	private String status;

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public int getNum_nights() {
		return num_nights;
	}

	public void setNum_nights(int num_nights) {
		this.num_nights = num_nights;
	}

	public Time getCh_i_time() {
		return ch_i_time;
	}

	public void setCh_i_time(Time ch_i_time) {
		this.ch_i_time = ch_i_time;
	}

	public Date getCh_i_date() {
		return ch_i_date;
	}

	public void setCh_i_date(Date ch_i_date) {
		this.ch_i_date = ch_i_date;
	}

	public Time getCh_o_time() {
		return ch_o_time;
	}

	public void setCh_o_time(Time ch_o_time) {
		this.ch_o_time = ch_o_time;
	}

	public Date getCh_o_date() {
		return ch_o_date;
	}

	public void setCh_o_date(Date ch_o_date) {
		this.ch_o_date = ch_o_date;
	}

	public int getG_id() {
		return g_id;
	}

	public void setG_id(int g_id) {
		this.g_id = g_id;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Stay(int s_id, int num_nights, Time ch_i_time, Date ch_i_date, Time ch_o_time, Date ch_o_date,
			int g_id, int r_id, String status) {
		super();
		this.s_id = s_id;
		this.num_nights = num_nights;
		this.ch_i_time = ch_i_time;
		this.ch_i_date = ch_i_date;
		this.ch_o_time = ch_o_time;
		this.ch_o_date = ch_o_date;
		this.g_id = g_id;
		this.r_id = r_id;
		this.status = status;
	}

	public Stay() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Stay [s_id=" + s_id + ", num_nights=" + num_nights + ", ch_i_time=" + ch_i_time
				+ ", ch_i_date=" + ch_i_date + ", ch_o_time=" + ch_o_time + ", ch_o_date=" + ch_o_date
				+ ", g_id=" + g_id + ", r_id=" + r_id + ", status=" + status + "]";
	}

}
