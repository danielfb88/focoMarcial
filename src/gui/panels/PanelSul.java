package gui.panels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelSul extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JButton btnSalvar;
	private JButton btnIniciar;
	private JButton btnPausar;
	private JButton btnContinuar;
	private JButton btnReiniciar;
	
	public PanelSul(Dimension dimension) {
		setBackground(Color.BLACK);
		setPreferredSize(dimension);
		
		// Botões
		btnSalvar = new JButton("Salvar");
		btnIniciar = new JButton("Iniciar");
		btnPausar = new JButton("Pausar");
		btnContinuar = new JButton("Continuar");
		btnReiniciar = new JButton("Reiniciar");
		
		add(btnSalvar);
		add(btnIniciar);
		add(btnPausar);
		add(btnContinuar);
		add(btnReiniciar);
	}
}
