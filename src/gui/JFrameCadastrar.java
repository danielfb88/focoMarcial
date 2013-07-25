package gui;

import gui.layout.CardLayoutPanel_Cadastrar;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameCadastrar extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel panelBotoes;
	private JButton btnPrimeiro;
	private JButton btnUltimo;

	private JPanel jpanelCard;

	public JFrameCadastrar() {
		super("Sapien");
		setLocationRelativeTo(null);
		setResizable(false);
		setPreferredSize(new Dimension(390, 180));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// adiciona o painel usando CardLayout no centro da janela
		getContentPane().add(getPanelCard(), BorderLayout.CENTER);
		// adiciona os botões na área inferior da janela
		getContentPane().add(getPanelBotoes(), BorderLayout.SOUTH);

		pack();
	}

	/**
	 * Get Panel Card
	 * 
	 * @return
	 */
	private JPanel getPanelCard() {
		if (jpanelCard == null) {
			jpanelCard = new CardLayoutPanel_Cadastrar();
		}
		return jpanelCard;
	}

	/**
	 * Componente JButton
	 * 
	 * @return
	 */
	private JButton getBtnPrimeiro() {
		if (btnPrimeiro == null) {
			btnPrimeiro = new JButton("Primeiro");
			btnPrimeiro.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					CardLayout cardLayout = (CardLayout) getPanelCard().getLayout();
					cardLayout.first(getPanelCard());
				}
			});
		}
		return btnPrimeiro;
	}

	/**
	 * Componente JButton
	 * 
	 * @return
	 */
	private JButton getBtnUltimo() {
		if (btnUltimo == null) {
			btnUltimo = new JButton("Ultimo");
			btnUltimo.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					CardLayout cardLayout = (CardLayout) getPanelCard().getLayout();
					cardLayout.last(getPanelCard());
				}
			});
		}
		return btnUltimo;
	}

	/**
	 * Componente JPanel
	 * 
	 * @return
	 */
	private JPanel getPanelBotoes() {
		if (panelBotoes == null) {
			panelBotoes = new JPanel();
			panelBotoes.add(getBtnPrimeiro());
			panelBotoes.add(getBtnUltimo());
		}
		return panelBotoes;
	}

}
