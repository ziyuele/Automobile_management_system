package com.qc.dao.toDBa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.qc.dao.model.DynamicUsr;
import com.qc.dao.model.StaticUSr;

public class ConnectToDBa {
	static String name = "root";
	static String psw = "root";
	static String url = "jdbc:mysql://localhost:3306/carbase";
	static PreparedStatement pst = null;
	static Connection conn = null;
	static ResultSet ret = null;
	static{
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			 conn = DriverManager.getConnection(url, name, psw);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ConnectToDBa(){}
	public static String getAdministrators(){
		String s = "";
		try {
			pst=conn.prepareStatement("select Administrators from BaseData");
			 ret = pst.executeQuery();
			 while(ret.next()){
				 s = ret.getString(1);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(s.equals("") || s==null){
			return "";
		}else{
			System.out.println(s);
			return s;
		}
	}
	public static String getpassword(){
		String s = "";
		try {
			pst=conn.prepareStatement("select password from BaseData");
			 ret = pst.executeQuery();
			 while(ret.next()){
				 s = ret.getString(1);
			 }
			 pst = null;
			 conn = null;
			 ret = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(s.equals("") || s==null){
			return "";
		}else{
			System.out.println(s);
			return s;
		}
	}
	public static ArrayList<StaticUSr> getStaticStatus(){
		ArrayList<StaticUSr> lst = new ArrayList<StaticUSr>();
		//int len  = lst.size();
		try {
			pst=conn.prepareStatement("select * from StaticUser");
			 ret = pst.executeQuery();
			 while(ret.next()){
				StaticUSr user = new StaticUSr();
				user.setBalance(ret.getFloat(1));
				user.setBase_Fee(ret.getFloat(2));
				user.setLogIn_date(ret.getInt(3));
				user.setCar_type(ret.getString(4));
				user.setFee(ret.getFloat(5));
				user.setID(ret.getInt(6));			
				user.setName(ret.getString(7));
				
				lst.add(user);
				user=null;

			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lst;
	}
	
	public static ArrayList<DynamicUsr> getDynamicStatus(){
		ArrayList<DynamicUsr> lst = new ArrayList<DynamicUsr>();
		//int len  = lst.size();
		try {
			pst=conn.prepareStatement("select * from DynamicUsr");
			 ret = pst.executeQuery();
			 while(ret.next()){
				DynamicUsr user = new DynamicUsr();
				user.setBase_Fee(ret.getFloat(1));
				user.setCar_type(ret.getString(2));
				user.setFee(ret.getFloat(3));
				user.setID(ret.getInt(4));
				
				lst.add(user);
				user=null;
				
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;

	}
	@SuppressWarnings("deprecation")
	public static int date(){
		Date d = new Date();
		int x = d.getYear()+1900;
		int y = d.getMonth()+1;
		int z = d.getDate();
		String s  = x+""+y+""+z;
		int ans = Integer.parseInt(s);
		return ans;
	}
	public static void addStatic(StaticUSr  statusr){
		
		
		try{
			pst = conn.prepareStatement("insert into StaticUser values (?,?,?,?,?,?,?)");
			pst.setFloat(1, 0);
			pst.setFloat(2, statusr.getBase_Fee());
			pst.setInt(3,date());
			pst.setString(4, statusr.getCar_type());
			pst.setFloat(5, 0);
			pst.setInt(6, statusr.getID());
			pst.setString(7, statusr.getName());
			//Ö´ÐÐÓï¾ä£¡
			pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void AddDynamicUser(DynamicUsr dynamic){
		float Base_Fee = dynamic.getBase_Fee();
		String car_type = dynamic.getCar_type();
		int  ID = dynamic.getID();
		try {
			
			pst = conn.prepareStatement("insert into DynamicUsr values(?,?,?,?)");
			pst.setFloat(1, Base_Fee);
			pst.setString(2, car_type);
			pst.setFloat(3, 0);
			pst.setInt(4, ID);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(){
		try{
			conn.close();
			pst.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
	
	

