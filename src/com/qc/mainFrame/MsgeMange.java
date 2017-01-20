package com.qc.mainFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class MsgeMange extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyButton button1,button2,button3,button4,button5 ;
	
	public MsgeMange(){
		
		int height=540, width=1000;
		int widthh = Toolkit.getDefaultToolkit().getScreenSize().width;
		int heightt = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(widthh/2-width/2, heightt/2-height/2);
		this.setSize(width, height);
		this.setTitle("汽车管理系统->信息管理");
		
		this.setLayout(new GridLayout(3,2));
		Container con =this.getContentPane();
		
		button1 = new MyButton("用户充值");
		con.add(button1);
		button2 = new MyButton("用户信息更新");
		con.add(button2);
		button3 = new MyButton("显示所有用户信息");
		con.add(button3);
		button4 = new MyButton("计费统计");
		con.add(button4);
		button5 = new MyButton("信息导出");
		con.add(button5);
		this.setVisible(true);
		
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				com.qc.mainFrame.MsgeMange.this.setVisible(false);
				new ReFlush();
			}
		});
	}
}
class ReFlush extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReFlush(){
		
		this.setTitle("用户充值");
		int height=540, width=1000;
		int widthh = Toolkit.getDefaultToolkit().getScreenSize().width;
		int heightt = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(widthh/2-width/2, heightt/2-height/2);
		this.setSize(width, height);
		
		JLabel name  = new JLabel("充值用户");
		JLabel cust = new JLabel("输入充值金额");
		
		JTextField fild1 = new JTextField(30);
		JTextField fild2 = new JTextField(30);
		
		JButton casel = new JButton("放弃");
		JButton ok = new JButton("添加");
		Pic pic = new Pic();
		MyButton button = new MyButton("刷卡确认用户");
		SpringLayout springLayout = new SpringLayout();
		Container con = getContentPane();
		con.setLayout(springLayout);
		//文本说明 Dialog1
		springLayout.putConstraint(SpringLayout.NORTH, name, 20, SpringLayout.NORTH,con);
		springLayout.putConstraint(SpringLayout.WEST, name,20, SpringLayout.WEST, con);
		//文本输入区
		springLayout.putConstraint(SpringLayout.NORTH, fild1,20, SpringLayout.NORTH, con);
		springLayout.putConstraint(SpringLayout.WEST, fild1,70, SpringLayout.SOUTH, name);
		//文本说明Dialog2
		springLayout.putConstraint(SpringLayout.NORTH, cust, 20, SpringLayout.SOUTH,fild1);
		springLayout.putConstraint(SpringLayout.WEST, cust,20, SpringLayout.WEST, con);
		//文本输入区
		springLayout.putConstraint(SpringLayout.NORTH, fild2,20, SpringLayout.SOUTH, fild1);
		springLayout.putConstraint(SpringLayout.WEST, fild2,70, SpringLayout.SOUTH, name);
		//确认按钮
		springLayout.putConstraint(SpringLayout.NORTH,ok,30,SpringLayout.SOUTH,fild2);
		springLayout.putConstraint(SpringLayout.EAST,ok,0,SpringLayout.EAST,fild2);
		//取消按钮
		springLayout.putConstraint(SpringLayout.NORTH,casel,30,SpringLayout.SOUTH,fild2);
		springLayout.putConstraint(SpringLayout.EAST,casel,-30,SpringLayout.WEST,ok);
		//使用刷卡按钮
		springLayout.putConstraint(SpringLayout.NORTH,button,0,SpringLayout.NORTH,fild1);
		springLayout.putConstraint(SpringLayout.WEST,button,30,SpringLayout.EAST,fild1);
		
		springLayout.putConstraint(SpringLayout.NORTH,pic,30,SpringLayout.SOUTH,button);
		springLayout.putConstraint(SpringLayout.WEST,pic,0,SpringLayout.WEST,con);
		springLayout.putConstraint(SpringLayout.EAST,pic,0,SpringLayout.EAST,con);
		springLayout.putConstraint(SpringLayout.SOUTH, pic, 10, SpringLayout.SOUTH, con);
		con.add(name);	con.add(fild1);
		con.add(cust); con.add(fild2);
		con.add(casel);con.add(ok);
		con.add(button); con.add(pic);
		
		casel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fild1.setText("");
				fild2.setText("");
			}
		});
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s1 = fild1.getText();
				String s2 = fild2.getText();
				try{
				int x = Integer.parseInt(s2);
				}catch(Exception ee){
					
					new Errorlog();
				}
				
			}
		});
		this.setVisible(true);
	}
}
class Errorlog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton button = new JButton("确定");
	private JLabel label = new JLabel("输入信息有误，请确认后输入！");
	private JLabel picc = new JLabel("",new ImageIcon("imge/errorr.png"),SwingConstants.CENTER);
	public Errorlog(){
		int height=200, width=240;
		int widthh = Toolkit.getDefaultToolkit().getScreenSize().width;
		int heightt = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(widthh/2-width/2, heightt/2-height/2);
		this.setSize(width, height);
		
		SpringLayout springLayout = new SpringLayout();
		
		
		
		Container con = getContentPane();
		con.setLayout(springLayout);
		con.setBackground(Color.GRAY);
		
		springLayout.putConstraint(SpringLayout.NORTH,label,0,SpringLayout.NORTH,con);
		springLayout.putConstraint(SpringLayout.WEST,label,0,SpringLayout.WEST,con);
		springLayout.putConstraint(SpringLayout.EAST,label,0,SpringLayout.EAST,con);
		springLayout.putConstraint(SpringLayout.SOUTH, label, 100, SpringLayout.NORTH, con);
		
		springLayout.putConstraint(SpringLayout.NORTH,button,0,SpringLayout.SOUTH,label);
		springLayout.putConstraint(SpringLayout.EAST,button,-10,SpringLayout.EAST,con);
		
		springLayout.putConstraint(SpringLayout.WEST,picc,0,SpringLayout.EAST,con);
		springLayout.putConstraint(SpringLayout.NORTH,picc,0,SpringLayout.SOUTH,label);
		springLayout.putConstraint(SpringLayout.SOUTH,picc,0,SpringLayout.SOUTH,con);
		springLayout.putConstraint(SpringLayout.EAST,picc,0,SpringLayout.WEST,button);
		
		con.add(label);
		con.add(button);
		con.add(picc);
		
		this.setVisible(true);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				com.qc.mainFrame.Errorlog.this.setVisible(false);
			}
		});
	}
}
class MyButton extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyButton(String s){
		super(s);
		this.setHorizontalTextPosition(SwingConstants.CENTER); 
		this.setIcon(new ImageIcon("imge/button.png"));
	}
}

class Pic extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon icon;  
    Image img;  
	public Pic(){
		icon = new ImageIcon("imge/MianFrame.png");
        img=icon.getImage();  
	}
	   public void paintComponent(Graphics g) {  
	        super.paintComponent(g);  
	        //下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小  
	        g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);  
	    }  
	
}
