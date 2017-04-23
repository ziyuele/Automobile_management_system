package com.qc.dao.model;

import java.sql.Time;
import java.sql.Date;


public class StaticUSr extends Usr {
	public StaticUSr(){}
	private String name;
	private int ID;
	private int fee;
	private String Car_type;
	private Date LogIn_date;
	private int  Base_Fee;
	private int  balance;
	private int status;
	//parking time
	private Time time;
	public String document;
	public void setTime(Time time){
		this.time = time;
	}
	public Time getTime(){
		return this.time;
	}
	public int getStatus()
	{
		return this.status;
	}
	public void setStatus(int status){
		this.status = status;
	}
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
	public int getFee() {
		return fee;
	}
	public void setFee(int  fee) {
		this.fee = fee;
	}
	public String getCar_type() {
		return Car_type;
	}
	public void setCar_type(String car_type) {
		Car_type = car_type;
	}
	public Date getLogIn_date() {
		return LogIn_date;
	}
	public void setLogIn_date(Date logIn_date) {
		LogIn_date = logIn_date;
	}
	public int  getBase_Fee() {
		return Base_Fee;
	}
	public void setBase_Fee(int  base_Fee) {
		Base_Fee = base_Fee;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
}
