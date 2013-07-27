package tests.geral;

import javax.swing.JFrame;  
import javax.swing.JPanel;  
import javax.swing.JTabbedPane;  
  
public class TesteJTabbedPane extends JFrame {  
  
    public TesteJTabbedPane() {  
        setTitle("Usando TabbedPane");  
        setSize(800,600);  
          
        JTabbedPane pane = new JTabbedPane();  
        pane.add(new JPanel(), "1 Panel");  
        pane.add(new JPanel(), "2 Panel");  
        pane.add(new JPanel(), "3 Panel");  
          
        add(pane);  
    }  
  
    public static void main(String args[]) {  
    	TesteJTabbedPane janela = new TesteJTabbedPane();  
        janela.setVisible(true);  
    }  
}  