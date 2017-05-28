package com.qc.mainFrame;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ButtonFrame extends JLabel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon icon;
	private Image img;
	public ButtonFrame(){
		icon = new ImageIcon("imge/car.png");
        img=icon.getImage();
        this.setIcon(icon);
	}
}
