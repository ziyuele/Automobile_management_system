package com.qc.mainFrame;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChooseAddModel extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public ChooseAddModel(){
		this.setTitle("选择创建的用户类型");
		this.setResizable(false);
		int height=270, width=500;
		this.setSize(width, height);
		int widthh = Toolkit.getDefaultToolkit().getScreenSize().width;
		int heightt = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(widthh/2-width/2, heightt/2-height/2);
		this.setSize(width, height);
		this.add(new myPanel(this));
		this.setVisible(true);
	}
	public static void setViseub(boolean b){
		
	}
	
}
class myPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon icon;
	private Image img;
	public myPanel(ChooseAddModel module){
		icon = new ImageIcon("imge/MianFrame.png");
        img=icon.getImage();
		
		this.setLayout(new GridLayout(3,3,10,10));
		this.add(new JLabel());	this.add(new JLabel());	this.add(new JLabel());
		ChooseButton1  button1 = new  ChooseButton1();
		ChooseButton2  button2 = new ChooseButton2();
		this.add(button1);this.add(new JLabel());this.add(button2);
		this.add(new JLabel());	this.add(new JLabel());	this.add(new JLabel());
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AddDynamicUser();
				ChooseAddModel.setViseub(false);
				module.setVisible(false);
		}
		});
		
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AddStaticUer();
				module.setVisible(false);
			}
		});
		
	}
	/**
	 * 添加背景图片
	 */
	public void paintComponent(Graphics g) {  
        super.paintComponent(g);  
        //下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小  
        g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);  
	}  
}
class ChooseButton1 extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	boolean b = false;
	public ChooseButton1(){
		super("临时用户");
		this.setBounds(500/3, 270/3*2, 100, 50);
		//this.setSize(100, 50);
		this.setBorderPainted(true);
		this.setVisible(true);
	
	}
	public boolean result1(){
		return b;
	}
}
class ChooseButton2 extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean b = false;
	public ChooseButton2(){
		super("固定用户");
		this.setBounds(500/3, 270/3*2, 100, 50);
		//this.setSize(100, 50);
		this.setBorderPainted(true);
		this.setVisible(true);
	}
}
