package com.qc.dao.toDBa;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.swing.JButton;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.qc.calcuFee.CalcuFee;
import com.qc.dao.model.DynamicUsr;
import com.qc.dao.model.StaticUSr;
import com.qc.hardware.ConnectToHardWare;
import com.qc.mainFrame.mMessage;

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
	
	public static void updateFee(String name,int fee){
		try{
			int balsenc  =0;
			ResultSet rst = conn.prepareStatement("select  balance from staticuser  where name='"+name+"'").executeQuery();
			while (rst.next()){
				balsenc=rst.getInt(1);
				break;
			}
			System.out.println(balsenc);
			int putFee = balsenc+fee;
			conn.prepareStatement("update staticuser set balance="+putFee+" where name='"+name+"'").executeUpdate();
			new mMessage("充值完成，用户："+name+",余额："+putFee);
		}catch(Exception e){
			e.printStackTrace();
			new mMessage("用户不存在");
		}
	}
		
	public static void upDateStaticUsrfee(int balance,int id){
		try {
			/**
			 * 费用  时间更新，用户状态更新
			 */
			//日期更新
			conn.prepareStatement("update staticuser set logIn_date=now() where ID="+id).executeUpdate();
			//时间更新
			conn.prepareStatement("update staticuser set parking_time=now() where ID="+id).executeUpdate();
			//费用更新
			if(balance==-1){
			conn.prepareStatement("update staticuser set status=1 where ID="+id).executeUpdate();
			}else{
			conn.prepareStatement("update staticuser set balance="+balance+" where ID="+id).executeUpdate();
			conn.prepareStatement("update staticuser set status=0 where ID="+id).executeUpdate();
			}
			//状态更新
			
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
	
	public static void delectUsers(String name){
		//0 是静态用户
		String table = "";
		ArrayList<StaticUSr> lst1 =ConnectToDBa.getStaticStatus();
		ArrayList<DynamicUsr> lst2 = ConnectToDBa.getDynamicStatus();
		for(int a = 0;a<lst1.size();a++){
			if(lst1.get(a).getName().equals(name)){
				table  = "staticuser";
			}
		}
		for (int b = 0;b<lst2.size();b++){
			if (lst2.get(b).getName().equals(name)){
				table = "dynamicusr";
			}
		}
		
		if(table == "" || table.equals("") || table.length()==0){
			new mMessage("用户不存在，请核对后输入");
			return;
		}
		
		try {
			conn.prepareStatement("delete from "+ table + " where name='"+ name +"'").executeUpdate();
			 new mMessage("用户删除成功！");
			 return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void  usrCheckDyamic(String UID){
		DynamicUsr user = new DynamicUsr();
		//int len  = lst.size();
		try {
			pst=conn.prepareStatement("select * from dynamicusr where uID="+UID);
			 ret = pst.executeQuery();
			 while(ret.next()){
				 //
				user.setBase_Fee(ret.getInt(1));
				user.setCar_type(ret.getString(2));
				user.setFee(ret.getInt(3));
				user.setID(ret.getInt(4));
				user.setStatus(ret.getInt(5));
		}
		}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}if(user.getID()==0){}
	else{
		CalcuFee.getPointDynamicFee(user);
	}
		
}
	public static String getUsr(){
		while(ConnectToHardWare.getUID()==null || ConnectToHardWare.getUID()==""){
			ConnectToHardWare.setFlag(true);
			System.out.println("while xunhuan"+ConnectToHardWare.getUID());
		}
		String UID = ConnectToHardWare.getUID();
		String ans = "";
		try {
			pst=conn.prepareStatement("select name from staticuser where UID='"+UID+"'");
			ret = pst.executeQuery();
			while(ret.next()){
				ans = ret.getString(1);
				return ans;
			}
			pst=conn.prepareStatement("select name from dynamicusr where UID='"+UID+"'");
			ret = pst.executeQuery();
			while(ret.next()){
				ans = ret.getString(1);
				return ans;
			}
			return null;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			new mMessage("信息不存在");
		}
		
		return name;
	}
	public static void usrCheckStatic(String UID){
		StaticUSr user = new StaticUSr();
		try {
			pst=conn.prepareStatement("select * from staticuser where UID='"+UID+"'");
			 ret = pst.executeQuery();
			 while(ret.next()){
					//statys，parking_time balance 
				 	//Base_Fee LogIn_data Car_type fee Id name
				 	//uid
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
		if(user.getID()==0){
			usrCheckDyamic(UID);
			}
		else{
		CalcuFee.getPointStaticFee(user);
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
	public static void getExcel(){
		 ArrayList<StaticUSr> lst1 =ConnectToDBa.getStaticStatus();
		 ArrayList<DynamicUsr> lst2 = ConnectToDBa.getDynamicStatus();
		 HSSFWorkbook wb = new HSSFWorkbook(); 
		 HSSFSheet sheet1 = wb.createSheet("长期用户");
		 HSSFSheet sheet2 = wb.createSheet("临时用户");
		 
		 HSSFRow row = sheet1.createRow((int) 0);  
		 HSSFRow row1 = sheet2.createRow((int) 0);  
		 HSSFCellStyle style = wb.createCellStyle();  
		 HSSFCellStyle style1 = wb.createCellStyle();  
	     style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
	     style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	     HSSFCell cell2 = row1.createCell((short) 0); 
	     	cell2.setCellValue("姓名");  
	        cell2.setCellStyle(style);
	        
	        cell2 = row1.createCell((short) 1);  
	        cell2.setCellValue("车型");  
	        cell2.setCellStyle(style); 
	        
	        cell2 = row1.createCell((short) 2);  
	        cell2.setCellValue("费用");  
	        cell2.setCellStyle(style);  
	        
	        cell2 = row1.createCell((short) 3);  
	        cell2.setCellValue("状态");  
	        cell2.setCellStyle(style);  
	        
	        cell2 = row1.createCell((short) 4);  
	        cell2.setCellValue("余额");  
	        cell2.setCellStyle(style); 
	        
	        cell2 = row1.createCell((short) 5);  
	        cell2.setCellValue("卡片ID");  
	        cell2.setCellStyle(style); 
	        for(int x = 0;x < lst2.size();x++){
	        	row1 = sheet2.createRow((int) x + 1); 
	        	DynamicUsr use = lst2.get(x);
	        	row1.createCell((short) 0).setCellValue(use.getName());
	        	row1.createCell((short) 1).setCellValue(use.getCar_type());
	        	row1.createCell((short) 2).setCellValue(use.getBase_Fee());
	        	row1.createCell((short) 3).setCellValue(use.getstatus());
	        	row1.createCell((short) 4).setCellValue(use.getFee());
	        	row1.createCell((short) 5).setCellValue(use.getID());
	        }
	        
	     HSSFCell cell1 = row.createCell((short) 0);  
	        cell1.setCellValue("姓名");  
	        cell1.setCellStyle(style);  
	        
	        cell1 = row.createCell((short) 1);  
	        cell1.setCellValue("车型");  
	        cell1.setCellStyle(style);  
	        
	        cell1 = row.createCell((short) 2);  
	        cell1.setCellValue("余额");  
	        cell1.setCellStyle(style);  
	        
	        cell1 = row.createCell((short) 3);  
	        cell1.setCellValue("基本费");  
	        cell1.setCellStyle(style); 
	        
	        cell1 = row.createCell((short) 4);
	        cell1.setCellValue("卡片ID");  
	        cell1.setCellStyle(style); 
	        
	        cell1 = row.createCell((short) 5);
	        cell1.setCellValue("状态"); 
	        cell1.setCellStyle(style);
	        
	       // cell1 = row.createCell((short) 5);
	        //cell1.setCellStyle(style); 
	        for(int a = 0;a< lst1.size();a++){
	        	row = sheet1.createRow((int) a + 1); 
	        	StaticUSr use = lst1.get(a);
	        	row.createCell((short) 0).setCellValue(use.getName());
	        	row.createCell((short) 1).setCellValue(use.getCar_type());
	        	row.createCell((short) 2).setCellValue(use.getBalance());
	        	row.createCell((short) 3).setCellValue(use.getBase_Fee());
	        	row.createCell((short) 4).setCellValue(use.getID());
	        	row.createCell((short) 5).setCellValue(use.getStatus());
	        	use = null;
	        }
	        try  
	        {  
	            FileOutputStream fout = new FileOutputStream("C:/Users/kangjianhome/Desktop/students.xls");
	            wb.write(fout);  
	            fout.close();  
	        }  
	        catch (Exception e)  
	        {  
	            e.printStackTrace();  
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
	
	
	public static DynamicUsr getDynamicUsr(String name){
		ArrayList<DynamicUsr> list = getDynamicStatus();
		System.out.println(list.size());
		if (list.size()==0){
			return null;
		}
		for(int a = 0; a < list.size(); a++ ){
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
				String UID = ret.getString(6);
				String name = ret.getString(7);
				user.setName(name);
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
	
	public static boolean checkUID(String UID){
		try{
			pst = conn.prepareStatement("select UID from staticuser");
			ret = pst.executeQuery();
			while(ret.next()){
				String existUID=ret.getString(1);
				if(UID==existUID || UID.equals(existUID)){
					return false;
				}
			}
			pst = conn.prepareStatement("select UID from dynamicusr");
			ret = pst.executeQuery();
			while(ret.next()){
				String existUID=ret.getString(1);
				if(UID==existUID || UID.equals(existUID)){
					return false;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	
	public static void addStatic(StaticUSr  statusr,JButton jb){
		while(ConnectToHardWare.getUID()==null || ConnectToHardWare.getUID()==""){
			ConnectToHardWare.setFlag(true);
			System.out.println("while xunhuan"+ConnectToHardWare.getUID());
		}
		String UID = ConnectToHardWare.getUID();
		if(checkUID(UID)){
			String name = statusr.getName();
			try{
				pst = conn.prepareStatement("insert into StaticUser (status, balance, Base_Fee, Car_type, fee, name) values ( '0', '"
						+statusr.getBalance()+"','" 
						+ statusr.getBase_Fee()+"','" + statusr.getCar_type()+"','"
						+statusr.getFee()+"','"+ statusr.getName()+"')" );
				pst.executeUpdate();
				conn.prepareStatement("update staticuser set parking_time=now() where name='"+name+"'").executeUpdate();
				conn.prepareStatement("update staticuser set LogIn_date=now() where name='"+name+"'").executeUpdate();
				conn.prepareStatement("update staticuser set UID='"+UID+"' where name='"+name+"'").executeUpdate();
				jb.setText("录入成功");
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			new mMessage("用户已存在！！");
		}
		
	}
	
	
	/**
	 * 
	 * @param dynamic  add Dynamic Usr to the dba
	 * 
	 */
	public static void AddDynamicUser(DynamicUsr dynamic, JButton jb){
		while(ConnectToHardWare.getUID()==null || ConnectToHardWare.getUID()==""){
			ConnectToHardWare.setFlag(true);
			System.out.println("while x "+ConnectToHardWare.getUID());
		}
		String UID = ConnectToHardWare.getUID();
		if(checkUID(UID)){
			String name = dynamic.getName();
			String  type = dynamic.getCar_type();
			int fee  = dynamic.getBase_Fee();
			try {
				conn.prepareStatement("insert into dynamicusr (status, name, Car_type, Base_Fee,fee, UID) values (0, '"+
				name+"', '"+type+"', "+fee+", 0, '"+UID+"')").executeQuery();
				jb.setText("录入成功");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			new mMessage("用户已存在！！！");
		}
	}
	
	/**
	 * 
	 * @param list  用户在更新信息的时候更新信息的容器  、
	 * 0：新用户名
	 * 1：新的汽车类型
	 * 2：汽车的说明
	 */
	public static void updateUsrMsg(Map<String, String> myMap, boolean flag){
		String sql ="";
		String name = myMap.get("name");
		String newName = myMap.get("newNma");
		String carType = myMap.get("carType");
		String msg = myMap.get("msg");
		//update statc user
		if (flag == false){
			sql = "update staticuser set name='"+newName+"',Car_type='"+carType+"' where name='"+name+"'" ;
		}else{
			sql = "update dynamicusr set name='"+newName+"',Car_type='"+carType+"' where name='"+name+"'" ;
		}
		try{
			conn.prepareStatement(sql).executeUpdate();
			new mMessage("信息更新完成 !\r\n 用户:"+newName+ "   车辆信息："+carType);
		}catch(SQLException e){
			//e.printStackTrace();
			new mMessage("信息有误，请核对！");
		}
	} 
	
	public static void close(){
		try{
			conn.close();
			pst.close();
		}catch(Exception e){
			//e.printStackTrace();
		}
	}

}
	
	

