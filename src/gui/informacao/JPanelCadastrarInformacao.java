package gui.informacao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// TODO: APENAS COMO TESTE. APROVEITE O QUE FOR POSSÍVEL.
public class JPanelCadastrarInformacao extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel panel_campos;
	private JPanel panel_botoes;
	private JTextField tx_descricao;
	private JButton btn_salvar;

	public JPanelCadastrarInformacao() {
		setLayout(new GridLayout(2, 1));

		init();
	}

	private void init() {
		// Panel dos campos
		panel_campos = new JPanel();
		panel_campos.setBackground(Color.BLUE);
		panel_campos.setLayout(new GridLayout(0, 2));

		// Panel dos Botões
		panel_botoes = new JPanel();
		panel_botoes.setLayout(new FlowLayout());

		// Inserindo componentes
		panel_campos.add(new JLabel("Nome da categoria"));
		panel_campos.add(getTx_descricao());
		panel_botoes.add(getBtn_Salvar());

		// Inserindo ao Painel
		add(panel_campos);
		add(panel_botoes);
	}

	/**
	 * Componente JTextField
	 * 
	 * @return
	 */
	private JTextField getTx_descricao() {
		if (tx_descricao == null) {
			tx_descricao = new JTextField();
			tx_descricao.setPreferredSize(new Dimension(200, 20));
		}
		return tx_descricao;
	}

	/**
	 * Componente JButton
	 * 
	 * @return
	 */
	private JButton getBtn_Salvar() {
		if (btn_salvar == null) {
			btn_salvar = new JButton("Salvar");

			btn_salvar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent evt) {
					btn_salvarActionPerformed(evt);
				}
			});
		}
		return btn_salvar;
	}

	/**
	 * Evento Btn_Salvar
	 * 
	 * @param evt
	 */
	private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}

}
