package com.qc.dao.model;


public class DynamicUsr {
	public DynamicUsr(){}
	private int ID;
	private float fee;
	private String Car_type;
	private float Base_Fee;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public float getFee() {
		return fee;
	}
	public void setFee(float fee) {
		this.fee = fee;
	}
	public String getCar_type() {
		return Car_type;
	}
	public void setCar_type(String car_type) {
		Car_type = car_type;
	}
	public float getBase_Fee() {
		return Base_Fee;
	}
	public void setBase_Fee(float base_Fee) {
		Base_Fee = base_Fee;
	}
}
