package tests.geral;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Lacaio {
	public Timer timer;
	private int i;
	
	public Lacaio()  {
		javax.swing.Timer t = new javax.swing.Timer(1000,new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	System.out.println("ok");
//	            Calendar cal = new GregorianCalendar();
//	            String hour = String.valueOf(cal.get(Calendar.HOUR));
//	            String minute = String.valueOf(cal.get(Calendar.MINUTE));
//	            String second = String.valueOf(cal.get(Calendar.SECOND));
//	            timeField.setText("" + hour + ":" + minute + ":" + second);
//	            System.out.println("ok");
	            }
	        });
	        t.start(); 
	}
	
	public static void main(String[] args) {
		Lacaio lucas = new Lacaio();
	}
}
