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

/**
 * Main
 * 
 * @author Daniel Bonfim <daniel.fb88@gmail.com>
 * @since 05/08/2013
 * @version 1.0
 * 
 */
public class Main extends JFrame {
	private static final long serialVersionUID = 1L;

	private Dimension dimension = new Dimension(790, 480);
	private MenuBar menu;
	private PanelCentral panelCentral;
	private JPanel panelSul;

	// Botões do Panel Sul
	private JButton btnSalvar;
	private JButton btnPlayPause;

	private Aula aula;
	private List<Faixa> faixas;

	public Main() {
		super("Foco Marcial");
		setResizable(false);
		setPreferredSize(dimension);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Centralizar no centro da tela
		setLocation(
				(Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (dimension.width / 2),
				(Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (dimension.height / 2));

		// Menu
		this.menu = new MenuBar();
		setJMenuBar(this.menu);

		// Faixas vindas do banco
		faixas = new ArteMarcial(1).getTodasAsFaixas();

		// Enviando faixas para o Painel central
		panelCentral = new PanelCentral(new Dimension(dimension.width - 15, dimension.height - 95), faixas);

		// Painel Sul responsável pelos botões
		panelSul = criarPanelSul();

		// Inserindo panels
		getContentPane().add(panelCentral, BorderLayout.CENTER);
		getContentPane().add(panelSul, BorderLayout.SOUTH);

		pack();
	}

	/**
	 * Criar e configurar o Painel Sul
	 * 
	 * @return JPanel com botões, etc.
	 */
	private JPanel criarPanelSul() {
		JPanel panelSul = new JPanel();
		panelSul.setPreferredSize(new Dimension(dimension.width, 75));
		panelSul.setBackground(Color.BLACK);

		adicionarElementosAoPanelSul(panelSul);

		return panelSul;
	}

	/**
	 * Eventos para o Panel Sul
	 */
	private void adicionarElementosAoPanelSul(JPanel panelSul) {
		btnSalvar = new JButton("Salvar");
		btnPlayPause = new JButton("Play");

		/**
		 * Botão Salvar
		 */
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnSalvarActionPerformed(evt);
			}
		});

		/**
		 * Botão Play/Pause
		 */
		btnPlayPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnPlayPauseActionPerformed(evt);
			}
		});

		panelSul.add(btnSalvar);
		panelSul.add(btnPlayPause);
	}

	/**
	 * Action Performed do botão Salvar
	 * 
	 * @param evt
	 */
	private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {
		faixas = panelCentral.getFaixas();

		for (Faixa faixa : faixas) {
			List<Movimento> movimentos = faixa.getMovimentos();
			for (Movimento movimento : movimentos) {
				if (!movimento.salvar())
					JOptionPane.showMessageDialog(null, "Não foi possível salvar as configurações do movimento " + movimento.getDescricao() + ".");
			}
		}
		JOptionPane.showMessageDialog(null, "Update concluído.");
	}

	/**
	 * Action Performed do botão Pause
	 * 
	 * @param evt
	 */
	private void btnPlayPauseActionPerformed(java.awt.event.ActionEvent evt) {
		if (aula == null) {
			// Arte Marcial = Hapkido
			aula = new Aula(new ArteMarcial().getById(1));
			aula.start();
			btnPlayPause.setText("Pause");

		} else {
			if (aula.isPausaSolicitada() == false) {
				aula.pausar();
				btnPlayPause.setText("Play");
			} else {
				aula.continuar();
				btnPlayPause.setText("Pause");
			}
		}
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
