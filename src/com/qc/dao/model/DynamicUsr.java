package com.qc.dao.model;


public class DynamicUsr extends Usr{
	public DynamicUsr(){}
	private int ID;
	private int fee;
	private String Car_type;
	private int Base_Fee;
	private int status;
	private String name;
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	public void setStatus(int status){
		this.status = status;
	}
	public int getstatus(){
		return this.status;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public float getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public String getCar_type() {
		return Car_type;
	}
	public void setCar_type(String car_type) {
		Car_type = car_type;
	}
	public int getBase_Fee() {
		return Base_Fee;
	}
	public void setBase_Fee(int base_Fee) {
		Base_Fee = base_Fee;
	}
}
