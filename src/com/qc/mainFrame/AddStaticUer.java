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

import com.qc.dao.model.StaticUSr;
import com.qc.hardware.ConnectToHardWare;

public class AddStaticUer extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width = 900, height = 300;	
	public AddStaticUer(){
		int widthh = Toolkit.getDefaultToolkit().getScreenSize().width;
		int heightt = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(widthh/2-width/2, heightt/2-height/2);
		this.setSize(width, height);
		this.setTitle("��ӹ̶��û�");
		this.add(new myPanel1());
		this.setVisible(true);
	}
}
class myPanel1 extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ImageIcon icon;  
    Image img;  
    
	private JButton jb,JB1;
	private JTextField jt1 = new JTextField(30);
	private JTextField jt2 = new JTextField(30);
	private JTextField jt3 = new JTextField(30);
	private JTextField jt4 = new JTextField(30);
	public myPanel1(){
		
		
		icon = new ImageIcon("imge/MianFrame.png");
        img=icon.getImage();  
        
        
		this.setLayout(new GridLayout(5,2,50,10));
		
		JLabel name = new JLabel("�û���",JLabel.RIGHT);
		JPanel Name = new JPanel();
		
		JLabel car_type = new JLabel("����",JLabel.RIGHT);
		JPanel Car_type = new JPanel();
		
		JLabel base_Fee = new JLabel("������",JLabel.RIGHT);
		JPanel Base_Fee = new JPanel();
		
		jb = new JButton("��Ϣ¼���ˢ��");
		JB1 = new JButton("����¼��");
		Name.add(jt1,JPanel.LEFT_ALIGNMENT);
		Car_type.add(jt3,JPanel.LEFT_ALIGNMENT);
		Base_Fee.add(jt4,JPanel.LEFT_ALIGNMENT);
		
		this.add(name); this.add(Name);
		this.add(car_type);this.add(Car_type);
		this.add(base_Fee);this.add(Base_Fee);
		
		this.add(jb);this.add(JB1);
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					String name = jt1.getText();
					String car_type = jt3.getText();
					int basefee =Integer.decode(jt4.getText());
					
					StaticUSr  statusr = new StaticUSr();
					statusr.setBase_Fee(basefee);
					statusr.setName(name);
					statusr.setCar_type(car_type);
					while(ConnectToHardWare.getFlag()==false){
						ConnectToHardWare.setFlag(true);
					}
					
					com.qc.dao.toDBa.ConnectToDBa.addStatic(statusr,jb);
					ConnectToHardWare.setUiD();
					while(ConnectToHardWare.getFlag()==true){
						ConnectToHardWare.setFlag(false);
					}
				}catch(Exception e1){
					while(ConnectToHardWare.getFlag()==true){
						ConnectToHardWare.setFlag(false);
					}
					new mMessage("��Ϣ����������¼�룡");
					jb.setText("ȷ��");
					e1.printStackTrace();
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
				jt4.setText("");
			}
		});
	}
//	   public void paintComponent(Graphics g) {  
//	        super.paintComponent(g);  
//	        //����������Ϊ�˱���ͼƬ���Ը��洰�����е�����С�������Լ����óɹ̶���С  
//	        g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);  
//	   }  
//	
}