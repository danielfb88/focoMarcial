package gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private MenuBarPrincipal menu;

	public Main() {
		super("Sapien");
		setLocationRelativeTo(null);
		setResizable(false);
		setPreferredSize(new Dimension(390, 180));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Menu
		menu = new MenuBarPrincipal();
		setJMenuBar(menu);

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
