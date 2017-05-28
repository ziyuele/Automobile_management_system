package com.qc.stetemIntro;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.BusinessBlueSteelSkin;
import org.jvnet.substance.theme.SubstanceTerracottaTheme;

import com.qc.dao.toDBa.ConnectToDBa;
import com.qc.mainFrame.LongIn.LogIn;

public class MainIntro {
	static ConnectToDBa dba = new ConnectToDBa();
	public static void main(String args[]){
		try {
            UIManager.setLookAndFeel(new SubstanceLookAndFeel());
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            SubstanceLookAndFeel.setCurrentTheme(new SubstanceTerracottaTheme());
         SubstanceLookAndFeel.setSkin(new  BusinessBlueSteelSkin());
   //       SubstanceLookAndFeel.setCurrentButtonShaper(new ClassicButtonShaper());
//          SubstanceLookAndFeel.setCurrentWatermark(new SubstanceBubblesWatermark());
   //      SubstanceLookAndFeel.setCurrentBorderPainter(new StandardBorderPainter());
//            SubstanceLookAndFeel.setCurrentGradientPainter(new StandardGradientPainter());
      //      SubstanceLookAndFeel.setCurrentTitlePainter(new FlatTitePainter());
        } catch (Exception e) {
            System.err.println("Something went wrong!");
        }
	
		//new com.qc.mainFrame.MainFrame().setVisible(true);
		LogIn log = new LogIn();
		log.setVisible(true);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread s = new Thread(new GetMes());
		s.start();
	}
}
class GetMes implements Runnable{
	public GetMes(){}
	@Override
	public void run(){
		new com.qc.hardware.ConnectToHardWare();
	}
}