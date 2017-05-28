package com.qc.mainFrame.LongIn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.qc.dao.toDBa.ConnectToDBa;

@SuppressWarnings("serial")
public class LogIn extends JFrame{
	private String user;
	private String passw;
	
	public LogIn(){
		
		int height=265, width=400;
		this.setTitle("��������ϵͳ");
		int widthh = Toolkit.getDefaultToolkit().getScreenSize().width;
		int heightt = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(widthh/2-width/2, heightt/2-height/2);
		this.setSize(width, height);
		this.setFont(new Font("��Բ",Font.BOLD,40));
		this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//this.setLayout(new GridLayout(3,1));
		JPanel jp1 = new JPanel();
		JLabel jl1 = new JLabel(new ImageIcon("imge/login.png"));
		
		JPanel jp2 = new JPanel(new GridLayout(3,3,5,5));
		//jp2.setBackground(new Color(78, 139, 202));
		JLabel jl2 = new JLabel("�û�����",JLabel.CENTER);
		JLabel jl3 = new JLabel("����",JLabel.CENTER);	
		JTextField jte = new JTextField();	
		JPasswordField  pasw= new JPasswordField();
		JButton button = new JButton("�������");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jte.setText("");
				pasw.setText("");
			}	
		});
		
		
		JLabel jl4 = new JLabel("<html> <a href ='www.baidu.com'>��������</a></html>",
				JLabel.CENTER);
		jl4.setFont(new Font("��Բ",Font.BOLD,13));		
		JCheckBox check1 = new JCheckBox("�����û���");
		check1.setFont(new Font("����",Font.BOLD,13));
		JCheckBox check2 = new JCheckBox("��ס����");
		check2.setFont(new Font("����",Font.BOLD,13));
		JLabel jb = new JLabel("",JLabel.CENTER);
		
		
		JPanel jp3 = new JPanel(new FlowLayout());
		//jp3.setBackground(new Color(78, 139, 202));
		JButton jb31 = new JButton("��¼");
		jb31.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				user = jte.getText();
				passw = pasw.getText();
				//System.out.println(user+" "+passw);
				check(1);
				
			}
		});
	
		JButton jb32 = new JButton("ȡ��");
		JButton jb33 = new JButton("ʹ����");
		
		jp1.add(jl1);
		
		jp2.add(jl2);	jp2.add(jte);	jp2.add(button);
		jp2.add(jl3);	jp2.add(pasw);	jp2.add(jl4);
		jp2.add(check1);jp2.add(jb);	jp2.add(check2);
		
		jp3.add(jb31);	jp3.add(jb32); jp3.add(jb33);
		Container con = getContentPane();
		con.add(jp1,BorderLayout.NORTH);
		con.add(jp2,BorderLayout.CENTER);
		con.add(jp3,BorderLayout.SOUTH);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	private void check(int x){
		new com.qc.mainFrame.MainFrame().setVisible(true);
		LogIn.this.setVisible(false);
		
	}
	@SuppressWarnings("unused")
	private void check(){
		//MainIntro.getConnectToDBa();
		String dbaAdmin = ConnectToDBa.getAdministrators();
		String dabPass  = ConnectToDBa.getpassword();
		if(user.equals(dbaAdmin)){
			if(passw.equals(dabPass)){
				new com.qc.mainFrame.MainFrame().setVisible(true);
				LogIn.this.setVisible(false);
			}else{
				
			}
		}
	}
}
