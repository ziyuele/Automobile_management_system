package com.qc.mainFrame;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.qc.dao.model.StaticUSr;

public class AddStaticUer extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton jb,JB1;
	private int width = 900, height = 600;
	private JTextField jt1 = new JTextField(30);
	private JTextField jt2 = new JTextField(30);
	private JTextField jt3 = new JTextField(30);
	private JTextField jt4 = new JTextField(30);
	public AddStaticUer(){
		int widthh = Toolkit.getDefaultToolkit().getScreenSize().width;
		int heightt = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(widthh/2-width/2, heightt/2-height/2);
		this.setSize(width, height);
		this.setTitle("添加固定用户");
		
		Container con  = this.getContentPane();
		con.setLayout(new GridLayout(5,2,50,10));
		
		JLabel name = new JLabel("用户名",JLabel.RIGHT);
		JPanel Name = new JPanel();
		
		JLabel id = new JLabel("ID",JLabel.RIGHT);
		JPanel ID = new JPanel();
		
		JLabel car_type = new JLabel("车型",JLabel.RIGHT);
		JPanel Car_type = new JPanel();
		
		JLabel base_Fee = new JLabel("基本费",JLabel.RIGHT);
		JPanel Base_Fee = new JPanel();
		
		jb = new JButton("添加");
		JB1 = new JButton("重新录入");
		
		Name.add(jt1,JPanel.LEFT_ALIGNMENT);
		ID.add(jt2,JPanel.LEFT_ALIGNMENT);
		Car_type.add(jt3,JPanel.LEFT_ALIGNMENT);
		Base_Fee.add(jt4,JPanel.LEFT_ALIGNMENT);
		
		con.add(name); con.add(Name);
		con.add(id);con.add(ID);
		con.add(car_type);con.add(Car_type);
		con.add(base_Fee);con.add(Base_Fee);
		
		con.add(jb);con.add(JB1);
		this.pack();
		this.setVisible(true);
		
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = jt1.getText();
				int id =Integer.decode(jt2.getText());
				String car_type = jt3.getText();
				float basefee =Integer.decode(jt4.getText());
				
				StaticUSr  statusr = new StaticUSr();
				statusr.setBase_Fee(basefee);
				statusr.setName(name);
				statusr.setID(id);
				statusr.setCar_type(car_type);
				
				com.qc.dao.toDBa.ConnectToDBa.addStatic(statusr);
				
			}
		});
		JB1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jt1.setText("");
				jt2.setText("");
				jt3.setText("");
				jt4.setText("");
			}
		});
	}
	
}
