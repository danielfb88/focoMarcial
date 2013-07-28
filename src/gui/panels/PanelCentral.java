package gui.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import ddd.Faixa;
import ddd.Movimento;

public class PanelCentral extends JPanel {
	private static final long serialVersionUID = 1L;

	private List<Faixa> faixas;
	
	/**
	 * List
	 * 	 |---> Map 
	 * 			|-----> String: Nome do Movimento
	 * 			|-----> Array[2]: HashMap
	 */
	private List<Map<String, Map<String, JTextField>[]>> listElementos = new ArrayList<Map<String, Map<String, JTextField>[]>>();
	
	private JTabbedPane tabbedFaixas;

	public PanelCentral(Dimension dimension, List<Faixa> faixas) {
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(dimension.width - 5, dimension.height - 5));
		
		this.faixas = faixas;
		montarTabbedPanel(dimension);
	}
	
	/**
	 * Monta JTabbedPanel de acordo com informações vindas do banco
	 * @param dimension
	 */
	private void montarTabbedPanel(Dimension dimension) {
		tabbedFaixas = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedFaixas.setPreferredSize(new Dimension(dimension.width - 10, dimension.height - 10));
		
		
		for (Faixa faixa : faixas) {
			
			// Labels de Título da coluna
			JLabel labelMovimento = new JLabel("Movimento");
			JLabel labelQuantidade = new JLabel("Nº");
			JLabel labelIntervalo = new JLabel("T(s)");

			JPanel tabPanel = new JPanel();
			tabPanel.setPreferredSize(new Dimension(dimension.width - 40, dimension.height - 20));
			
			JPanel conteudoPanel = new JPanel();
			conteudoPanel.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			
			JScrollPane scrollPane = new JScrollPane(tabPanel);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			
			// Layout do Conteudo Panel
			c.fill = GridBagConstraints.HORIZONTAL; 	// natural height, maximum width
			c.weightx = 0.5;
			c.anchor = GridBagConstraints.PAGE_START; // bottom of space
			c.gridwidth = 3; // 3 columns wide
			c.gridx = 0;
			c.gridy = 0;
			c.insets = new Insets(5, 5, 0, 5); // top padding
//			c.ipady = 0; // reset to default
			
			conteudoPanel.add(labelMovimento, c);
			
			c.fill = GridBagConstraints.HORIZONTAL; 	// natural height, maximum width
			c.weightx = 0.5;
			c.anchor = GridBagConstraints.PAGE_START; // bottom of space
			c.gridwidth = 1; // 1 columns wide
			c.gridx = 3;
			c.gridy = 0;
			c.insets = new Insets(5, 5, 0, 5); // top padding
			
			conteudoPanel.add(labelQuantidade, c);
			
			c.fill = GridBagConstraints.HORIZONTAL; 	// natural height, maximum width
			c.weightx = 0.5;
			c.anchor = GridBagConstraints.PAGE_START; // bottom of space
			c.gridwidth = 1; // 1 columns wide
			c.gridx = 4;
			c.gridy = 0;
			c.insets = new Insets(5, 5, 0, 5); // top padding
			
			conteudoPanel.add(labelIntervalo, c);
			
			int i = 1;
			List<Movimento> movimentos = faixa.getMovimentos();
			for (Movimento movimento : movimentos) {
				
				// Criando Elementos
				JLabel labelDescricaoMovimento = new JLabel(movimento.getDescricao());
				JTextField jtxQuantidade = new JTextField();
				JTextField jtxIntervaloSegundos = new JTextField();
				
				// Inserindo valores nos JText Field
				jtxIntervaloSegundos.setText(String.valueOf(movimento.getIntervaloSegundos()));
				jtxQuantidade.setText(String.valueOf(movimento.getQtdRepeticao()));

				// Empacotando JtextFields: quantidade e tempo
				Map<String, JTextField>[] arrJTextField_Quantidade_Tempo = new HashMap[2];
				arrJTextField_Quantidade_Tempo[0] = new HashMap<String, JTextField>();
				arrJTextField_Quantidade_Tempo[1] = new HashMap<String, JTextField>();
				
				arrJTextField_Quantidade_Tempo[0].put("jtxQuantidade", jtxQuantidade);
				arrJTextField_Quantidade_Tempo[1].put("jtxIntervaloSegundos", jtxIntervaloSegundos);
				
				// Criando chave para o array de JTextField com o nome do movimento
				Map<String, Map<String, JTextField>[]> mapMovimento = new HashMap<String, Map<String, JTextField>[]>();
				mapMovimento.put(movimento.getDescricao(), arrJTextField_Quantidade_Tempo);
				
				// Adicionando elementos JTextField mapeados à lista
				listElementos.add(mapMovimento);
				
				
				c.fill = GridBagConstraints.HORIZONTAL; 	// natural height, maximum width
				c.weightx = 0.5;
//				c.anchor = GridBagConstraints.PAGE_START; // bottom of space
				c.gridwidth = 3; // 3 columns wide
				c.gridx = 0;
				c.gridy = i;
				c.insets = new Insets(5, 5, 0, 5); // top padding

				conteudoPanel.add(labelDescricaoMovimento, c);
				
				c.fill = GridBagConstraints.HORIZONTAL; 	// natural height, maximum width
				c.weightx = 0.5;
//				c.anchor = GridBagConstraints.PAGE_START; // bottom of space
				c.gridwidth = 1; // 3 columns wide
				c.gridx = 3;
				c.gridy = i;
				c.insets = new Insets(5, 5, 0, 5); // top padding
				
				conteudoPanel.add(jtxQuantidade, c);
				
				c.fill = GridBagConstraints.HORIZONTAL; 	// natural height, maximum width
				c.weightx = 0.5;
//				c.anchor = GridBagConstraints.PAGE_START; // bottom of space
				c.gridwidth = 1; // 3 columns wide
				c.gridx = 4;
				c.gridy = i;
				c.insets = new Insets(5, 5, 0, 5); // top padding
				
				conteudoPanel.add(jtxIntervaloSegundos, c);
				
				i++;
			}

			tabPanel.add(conteudoPanel);
			tabbedFaixas.add(faixa.getDescricao(), scrollPane);  

		}
		
		this.add(tabbedFaixas);
	}
	
	/**
	 * Obtém a lista de elementos JTextField
	 * @return
	 */
	public List<Map<String, Map<String, JTextField>[]>> getListaDeElementos() {
		return this.listElementos;
	}
	
	/**
	 * Obtém o JTabbedPane das faixas
	 * @return
	 */
	public JTabbedPane getJTabbedPaneFaixas() {
		return this.tabbedFaixas;
	}

}
