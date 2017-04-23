package com.qc.stetemIntro;

import java.util.Scanner;
import com.qc.dao.toDBa.*;

import com.qc.dao.toDBa.ConnectToDBa;
import com.qc.mainFrame.LongIn.LogIn;

public class MainIntro {
	static ConnectToDBa dba = new ConnectToDBa();
	public static void main(String args[]){
	
		//new com.qc.mainFrame.MainFrame().setVisible(true);
		LogIn log = new LogIn();
		log.setVisible(true);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread s = new Thread(new GetMes());
		s.start();
	}
}
class GetMes implements Runnable{
	public GetMes(){}
	@Override
	public void run(){
		//new com.qc.hardware.ConnectToHardWare();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()){
			int id = sc.nextInt();
			if (id < 401){
			ConnectToDBa.usrCheckStatic(id);
			}else{
				ConnectToDBa.usrCheckDyamic(id-400);
			}
		}
	}
}