package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import ddd.ArteMarcial;
import ddd.Faixa;
import ddd.Movimento;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;

	private MenuBar menu;
	private JPanel panelCentral;
	private JPanel panelInferior;
	
	private int widthWindow = 490;
	private int heigthWindow = 480;
	
	private JButton btnSalvar;
	private JButton btnIniciar;
	private JButton btnPausar;
	private JButton btnContinuar;
	private JButton btnReiniciar;
	
	private JTabbedPane tabbledPane;
	
	private List<Faixa> faixas;

	public Main() {
		super("Foco Marcial");
		
		setLocationRelativeTo(null);
		setResizable(false);
		setPreferredSize(new Dimension(widthWindow, heigthWindow));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		

		// Menu
		menu = new MenuBar();
		setJMenuBar(menu);
		
		panelCentral = new JPanel();
		panelInferior = new JPanel();
		
		configPanelCentral();
		configPanelInferior();
		
		// Inserindo panels
		getContentPane().add(panelCentral, BorderLayout.CENTER);
		getContentPane().add(panelInferior, BorderLayout.SOUTH);
		
		carregarJTabbledPaneComFaixas(new ArteMarcial(1).getTodasAsFaixas());		
		
		pack();
	}
	
	// TODO: DESENVOLVER
	private void splashProgressBar() {
		
	}
	
	// TODO: Continuar. Vou dormir...
	private void carregarJTabbledPaneComFaixas(List<Faixa> faixas) {
		this.faixas = faixas;
		
		for(Faixa faixa : faixas) {
			
			JPanel panel = new JPanel();
			panel.setPreferredSize(new Dimension(widthWindow, heigthWindow - 75));
			
			List<Movimento> movimentos = faixa.getMovimentos();
			for(Movimento movimento : movimentos) {
				
				panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
				panel.add(new JLabel(movimento.getDescricao()));
				
			}
			
			tabbledPane.add(faixa.getDescricao(), panel);
			
		}
	}
	
	private void configPanelInferior() {
		panelInferior.setBackground(Color.BLACK);
		panelInferior.setPreferredSize(new Dimension(widthWindow, 75));
		
		// Botões
		btnSalvar = new JButton("Salvar");
		btnIniciar = new JButton("Iniciar");
		btnPausar = new JButton("Pausar");
		btnContinuar = new JButton("Continuar");
		btnReiniciar = new JButton("Reiniciar");
		
		panelInferior.add(btnSalvar);
		panelInferior.add(btnIniciar);
		panelInferior.add(btnPausar);
		panelInferior.add(btnContinuar);
		panelInferior.add(btnReiniciar);
	}
	
	private void configPanelCentral() {
		panelCentral.setBackground(Color.DARK_GRAY);
		
		tabbledPane = new JTabbedPane();
        panelCentral.add(tabbledPane);
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
