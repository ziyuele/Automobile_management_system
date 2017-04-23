package com.qc.mainFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import com.qc.dao.model.StaticUSr;

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
		this.setTitle("��������ϵͳ->��Ϣ����");
		
		this.setLayout(new GridLayout(3,2));
		Container con =this.getContentPane();
		
		button1 = new MyButton("�û���ֵ");
		con.add(button1);
		button2 = new MyButton("�û���Ϣ����");
		con.add(button2);
		button3 = new MyButton("��ʾ�����û���Ϣ");
		con.add(button3);
		button4 = new MyButton("�Ʒ�ͳ��");
		con.add(button4);
		button5 = new MyButton("��Ϣ����");
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
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("please input the id");
				com.qc.mainFrame.MsgeMange.this.setVisible(false);
				new UsrUpdate();
			}
		});
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MsgeMange.this.setVisible(false);
				MainFrame.hsplit.setRightComponent(new RightERA1());
			}
		});
	}
}
/**
 * 
 * @author kangjianhome
 *  this massage is used to update the user messange from meanu button "��Ϣ����-->�û���Ϣ����"
 */
class UsrUpdate extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UsrUpdate(){
		
		this.setTitle("�û���Ϣ����");
		int height=540, width=1000;
		int widthh = Toolkit.getDefaultToolkit().getScreenSize().width;
		int heightt = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(widthh/2-width/2, heightt/2-height/2);
		this.setSize(width, height);
		JLabel usrName = new JLabel("�����û���:");
		JLabel newUsrName = new JLabel("���û��� :");
		JLabel carType = new JLabel("������ʽ:");
		JLabel document  = new JLabel("������Ϣ:");
		
		JButton button1 = new JButton("  ȡ��  ");
		JButton button2 = new JButton("  �ύ  ");
		
		JTextField fild1 = new JTextField(30);
		JTextField fild2 = new JTextField(30);
		JTextField fild3 = new JTextField(30);
		JTextArea fild4 = new JTextArea(6, 30);
		fild4.setLineWrap(true);// ������ݹ������Զ�����
		Container con = getContentPane();
		SpringLayout springLayout = new SpringLayout();
		this.setLayout(springLayout);
		//����ı�˵��   userName
		springLayout.putConstraint(SpringLayout.NORTH, usrName, 20, SpringLayout.NORTH,con);
		springLayout.putConstraint(SpringLayout.WEST, usrName,20, SpringLayout.WEST, con);
		
		//��Ӹ������ı���
		springLayout.putConstraint(SpringLayout.NORTH, fild1,20, SpringLayout.NORTH, con);
		springLayout.putConstraint(SpringLayout.WEST, fild1,70, SpringLayout.SOUTH, usrName);
		
		//����ı�˵��  newuUserName
		springLayout.putConstraint(SpringLayout.NORTH, newUsrName, 40, SpringLayout.NORTH,usrName);
		springLayout.putConstraint(SpringLayout.WEST, newUsrName,20, SpringLayout.WEST, con);
		
		//��Ӹ������ı���
		springLayout.putConstraint(SpringLayout.NORTH, fild2,40, SpringLayout.NORTH, usrName);
		springLayout.putConstraint(SpringLayout.WEST, fild2,70, SpringLayout.SOUTH, usrName);
		
		//���ĳ�������
		//����ı�˵��   cartype
		springLayout.putConstraint(SpringLayout.NORTH, carType, 40, SpringLayout.NORTH,newUsrName);
		springLayout.putConstraint(SpringLayout.WEST, carType,20, SpringLayout.WEST, con);
		
		//��Ӹ������ı���
		springLayout.putConstraint(SpringLayout.NORTH, fild3,40, SpringLayout.NORTH, newUsrName);
		springLayout.putConstraint(SpringLayout.WEST, fild3,70, SpringLayout.SOUTH, usrName);
		
		//����ı�˵��   cartype
		springLayout.putConstraint(SpringLayout.NORTH, document, 40, SpringLayout.NORTH,carType);
		springLayout.putConstraint(SpringLayout.WEST, document,20, SpringLayout.WEST, con);
		
		//��Ӹ������ı���
		springLayout.putConstraint(SpringLayout.NORTH, fild4,40, SpringLayout.NORTH, carType);
		springLayout.putConstraint(SpringLayout.WEST, fild4,70, SpringLayout.SOUTH, usrName);
		
		//��� button1   ȡ����ť
		springLayout.putConstraint(SpringLayout.NORTH, button1,150, SpringLayout.NORTH, fild4);
		springLayout.putConstraint(SpringLayout.WEST, button1,20, SpringLayout.WEST, fild4);
		
		//��� button2  �ύ��ť
		springLayout.putConstraint(SpringLayout.NORTH, button2,150, SpringLayout.NORTH, fild4);
		springLayout.putConstraint(SpringLayout.WEST, button2,200, SpringLayout.WEST, fild4);
		
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		fild1.addFocusListener(new FocusListener(){
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				//��ѯ���ݿ����Ƿ��и��û�
				StaticUSr usr = com.qc.dao.toDBa.ConnectToDBa.getStaitcPointUsr(fild1.getText());
				if(usr==null){
					//����1
					new Errorlog();
				}else{
					
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {	
				// TODO Auto-generated method stub
				
			}
		});
		
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fild1.setText("");
				fild2.setText("");
				fild3.setText("");
				fild4.setText("");
			}
		});
		
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = fild1.getText();
				String NewName = fild2.getText();
				String NewCarType = fild3.getText();
				String Msg = fild4.getText();
				
				ArrayList<String> updateList = new ArrayList<String>(); 
				updateList.add(NewName);
				updateList.add(name);
				updateList.add(NewCarType);
				updateList.add(Msg);
				com.qc.dao.toDBa.ConnectToDBa.updateUsrMsg(updateList);
			}
		});
		con.add(usrName); con.add(fild1);
		con.add(newUsrName);con.add(fild2);
		con.add(carType);con.add(fild3);
		con.add(document);con.add(fild4);
		con.add(button1);con.add(button2);
		this.setVisible(true);
	}
	
	
}
class ReFlush extends JFrame{
	/**
	 * this class is used to update user number
	 */
	private static final long serialVersionUID = 1L;

	public ReFlush(){
		
		this.setTitle("�û���ֵ");
		int height=540, width=1000;
		int widthh = Toolkit.getDefaultToolkit().getScreenSize().width;
		int heightt = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(widthh/2-width/2, heightt/2-height/2);
		this.setSize(width, height);
		
		JLabel name  = new JLabel("��ֵ�û�");
		JLabel cust = new JLabel("�����ֵ���");
		
		JTextField fild1 = new JTextField(30);
		JTextField fild2 = new JTextField(30);
		
		JButton casel = new JButton("����");
		JButton ok = new JButton("���");
		Pic pic = new Pic();
		MyButton button = new MyButton("ˢ��ȷ���û�");
		SpringLayout springLayout = new SpringLayout();
		Container con = getContentPane();
		con.setLayout(springLayout);
		//�ı�˵�� Dialog1
		springLayout.putConstraint(SpringLayout.NORTH, name, 20, SpringLayout.NORTH,con);
		springLayout.putConstraint(SpringLayout.WEST, name,20, SpringLayout.WEST, con);
		//�ı�������
		springLayout.putConstraint(SpringLayout.NORTH, fild1,20, SpringLayout.NORTH, con);
		springLayout.putConstraint(SpringLayout.WEST, fild1,70, SpringLayout.SOUTH, name);
		//�ı�˵��Dialog2
		springLayout.putConstraint(SpringLayout.NORTH, cust, 20, SpringLayout.SOUTH,fild1);
		springLayout.putConstraint(SpringLayout.WEST, cust,20, SpringLayout.WEST, con);
		//�ı�������
		springLayout.putConstraint(SpringLayout.NORTH, fild2,20, SpringLayout.SOUTH, fild1);
		springLayout.putConstraint(SpringLayout.WEST, fild2,70, SpringLayout.SOUTH, name);
		//ȷ�ϰ�ť
		springLayout.putConstraint(SpringLayout.NORTH,ok,30,SpringLayout.SOUTH,fild2);
		springLayout.putConstraint(SpringLayout.EAST,ok,0,SpringLayout.EAST,fild2);
		//ȡ����ť
		springLayout.putConstraint(SpringLayout.NORTH,casel,30,SpringLayout.SOUTH,fild2);
		springLayout.putConstraint(SpringLayout.EAST,casel,-30,SpringLayout.WEST,ok);
		//ʹ��ˢ����ť
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
	private JButton button = new JButton("ȷ��");
	private JLabel label = new JLabel("������Ϣ������ȷ�Ϻ����룡");
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
	        //����������Ϊ�˱���ͼƬ���Ը��洰�����е�����С�������Լ����óɹ̶���С  
	        g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);  
	    }  
	
}
