package gui;

import gui.menu.MenuBar;
import gui.panels.PanelCentral;
import gui.panels.PanelSul;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import ddd.ArteMarcial;
import ddd.Faixa;
import ddd.Movimento;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private List<Faixa> faixas;

	private MenuBar menu;
	private JPanel panelCentral;
	private JPanel panelSul;
	
	private Dimension dimension = new Dimension(590, 480);
	
	public Main() {
		super("Foco Marcial");
		
		setLocationRelativeTo(null);
		setResizable(false);
		setPreferredSize(dimension);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		faixas = new ArteMarcial(1).getTodasAsFaixas();
		

		// Menu
		menu = new MenuBar();
		setJMenuBar(menu);
		
		panelCentral = new PanelCentral(new Dimension(dimension.width - 15, dimension.height - 95), faixas);
		panelSul = new PanelSul(new Dimension(dimension.width, 75));
		
		// Inserindo panels
		getContentPane().add(panelCentral, BorderLayout.CENTER);
		getContentPane().add(panelSul, BorderLayout.SOUTH);
		
		pack();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Main main = new Main();
				main.setVisible(true);
			}
		});
	}

}
