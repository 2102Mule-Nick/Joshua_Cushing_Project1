package com.lotus.frontdesk.pojo;

public class Room {
	private int r_id;
	private String status;
	private int bed_num;
	private String bed_size;
	private String lux_level;
	private float cost_per_night;

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

	public int getBed_num() {
		return bed_num;
	}

	public void setBed_num(int bed_num) {
		this.bed_num = bed_num;
	}

	public String getBed_size() {
		return bed_size;
	}

	public void setBed_size(String bed_size) {
		this.bed_size = bed_size;
	}

	public String getLux_level() {
		return lux_level;
	}

	public void setLux_level(String lux_level) {
		this.lux_level = lux_level;
	}

	public float getCost_per_night() {
		return cost_per_night;
	}

	public void setCost_per_night(float cost_per_night) {
		this.cost_per_night = cost_per_night;
	}

	public Room(int r_id, String status, int bed_num, String bed_size, String lux_level, float cost_per_night) {
		super();
		this.r_id = r_id;
		this.status = status;
		this.bed_num = bed_num;
		this.bed_size = bed_size;
		this.lux_level = lux_level;
		this.cost_per_night = cost_per_night;
	}

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Room [r_id=" + r_id + ", status=" + status + ", bed_num=" + bed_num + ", bed_size=" + bed_size
				+ ", lux_level=" + lux_level + ", cost_per_night=" + cost_per_night + "]";
	}

}
