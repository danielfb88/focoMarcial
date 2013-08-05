package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * MenuBar
 * 
 * @author Daniel Bonfim <daniel.fb88@gmail.com>
 * @since 05/08/2013
 * @version 1.0
 *
 */
public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;

	/************************
	 * 
	 * JMenus
	 * 
	 *************************
	 */
	private JMenu mArquivo = new JMenu("Arquivo");
	private JMenu mAjuda = new JMenu("Ajuda");
	private JMenu mConfigurar = new JMenu("Configurar");


	/************************
	 * 
	 * Menu Item
	 * 
	 *************************
	 */
	private JMenuItem iArteMarcial = new JMenuItem("ArteMarcial");
	private JMenuItem iFaixa = new JMenuItem("Faixa");
	private JMenuItem iSair = new JMenuItem("Sair");
	private JMenuItem iFocoMarcial = new JMenuItem("Foco Marcial");

	

	public MenuBar() {
		criarEventos();
		adicionarMenus();
	}

	/**
	 * Espaço para a criação dos eventos para os Elementos de Menu criados
	 */
	private void criarEventos() {

		// Evento Item Sair
		iSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				iSairActionPerformed(evt);
			}
		});
	}

	/**
	 * Espaço para adicionar os menus aos seus containers
	 */
	private void adicionarMenus() {
		// Menu Arquivo
		mArquivo.add(mConfigurar);
		mArquivo.add(iSair);
		
		// Menu Configurar
		mConfigurar.add(iArteMarcial);
		mConfigurar.add(iFaixa);
		
		// Menu Ajuda
		mAjuda.add(iFocoMarcial);

		// Panel
		add(mArquivo);
		add(mAjuda);
	}

	private void iSairActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}

}
