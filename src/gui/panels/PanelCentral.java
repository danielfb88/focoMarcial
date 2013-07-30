package gui.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import ddd.Faixa;
import ddd.Movimento;

public class PanelCentral extends JPanel {
	private static final long serialVersionUID = 1L;

	private List<Faixa> faixas;
	private List<Map<String, Object[][]>> listElementos = new ArrayList<Map<String, Object[][]>>();

	private JTabbedPane tabbedFaixas;

	public PanelCentral(Dimension dimension, List<Faixa> faixas) {
		setBackground(Color.DARK_GRAY);

		this.faixas = faixas;
		montarTabbedPanel(dimension);
	}

	/**
	 * Monta JTabbedPanel de acordo com informações vindas do banco
	 * 
	 * @param dimension
	 */
	private void montarTabbedPanel(Dimension dimension) {
		tabbedFaixas = new JTabbedPane(JTabbedPane.TOP,
				JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedFaixas.setPreferredSize(new Dimension(dimension.width - 10,
				dimension.height - 10));

		for (Faixa faixa : faixas) {

			// Labels de Título da coluna
			JLabel labelMovimento = new JLabel("Movimento");
			JLabel labelQuantidade = new JLabel("Nº");
			JLabel labelIntervalo = new JLabel("T(s)");
			JLabel labelGolpe = new JLabel("Golpe");
			JLabel labelvozPath = new JLabel("Comando de voz");

			JPanel tabPanel = new JPanel();
			tabPanel.setPreferredSize(new Dimension(dimension.width - 40,
					dimension.height - 20));

			JPanel conteudoPanel = new JPanel();
			conteudoPanel.setLayout(new GridBagLayout());

			GridBagConstraints c = new GridBagConstraints();

			JScrollPane scrollPane = new JScrollPane(tabPanel);
			// scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

			// Layout do Conteudo Panel
			c.fill = GridBagConstraints.HORIZONTAL; // natural height, maximum
													// width
			c.weightx = 0.5;
			c.anchor = GridBagConstraints.PAGE_START; // bottom of space
			c.gridwidth = 3; // 3 columns wide
			c.gridx = 0;
			c.gridy = 0;
			c.insets = new Insets(5, 5, 0, 5); // top padding
			// c.ipady = 0; // reset to default

			conteudoPanel.add(labelMovimento, c);

			c.fill = GridBagConstraints.HORIZONTAL; // natural height, maximum
													// width
			c.weightx = 0.5;
			c.anchor = GridBagConstraints.PAGE_START; // bottom of space
			c.gridwidth = 1; // 1 columns wide
			c.gridx = 3;
			c.gridy = 0;
			c.insets = new Insets(5, 5, 0, 5); // top padding

			conteudoPanel.add(labelQuantidade, c);

			c.fill = GridBagConstraints.HORIZONTAL; // natural height, maximum
													// width
			c.weightx = 0.5;
			c.anchor = GridBagConstraints.PAGE_START; // bottom of space
			c.gridwidth = 1; // 1 columns wide
			c.gridx = 4;
			c.gridy = 0;
			c.insets = new Insets(5, 5, 0, 5); // top padding

			conteudoPanel.add(labelIntervalo, c);

			c.fill = GridBagConstraints.HORIZONTAL; // natural height, maximum
													// width
			c.weightx = 0.5;
			c.anchor = GridBagConstraints.PAGE_START; // bottom of space
			c.gridwidth = 1; // 1 columns wide
			c.gridx = 5;
			c.gridy = 0;
			c.insets = new Insets(5, 5, 0, 5); // top padding

			conteudoPanel.add(labelGolpe, c);

			c.fill = GridBagConstraints.HORIZONTAL; // natural height, maximum
													// width
			c.weightx = 0.5;
			c.anchor = GridBagConstraints.PAGE_START; // bottom of space
			c.gridwidth = 2; // 1 columns wide
			c.gridx = 6;
			c.gridy = 0;
			c.insets = new Insets(5, 5, 0, 5); // top padding

			conteudoPanel.add(labelvozPath, c);

			int i = 1;
			List<Movimento> movimentos = faixa.getMovimentos();
			for (Movimento movimento : movimentos) {

				// Criando Elementos
				JLabel labelDescricaoMovimento = new JLabel(
						movimento.getDescricao());
				
				JTextField jtxQuantidade = new JTextField(
						String.valueOf(movimento.getQtdRepeticao()));

				JTextField jtxIntervaloSegundos = new JTextField(
						String.valueOf(movimento.getIntervaloSegundos()));

				JCheckBox jcbGolpe = new JCheckBox("",
						(movimento.getEh_golpe() == 1 ? true : false));

				JTextField jtxVozPath = new JTextField(movimento.getVoz_path());
				jtxVozPath.setPreferredSize(new Dimension(200, 20));

				// Inserindo os elementos em uma lista
				Map<String, Object[][]> mapFaixa = new HashMap<String, Object[][]>();
				Object[][] arrElementos = new Object[6][2];
				
				arrElementos[0][0] = "intId";
				arrElementos[0][1] = movimento.getId();

				arrElementos[1][0] = "strMovimento";
				arrElementos[1][1] = movimento.getDescricao();

				arrElementos[2][0] = "jtxQuantidade";
				arrElementos[2][1] = jtxQuantidade;

				arrElementos[3][0] = "jtxIntervaloSegundos";
				arrElementos[3][1] = jtxIntervaloSegundos;

				arrElementos[4][0] = "jtxVozPath";
				arrElementos[4][1] = jtxVozPath;
				
				arrElementos[5][0] = "jcbGolpe";
				arrElementos[5][1] = jcbGolpe;


				mapFaixa.put(faixa.getDescricao(), arrElementos);

				// Adicionando elementos mapeados à lista
				listElementos.add(mapFaixa);

				c.fill = GridBagConstraints.HORIZONTAL; // natural height,
														// maximum width
				c.weightx = 0.5;
				// c.anchor = GridBagConstraints.PAGE_START; // bottom of space
				c.gridwidth = 3; // 3 columns wide
				c.gridx = 0;
				c.gridy = i;
				c.insets = new Insets(5, 5, 0, 5); // top padding

				conteudoPanel.add(labelDescricaoMovimento, c);

				c.fill = GridBagConstraints.HORIZONTAL; // natural height,
														// maximum width
				c.weightx = 0.5;
				// c.anchor = GridBagConstraints.PAGE_START; // bottom of space
				c.gridwidth = 1; // 3 columns wide
				c.gridx = 3;
				c.gridy = i;
				c.insets = new Insets(5, 5, 0, 5); // top padding

				conteudoPanel.add(jtxQuantidade, c);

				c.fill = GridBagConstraints.HORIZONTAL; // natural height,
														// maximum width
				c.weightx = 0.5;
				// c.anchor = GridBagConstraints.PAGE_START; // bottom of space
				c.gridwidth = 1; // 3 columns wide
				c.gridx = 4;
				c.gridy = i;
				c.insets = new Insets(5, 5, 0, 5); // top padding

				conteudoPanel.add(jtxIntervaloSegundos, c);

				c.fill = GridBagConstraints.HORIZONTAL; // natural height,
														// maximum width
				c.weightx = 0.5;
				// c.anchor = GridBagConstraints.PAGE_START; // bottom of space
				c.gridwidth = 1; // 3 columns wide
				c.gridx = 5;
				c.gridy = i;
				c.insets = new Insets(5, 5, 0, 5); // top padding

				conteudoPanel.add(jcbGolpe, c);

				c.fill = GridBagConstraints.HORIZONTAL; // natural height,
														// maximum width
				c.weightx = 0.5;
				// c.anchor = GridBagConstraints.PAGE_START; // bottom of space
				c.gridwidth = 2; // 3 columns wide
				c.gridx = 6;
				c.gridy = i;
				c.insets = new Insets(5, 5, 0, 5); // top padding

				conteudoPanel.add(jtxVozPath, c);

				i++;
			}

			tabPanel.add(conteudoPanel);
			tabbedFaixas.add(faixa.getDescricao(), scrollPane);

		}

		this.add(tabbedFaixas);
	}

	/**
	 * Retornar a lista de faixas com os valores já editados para serem
	 * persistidos
	 * 
	 * @return
	 */
	public List<Faixa> getFaixas() {
		List<Faixa> faixasEditadas = this.faixas;

		// Iterando a faixa
		for (Faixa faixa : faixasEditadas) {

			// Iterando a lista de elementos
			for (Map<String, Object[][]> mapElemento : listElementos) {
				if (mapElemento.containsKey(faixa.getDescricao())) {

					Object[][] arrElementosMovimento = mapElemento.get(faixa.getDescricao());

					int idMovimento = (int) arrElementosMovimento[0][1];
//					String nomeMovimento = (String) arrElementosMovimento[1][1];
					JTextField jtxQtdRepeticao = (JTextField) arrElementosMovimento[2][1];
					JTextField jtxIntervaloSegundos = (JTextField) arrElementosMovimento[3][1];
					JTextField jtxVozPath = (JTextField) arrElementosMovimento[4][1];
					JCheckBox jcbGolpe = (JCheckBox) arrElementosMovimento[5][1];

					// Iterando a lista de movimentos
					List<Movimento> movimentos = faixa.getMovimentos();
					for (Movimento movimento : movimentos) {

						/**
						 * Alterando: + Numero de Repetições + Intervalo em
						 * segundos + isGolpe + vozPath
						 */
						if (movimento.getId() == idMovimento) {
							movimento.setQtdRepeticao(Integer.parseInt(jtxQtdRepeticao.getText()));
							movimento.setIntervaloSegundos(Integer.parseInt(jtxIntervaloSegundos.getText()));
							movimento.setEh_golpe(jcbGolpe.isSelected() ? 1 : 0);
							movimento.setVoz_path(jtxVozPath.getText());

							break;
						}
					}

				}
			}

		}

		return faixasEditadas;
	}

}
