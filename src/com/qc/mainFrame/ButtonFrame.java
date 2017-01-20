package com.qc.mainFrame;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ButtonFrame extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon icon;
	private Image img;
	public ButtonFrame(){
		icon = new ImageIcon("imge/car.png");
        img=icon.getImage();  
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		  g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);  
	}
}
