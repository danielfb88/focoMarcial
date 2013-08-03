package gui;

import gui.menu.MenuBar;
import gui.panels.PanelCentral;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import control.Aula;
import ddd.ArteMarcial;
import ddd.Faixa;
import ddd.Movimento;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private Dimension dimension = new Dimension(790, 480);
	private MenuBar menu;
	private PanelCentral panelCentral;
	private JPanel panelSul;
	
	// Botões do Panel Sul
	private JButton btnSalvar;
	private JButton btnPlayPause;
	private JButton btnReiniciar;
	
	private Aula aula;
	private List<Faixa> faixas;

	/**
	 * TODO: Desenvolver um player para sons orientais interessantes em loop
	 */
	public Main() {
		super("Foco Marcial");
		
		setResizable(false);
		setPreferredSize(dimension);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  / 2) - (dimension.width / 2), 
				(Toolkit.getDefaultToolkit().getScreenSize().height  / 2) - (dimension.height / 2));
		
		// Menu
		menu = new MenuBar();
		setJMenuBar(menu);
		
		faixas = new ArteMarcial(1).getTodasAsFaixas();
		
		panelCentral = new PanelCentral(new Dimension(dimension.width - 15, dimension.height - 95), faixas);
		panelSul = createPanelSul();
		
		// Inserindo panels
		getContentPane().add(panelCentral, BorderLayout.CENTER);
		getContentPane().add(panelSul, BorderLayout.SOUTH);
		
		pack();
	}
	
	private JPanel createPanelSul() {
		JPanel panelSul = new JPanel();
		panelSul.setPreferredSize(new Dimension(dimension.width, 75));
		panelSul.setBackground(Color.BLACK);
		
		btnSalvar = new JButton("Salvar");
		btnPlayPause = new JButton("Play");
		btnReiniciar = new JButton("Reiniciar");
		
		// ** Eventos **
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnSalvarActionPerformed(evt);
			}
		});
		
		btnPlayPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnPlayPauseActionPerformed(evt);
			}
		});
		
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnReiniciarActionPerformed(evt);
			}
		});
		
		panelSul.add(btnSalvar);
		panelSul.add(btnPlayPause);
		panelSul.add(btnReiniciar);
		
		return panelSul;
	}
	
	private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {
		faixas = panelCentral.getFaixas();
		
		for(Faixa faixa : faixas) {
			List<Movimento> movimentos = faixa.getMovimentos();
			for(Movimento movimento : movimentos) {
				if (!movimento.salvar())
					JOptionPane.showMessageDialog(null,"Não foi possível salvar as configurações do movimento " + movimento.getDescricao() + ".");
			}
		}
		JOptionPane.showMessageDialog(null,"Update concluído.");
	}
	
	private void btnPlayPauseActionPerformed(java.awt.event.ActionEvent evt) {
		if(aula == null) {
			// Arte Marcial = Hapkido
			aula = new Aula(new ArteMarcial().getById(1));
			aula.start();
			btnPlayPause.setText("Pause");
			
		} else {
			if(aula.isPausaSolicitada() == false) {
				aula.pausar();
				btnPlayPause.setText("Play");
			} else {
				aula.continuar();
				btnPlayPause.setText("Pause");
			}
		}
	}
	
	private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {
		JOptionPane.showMessageDialog(null,"Meu primeiro programa gráfico!\n Obrigado, Curso Java Progressivo!");
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
