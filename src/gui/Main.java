package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;

	private MenuBar menu;

	public Main() {
		super("Foco Marcial");
		setLocationRelativeTo(null);
		setResizable(false);
		setPreferredSize(new Dimension(490, 480));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Menu
		menu = new MenuBar();
		setJMenuBar(menu);
		
		// Inserindo panels
		getContentPane().add(new PainelCentral(), BorderLayout.CENTER);
		getContentPane().add(new PainelSul(), BorderLayout.SOUTH);


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
