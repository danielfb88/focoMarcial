package guiteste.categoria;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Pnl_PesquisarCategoria extends JPanel {
	private static final long serialVersionUID = 1L;

	private JTextField tx_pesquisar;

	public Pnl_PesquisarCategoria() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout());
		init();
	}

	// TODO:ELEMENTO DEVE SER PREPARADO DENTRO DE UM PANEL. É TRABALHOSO
	// MAS O RESULTADO VALE A PENA
	private void init() {
		String[] colunas = new String[] { "Estado", "Cidade" };
		String[][] dados = new String[][] {
				{ "SP", "Sao Paulo" },
				{ "RJ", "Rio de Janeiro" },
				{ "RN", "Rio Grande do Norte" },
				{ "PR", "Parana" }
		};

		JTable jtable = new JTable(dados, colunas);
		// jtable.setPreferredSize(new Dimension(100, 100));

		tx_pesquisar = new JTextField();
		tx_pesquisar.setPreferredSize(new Dimension(100, 20));

		JPanel pnl_pesquisar = new JPanel();
		pnl_pesquisar.setLayout(new FlowLayout());
		pnl_pesquisar.add(tx_pesquisar);

		add(pnl_pesquisar, BorderLayout.NORTH);
		add(jtable, BorderLayout.CENTER);

		add(new JPanel(), BorderLayout.EAST);
		add(new JPanel(), BorderLayout.WEST);
	}

}
