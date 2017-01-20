package com.qc.stetemIntro;

import com.qc.mainFrame.LongIn.LogIn;
import com.qc.dao.toDBa.*;

public class MainIntro {
	static ConnectToDBa dba = new ConnectToDBa();
	public static void main(String args[]){
	
		//new com.qc.mainFrame.MainFrame().setVisible(true);
		LogIn log = new LogIn();
		log.setVisible(true);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if(b==true){
//			log.setVisible(false);
//			new com.qc.mainFrame.MainFrame().setVisible(true);
//		}else{
//			System.out.println("error");
//		}
//		Thread s = new Thread(new GetMes());
//		s.start();
	}
}
class GetMes implements Runnable{
	public GetMes(){}
	@Override
	public void run(){
		System.out.println("Thread Test");
	}
}