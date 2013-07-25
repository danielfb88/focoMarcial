package gui;

import gui.categoria.Frm_AdicionarCategoria;
import gui.categoria.Frm_PesquisarCategoria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBarPrincipal extends JMenuBar {
	private static final long serialVersionUID = 1L;

	private JMenu menu_arquivo;
	private JMenu menu_ajuda;

	private JMenu menu_categoria;
	private JMenu menu_informacao;

	private JMenuItem menuItem_categoria_adicionar;
	private JMenuItem menuItem_categoria_pesquisar;

	private JMenuItem menuItem_informacao_adicionar;
	private JMenuItem menuItem_informacao_pesquisar;

	private JMenuItem menuItem_configuracao;

	private JMenuItem menuItem_sair;

	public MenuBarPrincipal() {
		criarElementos();
		configurarElementos();
		criarEventosDosElementos();
		adicionarMenus();
	}

	/**
	 * Espaço para a instanciação dos elementos que comporão o menu
	 */
	private void criarElementos() {
		menu_arquivo = new JMenu("Arquivo");
		menu_ajuda = new JMenu("Ajuda");

		// Em arquivo
		menu_categoria = new JMenu("Categoria");
		menu_informacao = new JMenu("Informação");

		// Em Arquivo->Categoria
		menuItem_categoria_adicionar = new JMenuItem("Adicionar");
		menuItem_categoria_pesquisar = new JMenuItem("Pesquisar");

		// Em Arquivo->Informacao
		menuItem_informacao_adicionar = new JMenuItem("Adicionar");
		menuItem_informacao_pesquisar = new JMenuItem("Pesquisar");

		menuItem_configuracao = new JMenuItem("Configurar");
		menuItem_sair = new JMenuItem("Sair");
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
		menuItem_categoria_adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jMenuItem_categoriaAdicionarActionPerformed(evt);
			}
		});

		// Evento Item Categoria Pesquisar
		menuItem_categoria_pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jMenuItem_categoriaPesquisarActionPerformed(evt);
			}
		});

		// Evento Item Informacao Adicionar
		menuItem_informacao_adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jMenuItem_informacaoAdicionarActionPerformed(evt);
			}
		});

		// Evento Item Informacao Pesquisar
		menuItem_informacao_pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jMenuItem_informacaoPesquisarActionPerformed(evt);
			}
		});

		// Evento Item Configurar
		menuItem_configuracao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jMenuItem_configuracaoActionPerformed(evt);
			}
		});

		// Evento Item Sair
		menuItem_sair.addActionListener(new ActionListener() {
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
		menu_arquivo.add(menu_categoria);
		menu_arquivo.add(menu_informacao);
		menu_arquivo.addSeparator();
		menu_arquivo.add(menuItem_configuracao);
		menu_arquivo.add(menuItem_sair);

		// Menu Categoria
		menu_categoria.add(menuItem_categoria_adicionar);
		menu_categoria.add(menuItem_categoria_pesquisar);

		// Menu Informação
		menu_informacao.add(menuItem_informacao_adicionar);
		menu_informacao.add(menuItem_informacao_pesquisar);

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

	// Action Performed - Informação Adicionar
	private void jMenuItem_informacaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {

	}

	// Action Performed - Informação Pesquisar
	private void jMenuItem_informacaoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jMenuItem_configuracaoActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jMenuItem_sairActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}

}
