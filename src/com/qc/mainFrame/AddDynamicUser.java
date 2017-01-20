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

import com.qc.dao.model.DynamicUsr;


public class AddDynamicUser extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width = 900, height = 600;
	JTextField jt1 = new JTextField(30);
	JTextField jt2 = new JTextField(30);
	JTextField jt3 = new JTextField(30);
	public AddDynamicUser(){
		int widthh = Toolkit.getDefaultToolkit().getScreenSize().width;
		int heightt = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(widthh/2-width/2, heightt/2-height/2);
		this.setSize(width, height);
		this.setTitle("�����ʱ�û�");
		
		Container con  = this.getContentPane();
		con.setLayout(new GridLayout(4,2,50,10));
		JLabel id = new JLabel("ID",JLabel.RIGHT);
		JPanel ID = new JPanel();
		
		JLabel car_type = new JLabel("����",JLabel.RIGHT);
		JPanel Car_type = new JPanel();
		
		JLabel base_Fee = new JLabel("������",JLabel.RIGHT);
		JPanel Base_Fee = new JPanel();
		
		JButton jb = new JButton("���");
		JButton JB1 = new JButton("����¼��");
		
		ID.add(jt1,JPanel.LEFT_ALIGNMENT);
		Car_type.add(jt2,JPanel.LEFT_ALIGNMENT);
		Base_Fee.add(jt3,JPanel.LEFT_ALIGNMENT);
		
	
		con.add(id);con.add(ID);
		con.add(car_type);con.add(Car_type);
		con.add(base_Fee);con.add(Base_Fee);
		con.add(jb);con.add(JB1);
		//���Ǹ�����ķ���
		this.pack();
		this.setVisible(true);
		
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int base_Fee=0;
				int ID = 0;
				String s1 = jt1.getText();
				String s2 = jt2.getText();
				String s3 = jt3.getText();
				
				if(s1.equals("")||s2.equals("")||s3.equals("")){
					return;
				}
				
				ID = Integer.decode(s1);
				base_Fee = Integer.decode(s3);
				
				DynamicUsr dynamic = new DynamicUsr();
				dynamic.setBase_Fee(base_Fee);
				dynamic.setCar_type(s2);
				dynamic.setID(ID);
				
				com.qc.dao.toDBa.ConnectToDBa.AddDynamicUser(dynamic);
			}
		});
		JB1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jt1.setText("");
				jt2.setText("");
				jt3.setText("");
			}
		});
	}
}