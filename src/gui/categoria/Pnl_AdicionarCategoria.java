package gui.categoria;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Pnl_AdicionarCategoria extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPanel pnl_formulario;
	private JPanel pnl_botoes;
	private JTextField tx_descricao;
	private JButton btn_salvar;

	public Pnl_AdicionarCategoria() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		init();
	}

	private void init() {
		// Panel do formulario
		pnl_formulario = new JPanel();
		pnl_formulario.setBackground(Color.LIGHT_GRAY);
		pnl_formulario.setLayout(new FlowLayout());
		// Inserindo componentes
		pnl_formulario.add(new JLabel("Nome da categoria"));
		pnl_formulario.add(getTx_descricao());

		// Panel dos Botões
		pnl_botoes = new JPanel();
		pnl_botoes.setLayout(new FlowLayout());
		// Inserindo componentes
		pnl_botoes.add(getBtn_Salvar());

		// Inserindo ao Painel
		add(pnl_formulario);
		add(pnl_botoes);
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
//		Categoria categoria = new Categoria();
//		categoria.setDescricao(tx_descricao.getText());
//		if (categoria.adicionar())
//			JOptionPane.showMessageDialog(this, "Categoria adicionada com sucesso.");
//		else
//			JOptionPane.showMessageDialog(this, "Não foi possível adicionar a categoria.");
	}

}
