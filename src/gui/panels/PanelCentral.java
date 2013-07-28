package gui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import ddd.Faixa;
import ddd.Movimento;

public class PanelCentral extends JPanel {
	private List<Faixa> faixas;
	private JTabbedPane tabbedFaixas;

	public PanelCentral(Dimension dimension, List<Faixa> faixas) {
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(dimension.width - 5, dimension.height - 5));

		tabbedFaixas = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedFaixas.setPreferredSize(new Dimension(dimension.width - 10, dimension.height - 10));
		
		
		for (Faixa faixa : faixas) {
			
			// Labels de Título da coluna
			JLabel labelMovimento = new JLabel("Movimento");
			JLabel labelQuantidade = new JLabel("Nº");
			JLabel labelIntervalo = new JLabel("T(s)");

			JPanel tabPanel = new JPanel();
			tabPanel.setPreferredSize(new Dimension(dimension.width - 30, dimension.height));
			
			JPanel conteudoPanel = new JPanel();
			conteudoPanel.setLayout(new GridBagLayout());
//			conteudoPanel.setSize(new Dimension(dimension.width - 30, dimension.height - 100));
			GridBagConstraints c = new GridBagConstraints();
			
			JScrollPane scrollPane = new JScrollPane(conteudoPanel);
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
				
				JLabel labelDescricaoMovimento = new JLabel(movimento.getDescricao());
				JTextField jtxQuantidade = new JTextField();
				JTextField jtxIntervaloSegundos = new JTextField();
				
				jtxIntervaloSegundos.setText(String.valueOf(movimento.getIntervaloSegundos()));
				jtxQuantidade.setText(String.valueOf(movimento.getQtdRepeticao()));
				
//				jtxQuantidade.setPreferredSize(new Dimension(1, 1));
//				jtxIntervaloSegundos.setSize(10, 10);
				
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

			tabPanel.add(scrollPane);
			tabbedFaixas.add(faixa.getDescricao(), tabPanel);  

		}
		
		
		this.add(tabbedFaixas);
	}

}
