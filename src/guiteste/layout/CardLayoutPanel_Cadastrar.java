package guiteste.layout;

import guiteste.categoria.Pnl_AdicionarCategoria;
import guiteste.informacao.JPanelCadastrarInformacao;

import java.awt.CardLayout;

import javax.swing.JPanel;

/**
 * JPanel que conterá outros Panels sobrepostos utilizando o CardLayout
 * 
 */
public class CardLayoutPanel_Cadastrar extends JPanel {
	private static final long serialVersionUID = 1L;

	public CardLayoutPanel_Cadastrar() {
		init();
	}

	private void init() {
		setLayout(new CardLayout());

		JPanel panel = null;

		panel = new Pnl_AdicionarCategoria();
		panel.setName("cadastrarCategoria");
		add(panel, panel.getName());

		panel = new JPanelCadastrarInformacao();
		panel.setName("cadastrarIformacao");
		add(panel, panel.getName());
	}

}
