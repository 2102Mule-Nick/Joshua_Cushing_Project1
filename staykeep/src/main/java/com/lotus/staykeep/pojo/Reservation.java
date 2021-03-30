package com.lotus.staykeep.pojo;

import java.sql.Date;
import java.sql.Time;

public class Reservation {
	private int res_id;
	private Time ch_i_time;
	private Date ch_i_date;
	private Time ch_o_time;
	private Date ch_o_date;
	private int r_id;
	private int u_id;
	private String status;

	public int getRes_id() {
		return res_id;
	}

	public void setRes_id(int res_id) {
		this.res_id = res_id;
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

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Reservation(int res_id, Time ch_i_time, Date ch_i_date, Time ch_o_time, Date ch_o_date, int r_id, int u_id,
			String status) {
		super();
		this.res_id = res_id;
		this.ch_i_time = ch_i_time;
		this.ch_i_date = ch_i_date;
		this.ch_o_time = ch_o_time;
		this.ch_o_date = ch_o_date;
		this.r_id = r_id;
		this.u_id = u_id;
		this.status = status;
	}

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Reservation [res_id=" + res_id + ", ch_i_time=" + ch_i_time + ", ch_i_date=" + ch_i_date
				+ ", ch_o_time=" + ch_o_time + ", ch_o_date=" + ch_o_date + ", r_id=" + r_id + ", u_id=" + u_id
				+ ", status=" + status + "]";
	}

}