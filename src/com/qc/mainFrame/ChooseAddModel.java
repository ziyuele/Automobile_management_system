package com.qc.mainFrame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class ChooseAddModel extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ChooseAddModel(){
		
		
		this.setBackground(Color.GREEN);
		int height=270, width=500;
		int widthh = Toolkit.getDefaultToolkit().getScreenSize().width;
		int heightt = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(widthh/2-width/2, heightt/2-height/2);
		this.setSize(width, height);
		this.setTitle("选择创建的用户类型");
		this.setLayout(new GridLayout(3,3,10,10));
		this.add(new JLabel());	this.add(new JLabel());	this.add(new JLabel());
		ChooseButton1  button1 = new  ChooseButton1();
		ChooseButton2  button2 = new ChooseButton2();
		this.add(button1);this.add(new JLabel());this.add(button2);
		this.add(new JLabel());	this.add(new JLabel());	this.add(new JLabel());
		//设置图像尺寸不可更改
		this.setResizable(false);
		this.setSize(width, height);
		//this.add(new ChooseButton1());
		//this.add(new ChooseButton2());
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AddDynamicUser();
				ChooseAddModel.this.setVisible(false);
			}
		});
		
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AddStaticUer();
				ChooseAddModel.this.setVisible(false);
			}
		});
		this.setVisible(true);
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
