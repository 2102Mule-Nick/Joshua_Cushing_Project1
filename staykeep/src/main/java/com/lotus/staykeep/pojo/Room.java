package com.lotus.staykeep.pojo;

public class Room {
	private int r_id;
	private String status;
	private int bed_num;
	private String bed_size;
	private String lux_level;
	private float cpn;

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

	public float getCpn() {
		return cpn;
	}

	public void setCpn(float cpn) {
		this.cpn = cpn;
	}

	public Room(int r_id, String status, int bed_num, String bed_size, String lux_level, float cpn) {
		super();
		this.r_id = r_id;
		this.status = status;
		this.bed_num = bed_num;
		this.bed_size = bed_size;
		this.lux_level = lux_level;
		this.cpn = cpn;
	}

	public Room() {
		super();

	}

	@Override
	public String toString() {
		return "Room [r_id=" + r_id + ", status=" + status + ", bed_num=" + bed_num + ", bed_size=" + bed_size
				+ ", lux_level=" + lux_level + ", cpn=" + cpn + "]";
	}

}