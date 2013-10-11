package gui;

import gui.menu.MenuBar;
import gui.panels.PanelCentral;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

	/**
	 * Dimensão do JFrame
	 */
	private Dimension dimension = new Dimension(790, 600);

	/**
	 * Menu
	 */
	private MenuBar menu;

	/**
	 * Painel Central
	 */
	private PanelCentral panelCentral;

	/**
	 * Painel Inferior
	 */
	private JPanel panelSul;

	/**
	 * Botão Salvar - Painel Sul
	 */
	private JButton btnSalvar;

	/**
	 * Botão Play/Pause - Painel Sul
	 */
	private JButton btnPlayPause;

	/**
	 * Botão para próximo movimento
	 */
	private JButton btnProximoMovimento;

	/**
	 * Botão para movimento anterior
	 */
	private JButton btnAnteriorMovimento;

	/**
	 * Botão para próxima faixa
	 */
	private JButton btnProximaFaixa;

	/**
	 * Botão para faixa anterior
	 */
	private JButton btnAnteriorFaixa;

	/**
	 * Botão para cancelar o exercicio corrente
	 */
	private JButton btnCancelarExercicio;

	/**
	 * Arte Marcial
	 */
	private ArteMarcial arteMarcial;

	/**
	 * Thread responsável pela execução da aula
	 */
	private Aula aula;

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

		// Enviando faixas para o Painel central
		panelCentral = new PanelCentral(new Dimension(dimension.width - 15, dimension.height - 170), new Faixa().getTodasAsFaixas());

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
		panelSul.setPreferredSize(new Dimension(dimension.width, 150));
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

		JPanel pnlControle = criarPanelControle();

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
		panelSul.add(pnlControle);
	}

	/**
	 * Cria o panel controlador da aula.
	 * 
	 * @return
	 */
	private JPanel criarPanelControle() {
		JPanel pnlControle = new JPanel();

		pnlControle.setLayout(new GridBagLayout());
		pnlControle.setPreferredSize(new Dimension(180, 140));
		pnlControle.setBackground(Color.WHITE);

		btnProximoMovimento = new JButton(">>");
		btnProximoMovimento.setPreferredSize(new Dimension(55, 20));
		btnAnteriorMovimento = new JButton("<<");
		btnAnteriorMovimento.setPreferredSize(new Dimension(55, 20));

		btnProximaFaixa = new JButton(">>");
		btnProximaFaixa.setPreferredSize(new Dimension(55, 20));
		btnAnteriorFaixa = new JButton("<<");
		btnAnteriorFaixa.setPreferredSize(new Dimension(55, 20));

		btnCancelarExercicio = new JButton("Cancelar exercício");
		btnCancelarExercicio.setPreferredSize(new Dimension(55, 50));

		/*
		 * LAYOUT faixa
		 */
		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.CENTER; // natural height, maximum
		// width
		c.weightx = 0.5;
		c.anchor = GridBagConstraints.CENTER; // bottom of space
		c.gridwidth = 2; // 2 columns wide
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5, 5, 0, 5); // top padding
		// c.ipady = 0; // reset to default

		pnlControle.add(new JLabel("Faixa"), c);

		c.fill = GridBagConstraints.HORIZONTAL; // natural height, maximum
		// width
		c.weightx = 0.5;
		c.anchor = GridBagConstraints.PAGE_START; // bottom of space
		c.gridwidth = 1; // 1 columns wide
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(5, 5, 0, 5); // top padding

		pnlControle.add(btnAnteriorFaixa, c);

		c.fill = GridBagConstraints.HORIZONTAL; // natural height, maximum
		// width
		c.weightx = 0.5;
		c.anchor = GridBagConstraints.PAGE_START; // bottom of space
		c.gridwidth = 1; // 1 columns wide
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(5, 5, 0, 5); // top padding

		pnlControle.add(btnProximaFaixa, c);

		/*
		 * LAYOUT movimento
		 */
		c.fill = GridBagConstraints.CENTER; // natural height, maximum
		// width
		c.weightx = 0.5;
		c.anchor = GridBagConstraints.CENTER; // bottom of space
		c.gridwidth = 2; // 2 columns wide
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(5, 5, 0, 5); // top padding
		// c.ipady = 0; // reset to default

		pnlControle.add(new JLabel("Movimento"), c);

		c.fill = GridBagConstraints.HORIZONTAL; // natural height, maximum
		// width
		c.weightx = 0.5;
		c.anchor = GridBagConstraints.PAGE_START; // bottom of space
		c.gridwidth = 1; // 1 columns wide
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(5, 5, 0, 5); // top padding

		pnlControle.add(btnAnteriorMovimento, c);

		c.fill = GridBagConstraints.HORIZONTAL; // natural height, maximum
		// width
		c.weightx = 0.5;
		c.anchor = GridBagConstraints.PAGE_START; // bottom of space
		c.gridwidth = 1; // 1 columns wide
		c.gridx = 1;
		c.gridy = 3;
		c.insets = new Insets(5, 5, 0, 5); // top padding

		pnlControle.add(btnProximoMovimento, c);

		/*
		 * CANCELAR EXERCICIO
		 */
		c.fill = GridBagConstraints.CENTER; // natural height, maximum
		// width
		c.weightx = 0.5;
		c.anchor = GridBagConstraints.CENTER; // bottom of space
		c.gridwidth = 3; // 3 columns wide
		c.gridx = 0;
		c.gridy = 4;
		c.insets = new Insets(5, 5, 0, 5); // top padding
		// c.ipady = 0; // reset to default

		pnlControle.add(btnCancelarExercicio, c);

		/*
		 * Eventos
		 */

		/**
		 * Botão Proximo Movimento
		 */
		btnProximoMovimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnProximoMovimentoActionPerformed(evt);
			}
		});

		/**
		 * Botão Movimento Anterior
		 */
		btnAnteriorMovimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnAnteriorMovimentoActionPerformed(evt);
			}
		});

		/**
		 * Botão Proxima Faixa
		 */
		btnProximaFaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnProximaFaixaActionPerformed(evt);
			}
		});

		/**
		 * Botão Faixa Anterior
		 */
		btnAnteriorMovimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnAnteriorFaixaActionPerformed(evt);
			}
		});

		/**
		 * Botão Cancelar Exercício
		 */
		btnCancelarExercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnCancelarExercicioActionPerformed(evt);
			}
		});

		return pnlControle;
	}

	/**
	 * Action Performed do botão Salvar
	 * 
	 * @param evt
	 */
	private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {
		arteMarcial.setFaixas(panelCentral.getFaixas());
		List<Faixa> faixas = arteMarcial.getFaixas();

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
			aula = Aula.getInstance();
			aula.manipularElementoTabbedPane(this.panelCentral.getTabbedPane());
			aula.start();
			btnPlayPause.setText("Pause");

		} else {
			if (aula.isPaused() == false) {
				aula.pausar();
				btnPlayPause.setText("Play");
			} else {
				aula.continuar();
				btnPlayPause.setText("Pause");
			}
		}
	}

	/**
	 * Action Performed do botão Cancelar Exercicio
	 * 
	 * @param evt
	 */
	private void btnCancelarExercicioActionPerformed(java.awt.event.ActionEvent evt) {
		aula.setCancelarExercicio(true);
	}

	/**
	 * Action Performed do botão Próximo movimento
	 * 
	 * @param evt
	 */
	private void btnProximoMovimentoActionPerformed(java.awt.event.ActionEvent evt) {
		aula.setProximoMovimento(true);
	}

	/**
	 * Action Performed do botão Anterior movimento
	 * 
	 * @param evt
	 */
	private void btnAnteriorMovimentoActionPerformed(java.awt.event.ActionEvent evt) {
		aula.setAnteriorMovimento(true);
	}

	/**
	 * Action Performed do botão Próxima Faixa
	 * 
	 * @param evt
	 */
	private void btnProximaFaixaActionPerformed(java.awt.event.ActionEvent evt) {
		aula.setProximaFaixa(true);
	}

	/**
	 * Action Performed do botão Anterior movimento
	 * 
	 * @param evt
	 */
	private void btnAnteriorFaixaActionPerformed(java.awt.event.ActionEvent evt) {
		aula.setAnteriorFaixa(true);
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
