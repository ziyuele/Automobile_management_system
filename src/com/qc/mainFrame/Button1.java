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
		//this.setHorizontalTextPosition(SwingConstants.CENTER); 
		//this.setSize(20, 20);
		//this.setIcon(icon);
		
	}
	public Button1(){
		super();
	}

}
