package com.qc.mainFrame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Button1 extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3406346966404081531L;
	 ImageIcon icon = new ImageIcon("imge/button.png");
	public Button1(String s){
		super(s);
		this.setContentAreaFilled(false);
		this.setHorizontalTextPosition(SwingConstants.CENTER); 
		this.setSelectedIcon(new ImageIcon("imge/icon1.png"));
		this.setSize(20, 20);
		this.setIcon(icon);
		
	}
	public Button1(){
		super();
	}

}
