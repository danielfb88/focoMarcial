package gui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

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
		
		// Labels de Título da coluna
		JLabel labelMovimento = new JLabel("Movimento:");
		JLabel labelQuantidade = new JLabel("Quantidade:");
		JLabel labelIntervalo = new JLabel("Intervalo (em segundos):");
		
//		labelMovimento.setSize(20, 10);
//		labelQuantidade.setSize(20, 10);
//		labelIntervalo.setSize(20, 10);
		
		
		for (Faixa faixa : faixas) {

			JPanel tabPanel = new JPanel();
			
			JScrollPane scrollPane = new JScrollPane(tabPanel);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			
			tabPanel.setAlignmentY(CENTER_ALIGNMENT);
			tabPanel.setAlignmentX(CENTER_ALIGNMENT);
			
			tabPanel.setPreferredSize(new Dimension(dimension.width - 30, dimension.height));
			
			// TODO: PQ o objeto label não está entrando aqui???? Vou pro som...
			tabPanel.add(labelMovimento);
			tabPanel.add(labelQuantidade);
			tabPanel.add(labelIntervalo);
			
			List<Movimento> movimentos = faixa.getMovimentos();
			for (Movimento movimento : movimentos) {
				tabPanel.setLayout(new GridLayout(0, 3));

				tabPanel.add(new JLabel(movimento.getDescricao()));
				tabPanel.add(new JTextField(1));
				tabPanel.add(new JTextField(1));

			}

//			tabbedFaixas.add(faixa.getDescricao(), tabPanel);
			tabbedFaixas.add(faixa.getDescricao(), scrollPane);  

		}
		
		
		this.add(tabbedFaixas);
	}

}
