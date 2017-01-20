package com.qc.mainFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

import com.qc.about.AboutSoft;
import com.qc.dao.model.DynamicUsr;
import com.qc.dao.model.StaticUSr;
import com.qc.dao.toDBa.ConnectToDBa;

/*
 * 程序的主界面设置
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	ImageIcon icon;  
    Image img;  
	
	private LeftERA ltf = new LeftERA(this);
	private RightERA rig = new RightERA(this);
	public  static JSplitPane hsplit = new JSplitPane();
	public LeftERA getleftERa(){
		return ltf;
	}
	public RightERA getRightERA(){
		return rig;
	}
	public MainFrame(){
		
		this.setBackground(Color.GREEN);
		int height=500, width=600;
		this.setTitle("汽车管理系统");
		int widthh = Toolkit.getDefaultToolkit().getScreenSize().width;
		int heightt = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(widthh/2-width/2, heightt/2-height/2);
		this.setSize(width, height);
		this.setExtendedState(MAXIMIZED_BOTH);
		
		this.setJMenuBar(new MeanuBar().getMenuBar());
		
		
		
		
		Container con = this.getContentPane();
		hsplit.setDividerLocation(350);
		hsplit.setLeftComponent(ltf);
		hsplit.setRightComponent(new RightERA2());
		con.add(hsplit);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}	
/*
 * 主界面设置为两个大的模块，其中左边的模块为以下的具体内容：
 */
@SuppressWarnings("serial")
class LeftERA extends JPanel{
	ImageIcon icon = new ImageIcon("imge/Icon.png");
	private Button1 button1 = new Button1("系统状态");
	private Button1 button2 = new Button1("添加用户");
	private Button1 button3 = new Button1("信息管理");
	private Button1 button4 = new Button1("设置");
	public LeftERA(MainFrame mianFrame){
		super(); 
		this.setLayout(new GridLayout(5,1,10,10));		
		
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("test1 success");
				MainFrame.hsplit.setRightComponent(new RightERA1());
			}
		});
		
		
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("test2 success");
				new com.qc.mainFrame.ChooseAddModel();
			}
		});
		
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MsgeMange();
			}
		});
		
		button4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AboutSoft();
			}
		});
		
		
		this.add(new ButtonFrame());
		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(button4);
	}
	
}


class RightERA extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1547905317626308785L;
	
	public  RightERA(MainFrame mainFrame){
		//super();
		this.setLayout(new GridLayout());
		this.add(new JLabel(new ImageIcon("imge/MianFrame.png")));
	}
}


@SuppressWarnings("serial")
class RightERA1 extends JPanel{
	private ArrayList<StaticUSr> lst1 = null;
	private ArrayList<DynamicUsr> lst2 = null;
	public RightERA1(){
		super();	
		this.lst1 = ConnectToDBa.getStaticStatus();
		this.lst2 = ConnectToDBa.getDynamicStatus();
		this.setLayout(new GridLayout(10,10,10,10));
		for(int a = 0;a<lst1.size();a++){
			float balence = lst1.get(a).getBalance();
			float base_Fee = lst1.get(a).getBase_Fee();
			String Car_type = lst1.get(a).getCar_type();
			float fee = lst1.get(a).getFee();
			int id = lst1.get(a).getID();
			int  logIn_Date = lst1.get(a).getLogIn_date();
			String name = lst1.get(a).getName();
			
			JLabel jbCar = new JLabel("name:"+name+"   "+"id:"+id);
			jbCar.setOpaque(true);
			jbCar.setBackground(Color.CYAN);
			jbCar.setFont(new Font("宋体", Font.PLAIN, 13));
			jbCar.setSize(50, 50);
			this.add(jbCar);
		}
		
		for(int b = 0;b<lst2.size();b++){
			float base_Fee =lst2.get(b).getBase_Fee();
			String Car_type = lst2.get(b).getCar_type();
			float fee = lst2.get(b).getFee();
			int Id = lst2.get(b).getID();
			
			JLabel jbCar = new JLabel("Car_type:"+Car_type+"   "+"id:"+Id);
			jbCar.setOpaque(true);
			jbCar.setBackground(Color.GRAY);
			jbCar.setFont(new Font("宋体", Font.PLAIN, 13));
			jbCar.setSize(50, 50);
			this.add(jbCar);
		}
		for(int c = 0;c<(100-(lst1.size()+lst2.size()));c++){
			JLabel jbCar = new JLabel("null");
			jbCar.setOpaque(true);
			jbCar.setIcon(new ImageIcon("imge/icon1.png"));
			jbCar.setBackground(Color.PINK);
			jbCar.setFont(new Font("宋体", Font.PLAIN, 13));
			jbCar.setSize(50, 50);
			this.add(jbCar);
		}
	}
}
class RightERA2 extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3539029942436923128L;
	ImageIcon icon;  
    Image img;  
	public RightERA2(){
		icon = new ImageIcon("imge/MianFrame.png");
        img=icon.getImage();  
	}
	   public void paintComponent(Graphics g) {  
	        super.paintComponent(g);  
	        //下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小  
	        g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);  
	    }  
	
}



