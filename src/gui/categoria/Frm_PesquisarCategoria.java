package gui.categoria;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Frm_PesquisarCategoria extends JFrame {
	private static final long serialVersionUID = 1L;

	public Frm_PesquisarCategoria() {
		super("Sapien - Pesquisar Categoria");
		setLocationRelativeTo(null);
		setResizable(false);
		setPreferredSize(new Dimension(390, 180));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(new Pnl_PesquisarCategoria(), BorderLayout.CENTER);
		pack();
	}

}
