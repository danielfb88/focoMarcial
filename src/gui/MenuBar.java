package gui;

import guiteste.categoria.Frm_AdicionarCategoria;
import guiteste.categoria.Frm_PesquisarCategoria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;

	private JMenu menu_arquivo = new JMenu("Arquivo");
	private JMenu menu_ajuda = new JMenu("Ajuda");

	private JMenu menu_arquivo_novo = new JMenu("Novo");

	private JMenuItem menuItem_arquivo_novo_faixa = new JMenuItem("Faixa");
	private JMenuItem menuItem_arquivo_novo_movimento = new JMenuItem("Movimento");

	private JMenuItem menuItem_ajuda_focoMarcial = new JMenuItem("Foco Marcial");
	
	private JMenuItem menuItem_arquivo_configurar = new JMenuItem("Configurar");
	private JMenuItem menuItem_arquivo_reiniciar = new JMenuItem("Reiniciar");
	private JMenuItem menuItem_arquivo_sair = new JMenuItem("Sair");

	public MenuBar() {
		configurarElementos();
		criarEventosDosElementos();
		adicionarMenus();
	}

	/**
	 * Espaço para a configuração dos elementos
	 */
	private void configurarElementos() {
		// Config JMenuItem Categoria
		// menuItem_categoria_adicionar.setAccelerator(
		// javax.swing.KeyStroke.getKeyStroke(
		// java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));

		// Config JMenuItem Informacao
		// menuItem_informacao.setAccelerator(
		// javax.swing.KeyStroke.getKeyStroke(
		// java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));

		// Config JMenuItem Pergunta
		// menuItem_pergunta.setAccelerator(
		// javax.swing.KeyStroke.getKeyStroke(
		// java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
	}

	/**
	 * Espaço para a criação dos eventos para os Elementos de Menu criados
	 */
	private void criarEventosDosElementos() {
		// Evento Item Categoria Adicionar
		menuItem_arquivo_novo_faixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jMenuItem_categoriaAdicionarActionPerformed(evt);
			}
		});

		menuItem_arquivo_novo_movimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jMenuItem_categoriaPesquisarActionPerformed(evt);
			}
		});

		menuItem_arquivo_reiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jMenuItem_configuracaoActionPerformed(evt);
			}
		});

		// Evento Item Sair
		menuItem_arquivo_sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jMenuItem_sairActionPerformed(evt);
			}
		});
	}

	/**
	 * Espaço para adicionar os menus aos seus containers
	 */
	private void adicionarMenus() {
		// Menu Arquivo
		menu_arquivo.add(menu_arquivo_novo);
		menu_arquivo.add(menuItem_arquivo_configurar);
		menu_arquivo.add(menuItem_arquivo_reiniciar);
		menu_arquivo.add(menuItem_arquivo_sair);
		
		menu_arquivo_novo.add(menuItem_arquivo_novo_faixa);
		menu_arquivo_novo.add(menuItem_arquivo_novo_movimento);
		
		// Menu Ajuda
		menu_ajuda.add(menuItem_ajuda_focoMarcial);
				

		// Panel this
		add(menu_arquivo);
		add(menu_ajuda);
	}

	// Action Performed - Categoria Adicionar
	private void jMenuItem_categoriaAdicionarActionPerformed(java.awt.event.ActionEvent evt) {
		new Frm_AdicionarCategoria().setVisible(true);
	}

	// Action Performed - Categoria Pesquisar
	private void jMenuItem_categoriaPesquisarActionPerformed(java.awt.event.ActionEvent evt) {
		new Frm_PesquisarCategoria().setVisible(true);
	}

	private void jMenuItem_configuracaoActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jMenuItem_sairActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}

}
