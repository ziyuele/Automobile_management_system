package com.qc.mainFrame;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MeanuBar {
	private static JMenuBar  menubar = new JMenuBar();
	public JMenuBar getMenuBar(){
		return menubar;
	}
	
	
	public MeanuBar(){
		MeanuBar.menubar.add(new JMenu("²Ëµ¥"));
	}
}
