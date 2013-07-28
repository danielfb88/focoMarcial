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
		
		
		// TODO: Mudar layout. Grid Layout nao vai resolver
		// TODO: utilizar gridbaglayout para celulas maiores do que outras
		for (Faixa faixa : faixas) {
			
			// Labels de Título da coluna
			JLabel labelMovimento = new JLabel("Movimento:");
			JLabel labelQuantidade = new JLabel("Quantidade:");
			JLabel labelIntervalo = new JLabel("Intervalo (em segundos):");

			JPanel tabPanel = new JPanel();
			tabPanel.setPreferredSize(new Dimension(dimension.width - 30, dimension.height));
			
			JPanel conteudoPanel = new JPanel();
//			conteudoPanel.setPreferredSize(new Dimension(dimension.width - 30, 0));
			
			conteudoPanel.setAlignmentY(CENTER_ALIGNMENT);
			conteudoPanel.setAlignmentX(CENTER_ALIGNMENT);
			
			JScrollPane scrollPane = new JScrollPane(conteudoPanel);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			
			conteudoPanel.add(labelMovimento);
			conteudoPanel.add(labelQuantidade);
			conteudoPanel.add(labelIntervalo);
			
			List<Movimento> movimentos = faixa.getMovimentos();
			for (Movimento movimento : movimentos) {
				conteudoPanel.setLayout(new GridLayout(0, 3));
				
				JLabel labelDescricaoMovimento = new JLabel(movimento.getDescricao());
				JTextField jtxQuantidade = new JTextField();
				JTextField jtxIntervaloSegundos = new JTextField();
				
				jtxIntervaloSegundos.setText(String.valueOf(movimento.getIntervaloSegundos()));
				jtxQuantidade.setText(String.valueOf(movimento.getQtdRepeticao()));
				
				jtxQuantidade.setPreferredSize(new Dimension(1, 1));
				jtxIntervaloSegundos.setSize(10, 10);

				conteudoPanel.add(labelDescricaoMovimento);
				conteudoPanel.add(jtxQuantidade);
				conteudoPanel.add(jtxIntervaloSegundos);

			}

			tabPanel.add(scrollPane);
			tabbedFaixas.add(faixa.getDescricao(), tabPanel);  

		}
		
		
		this.add(tabbedFaixas);
	}

}
