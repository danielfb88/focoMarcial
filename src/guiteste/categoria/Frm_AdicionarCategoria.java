package guiteste.categoria;

import javax.swing.JFrame;

public class Frm_AdicionarCategoria extends JFrame {
	private static final long serialVersionUID = 1L;

	public Frm_AdicionarCategoria() {
		super("Sapien - Adicionar Categoria");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setContentPane(new Pnl_AdicionarCategoria());
		pack();
	}

}
