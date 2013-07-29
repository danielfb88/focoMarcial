package gui;

import gui.menu.MenuBar;
import gui.panels.PanelCentral;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import ddd.ArteMarcial;
import ddd.Faixa;
import ddd.Movimento;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private Dimension dimension = new Dimension(790, 480);
	private MenuBar menu;
	private PanelCentral panelCentral;
	private JPanel panelSul;
	
	private List<Faixa> faixas;
	
	// Botões do Panel Sul
	private JButton btnSalvar;
	private JButton btnIniciar;
	private JButton btnPausar;
	private JButton btnContinuar;
	private JButton btnReiniciar;
	
	public Main() {
		super("Foco Marcial");
		
		setLocationRelativeTo(null);
		setResizable(false);
		setPreferredSize(dimension);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
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
		btnIniciar = new JButton("Iniciar");
		btnPausar = new JButton("Pausar");
		btnContinuar = new JButton("Continuar");
		btnReiniciar = new JButton("Reiniciar");
		
		// ** Eventos **
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnSalvarActionPerformed(evt);
			}
		});
		
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnIniciarActionPerformed(evt);
			}
		});
		
		btnPausar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnPausarActionPerformed(evt);
			}
		});
		
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnContinuarActionPerformed(evt);
			}
		});
		
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnReiniciarActionPerformed(evt);
			}
		});
		
		panelSul.add(btnSalvar);
		panelSul.add(btnIniciar);
		panelSul.add(btnPausar);
		panelSul.add(btnContinuar);
		panelSul.add(btnReiniciar);
		
		return panelSul;
	}
	
	private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {
		List<Faixa> faixas = panelCentral.getFaixas();
		
		for(Faixa faixa : faixas) {
			List<Movimento> movimentos = faixa.getMovimentos();
			for(Movimento movimento : movimentos) {
				JOptionPane.showMessageDialog(null, "Movimento: " + movimento.getDescricao() + "\n Quantidade:" + movimento.getQtdRepeticao());
			}
			
		}
		
		// TODO: Salvar no banco
		
	}
	
	private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {
		JOptionPane.showMessageDialog(null,"Meu primeiro programa gráfico!\n Obrigado, Curso Java Progressivo!");
	}
	
	private void btnPausarActionPerformed(java.awt.event.ActionEvent evt) {
		JOptionPane.showMessageDialog(null,"Meu primeiro programa gráfico!\n Obrigado, Curso Java Progressivo!");
	}
	
	private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {
		JOptionPane.showMessageDialog(null,"Meu primeiro programa gráfico!\n Obrigado, Curso Java Progressivo!");
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
