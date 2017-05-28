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
import com.qc.hardware.ConnectToHardWare;


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
		JLabel id = new JLabel("�û�",JLabel.RIGHT);
		JPanel ID = new JPanel();
		
		JLabel car_type = new JLabel("����",JLabel.RIGHT);
		JPanel Car_type = new JPanel();
		
		JLabel base_Fee = new JLabel("������",JLabel.RIGHT);
		JPanel Base_Fee = new JPanel();
		
		JButton jb = new JButton("ȷ����Ϣ¼��ˢ��");
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
				try{
					String name = jt1.getText();
					String car_type = jt2.getText();
					int basefee = Integer.decode(jt3.getText());
					
					DynamicUsr dynamic = new DynamicUsr();
					dynamic.setBase_Fee(basefee);
					dynamic.setCar_type(car_type);
					dynamic.setName(name);
					while(ConnectToHardWare.getFlag()==false){
						ConnectToHardWare.setFlag(true);
					}
					com.qc.dao.toDBa.ConnectToDBa.AddDynamicUser(dynamic,jb);
					ConnectToHardWare.setUiD();
					while(ConnectToHardWare.getFlag()==true){
						ConnectToHardWare.setFlag(false);
					}
				}catch(Exception e1){
					new mMessage("������Ϣ������˶Ժ����룡");
				}
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