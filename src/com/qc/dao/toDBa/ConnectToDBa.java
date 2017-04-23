package com.qc.dao.toDBa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import com.qc.calcuFee.CalcuFee;
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
	public static void upDateStaticUsrfee(int balance,int id){
		try {
			/**
			 * 费用  时间更新，用户状态更新
			 */
			pst=conn.prepareStatement("select now()");
			ret = pst.executeQuery();
			pst=conn.prepareStatement("select now()");
			ret = pst.executeQuery();
			pst=conn.prepareStatement("select now()");
			ret = pst.executeQuery();
			pst=conn.prepareStatement("select now()");
			ret = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static Object  getCurrentTime(boolean b){
		Time time = null;
		Date date = null;
		try {
			pst=conn.prepareStatement("select now()");
			 ret = pst.executeQuery();
			 while(ret.next()){
				 time = ret.getTime(1);
				 date = ret.getDate(1);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(b){
			return time;
		}else{
			return date;
		}
	}
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
	public static void  usrCheckDyamic(int id){
		DynamicUsr user = new DynamicUsr();
		//int len  = lst.size();
		try {
			pst=conn.prepareStatement("select * from dynamicusr where ID="+id);
			 ret = pst.executeQuery();
			 while(ret.next()){
				user.setBase_Fee(ret.getInt(1));
				user.setCar_type(ret.getString(2));
				user.setFee(ret.getInt(3));
				user.setID(ret.getInt(4));
				user.setStatus(ret.getInt(5));
		}
		}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		CalcuFee.getPointDynamicFee(user);
}
	
	
	public static void usrCheckStatic(int id ){
		StaticUSr user = new StaticUSr();
		try {
			pst=conn.prepareStatement("select * from staticuser where ID="+id);
			 ret = pst.executeQuery();
			 while(ret.next()){
					
					user.setStatus(ret.getInt(1));
					user.setTime(ret.getTime(2));
					user.setBalance(ret.getInt(3));
					user.setBase_Fee(ret.getInt(4));
					user.setLogIn_date(ret.getDate(5));
					user.setCar_type(ret.getString(6));
					user.setFee(ret.getInt(7));
					user.setID(ret.getInt(8));			
					user.setName(ret.getString(9));

				 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CalcuFee.getPointStaticFee(user);
	}
	
	
	
	public static String getpassword(){
		String s = "";
		try {
			pst=conn.prepareStatement("select password from BaseData");
			 ret = pst.executeQuery();
			 while(ret.next()){
				 s = ret.getString(1);
			 }
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
	
	/**
	 * 	
	 * @param name   the name from Frame "用户信息更新"
	 * @return  原始的用户信息(通过制定名字的方式查询用户信息)
	 */
	public static StaticUSr getStaitcPointUsr(String name){
		ArrayList<StaticUSr> list = getStaticStatus();
		for(int a = 0;a < list.size();a++){
			if(list.get(a).getName().equals(name) && name!= ""){
				return list.get(a);
			}
		}
		return null;
	}
	public  static  void cleanStatus(){
		pst = null;
		 conn = null;
		 ret = null;
	}
	/**
	 * 
	 * @return   all static users from dba
	 */
	public static ArrayList<StaticUSr> getStaticStatus(){
		ArrayList<StaticUSr> lst = new ArrayList<StaticUSr>();
		//int len  = lst.size();
		try {
			
			pst=conn.prepareStatement("select * from StaticUser");
			 ret = pst.executeQuery();
			 while(ret.next()){
				StaticUSr user = new StaticUSr();
				user.setStatus(ret.getInt(1));
				user.setTime(ret.getTime(2));
				user.setBalance(ret.getInt(3));
				user.setBase_Fee(ret.getInt(4));
				user.setLogIn_date(ret.getDate(5));
				user.setCar_type(ret.getString(6));
				user.setFee(ret.getInt(7));
				user.setID(ret.getInt(8));			
				user.setName(ret.getString(9));
				
				lst.add(user);
				user=null;

			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//cleanStatus();
		return lst;
	}
	
	/**
	 * 
	 * @return  return all dynamic users from the dba 
	 */
	public static ArrayList<DynamicUsr> getDynamicStatus(){
		ArrayList<DynamicUsr> lst = new ArrayList<DynamicUsr>();
		//int len  = lst.size();
		try {
			pst=conn.prepareStatement("select * from dynamicusr");
			 ret = pst.executeQuery();
			 while(ret.next()){
				DynamicUsr user = new DynamicUsr();
				user.setBase_Fee(ret.getInt(1));
				user.setCar_type(ret.getString(2));
				user.setFee(ret.getInt(3));
				user.setID(ret.getInt(4));
				user.setStatus(ret.getInt(5));
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
			//执行语句！
			pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 
	 * @param dynamic  add Dynamic Usr to the dba
	 */
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
	
	/**
	 * 
	 * @param list  用户在更新信息的时候更新信息的容器  、
	 * 0：新用户名
	 * 1：新的汽车类型
	 * 2：汽车的说明
	 */
	public static void updateUsrMsg(ArrayList<String> list){
		
		String NewName = list.get(0);
		String name = list.get(1);
		String carType = list.get(2);
		//数据库目前还没有建立这个模型，留着暂时先不使用
		String Msg = list.get(3);
		
		StaticUSr usr = getStaitcPointUsr(name);
		int id  = usr.getID();
		try{
			String sql = "UPDATE StaticUser SET Car_type='"+carType+"',name='"+NewName+"' WHERE ID='"+id+"'";
			pst = conn.prepareStatement(sql);
			pst.executeUpdate();
		}catch(SQLException e){
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
	
	

