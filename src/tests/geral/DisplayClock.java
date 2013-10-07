package tests.geral;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLabel;

public class DisplayClock extends JFrame {
	
     DisplayClock() {
//        final JLabel timeField = new JLabel();
//        timeField.setFont(new Font("sansserif", Font.PLAIN, 20));
//
//        Container content = this.getContentPane();
//        content.setLayout(new FlowLayout());
//        content.add(timeField); 
//
//        setTitle("Clock");
//        setSize(100,70);

        javax.swing.Timer t = new javax.swing.Timer(2000,new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	System.out.println("ok");
//            Calendar cal = new GregorianCalendar();
//            String hour = String.valueOf(cal.get(Calendar.HOUR));
//            String minute = String.valueOf(cal.get(Calendar.MINUTE));
//            String second = String.valueOf(cal.get(Calendar.SECOND));
//            timeField.setText("" + hour + ":" + minute + ":" + second);
//            System.out.println("ok");
            }
        });
        t.start(); 
    }
    public static void main(String[] args) {
        JFrame clock = new DisplayClock();
        clock.setVisible(true);
    }
}