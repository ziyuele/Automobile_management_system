package com.qc.dao.model;


public class StaticUSr {
	public StaticUSr(){}
	private String name;
	private int ID;
	private float fee;
	private String Car_type;
	private int LogIn_date;
	private float Base_Fee;
	private float balance;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public void setFee(float fee) {
		this.fee = fee;
	}
	public String getCar_type() {
		return Car_type;
	}
	public void setCar_type(String car_type) {
		Car_type = car_type;
	}
	public int getLogIn_date() {
		return LogIn_date;
	}
	public void setLogIn_date(int logIn_date) {
		LogIn_date = logIn_date;
	}
	public float getBase_Fee() {
		return Base_Fee;
	}
	public void setBase_Fee(float base_Fee) {
		Base_Fee = base_Fee;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
}
