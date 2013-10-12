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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import control.Aula;
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
	private JButton btnProximo1;

	/**
	 * Botão para movimento anterior
	 */
	private JButton btnAnterior1;

	/**
	 * Botão para próxima faixa
	 */
	private JButton btnProximo2;

	/**
	 * Botão para faixa anterior
	 */
	private JButton btnAnterior2;

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

		panelSul.add(criarPanelControle());

		return panelSul;
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
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setPreferredSize(new Dimension(20, 20));
		btnPlayPause = new JButton("Play");
		btnPlayPause.setPreferredSize(new Dimension(20, 20));

		btnProximo1 = new JButton(">");
		btnProximo1.setPreferredSize(new Dimension(20, 20));
		btnAnterior1= new JButton("<");
		btnAnterior1.setPreferredSize(new Dimension(20, 20));

		btnProximo2 = new JButton(">>");
		btnProximo2.setPreferredSize(new Dimension(20, 20));
		btnAnterior2 = new JButton("<<");
		btnAnterior2.setPreferredSize(new Dimension(20, 20));

		/*
		 * LAYOUT faixa
		 */
		GridBagConstraints c = new GridBagConstraints();		
		
		/*
		 * Salvar - Play/Pause
		 */
		c.fill = GridBagConstraints.HORIZONTAL; // natural height, maximum
		// width
		c.weightx = 0.5;
		c.anchor = GridBagConstraints.PAGE_START; // bottom of space
		c.gridwidth = 1; // 1 columns wide
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(5, 5, 0, 5); // top padding

		pnlControle.add(btnPlayPause, c);

		c.fill = GridBagConstraints.HORIZONTAL; // natural height, maximum
		// width
		c.weightx = 0.5;
		c.anchor = GridBagConstraints.PAGE_START; // bottom of space
		c.gridwidth = 1; // 1 columns wide
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(5, 5, 0, 5); // top padding

		pnlControle.add(btnSalvar, c);
		
		
		
		

		c.fill = GridBagConstraints.HORIZONTAL; // natural height, maximum
		// width
		c.weightx = 0.5;
		c.anchor = GridBagConstraints.PAGE_START; // bottom of space
		c.gridwidth = 1; // 1 columns wide
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(5, 5, 0, 5); // top padding

		pnlControle.add(btnAnterior1, c);

		c.fill = GridBagConstraints.HORIZONTAL; // natural height, maximum
		// width
		c.weightx = 0.5;
		c.anchor = GridBagConstraints.PAGE_START; // bottom of space
		c.gridwidth = 1; // 1 columns wide
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(5, 5, 0, 5); // top padding

		pnlControle.add(btnProximo1, c);

		/*
		 * LAYOUT movimento
		 */

		c.fill = GridBagConstraints.HORIZONTAL; // natural height, maximum
		// width
		c.weightx = 0.5;
		c.anchor = GridBagConstraints.PAGE_START; // bottom of space
		c.gridwidth = 1; // 1 columns wide
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(5, 5, 0, 5); // top padding

		pnlControle.add(btnAnterior2, c);

		c.fill = GridBagConstraints.HORIZONTAL; // natural height, maximum
		// width
		c.weightx = 0.5;
		c.anchor = GridBagConstraints.PAGE_START; // bottom of space
		c.gridwidth = 1; // 1 columns wide
		c.gridx = 1;
		c.gridy = 3;
		c.insets = new Insets(5, 5, 0, 5); // top padding

		pnlControle.add(btnProximo2, c);


		/*
		 * Eventos
		 */
		
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

		/**
		 * Botão Proximo Movimento
		 */
		btnProximo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnProximo1ActionPerformed(evt);
			}
		});

		/**
		 * Botão Movimento Anterior
		 */
		btnAnterior1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnAnterior1ActionPerformed(evt);
			}
		});

		/**
		 * Botão Proxima Faixa
		 */
		btnProximo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnProximo2ActionPerformed(evt);
			}
		});

		/**
		 * Botão Faixa Anterior
		 */
		btnAnterior2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnAnterior2ActionPerformed(evt);
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
		List<Faixa> faixas = panelCentral.getFaixas();

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
	 * Action Performed do botão Próximo movimento
	 * 
	 * @param evt
	 */
	private void btnProximo1ActionPerformed(java.awt.event.ActionEvent evt) {
		aula.setProximo1(true);
	}

	/**
	 * Action Performed do botão Anterior movimento
	 * 
	 * @param evt
	 */
	private void btnAnterior1ActionPerformed(java.awt.event.ActionEvent evt) {
		aula.setAnterior1(true);
	}

	/**
	 * Action Performed do botão Próxima Faixa
	 * 
	 * @param evt
	 */
	private void btnProximo2ActionPerformed(java.awt.event.ActionEvent evt) {
		aula.setProximo2(true);
	}

	/**
	 * Action Performed do botão Anterior movimento
	 * 
	 * @param evt
	 */
	private void btnAnterior2ActionPerformed(java.awt.event.ActionEvent evt) {
		aula.setAnterior2(true);
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
