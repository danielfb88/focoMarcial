package control;

import gui.Main;

import java.util.List;

import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import util.Util;
import ddd.Config;
import ddd.Exercicio;
import ddd.Faixa;
import ddd.Movimento;

/**
 * Aula com instruções sobre movimentos e exercícios da Arte Marcial
 * selecionada.
 * 
 * @author Daniel Bonfim <daniel.fb88@gmail.com>
 * @since 08/08/2013
 * @version 1.2
 * 
 *          11/10/2013 - Transformado em um singleton
 * 
 */
public class Aula extends Thread {

	private static Aula instance;

	/**
	 * Lista das faixas da Arte MArcial
	 */
	private List<Faixa> faixas;

	/*
	 * Lista de exercicios
	 */
	private List<Exercicio> exercicios;

	/**
	 * TabbedPane contendo as faixas
	 */
	private JTabbedPane tabbedPane;
	
	private Main jFrame;

	/**
	 * Tocador Wav
	 */
	private WavPlayer player;

	private boolean proximo1;
	private boolean proximo2;

	private boolean anterior1;
	private boolean anterior2;

	private Config config;

	private boolean pause;

	private Aula() {
		config = getConfig();
		player = new WavPlayer();
		faixas = new Faixa().getTodasAsFaixas();
		exercicios = new Exercicio().getTodosOsExercicios();
	}

	public static Aula getInstance() {
		if (instance == null)
			instance = new Aula();

		return instance;
	}

	@Override
	public void run() {
		this.iniciarAula();
	}

	/*
	 * 
	 * TODO: Gravar voz dos exerciícios.
	 */
	public void iniciarAula() {
		this.tabbedPane = this.jFrame.getPanelCentral().getTabbedPane();

		/*
		 * Exercícios
		 */
		if (config.isAulaComExercicio()) {
			for (int i = 0; i < exercicios.size(); i++) {
				exercicios.get(i).setConfig(config);

				try {
					exercicios.get(i).iniciar();

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}

		/*
		 * Faixas
		 * 
		 * Inicia a partir do tabbedePane selecionado.
		 */
		for (int i = tabbedPane.getSelectedIndex(); i < faixas.size(); i++) {

			// Mudar pane a cada nova faixa
			tabbedPane.setSelectedIndex(i);

			int segundosIniciais = 5;
			this.jFrame.getTextAreaStatus().append("*** Espere " + segundosIniciais + " segundo(s)... \n");
			
			Util.tempo(segundosIniciais);
			
			this.jFrame.getTextAreaStatus().append("\n FAIXA: " + faixas.get(i).getDescricao() + "\n\n");
			player.play(faixas.get(i).getPath());
			
			Util.tempo(segundosIniciais);

			List<Movimento> movimentos = faixas.get(i).getMovimentos();

			/*
			 * Movimento
			 */
			for (int j = 0; j < movimentos.size(); j++) {
				
				movimentos.get(j).setConfig(config);

				try {
					movimentos.get(j).iniciar();

				} catch (Exception e) {
					e.printStackTrace();
				}

				// Próxima faixa solicitada?
				if (Aula.getInstance().isProximo2()) {
					Aula.getInstance().setProximo2(false);
					break;

				} else if (Aula.getInstance().isAnterior1()) {
					Aula.getInstance().setAnterior1(false);

					if(j == 0)
						j--;
					else if (j > 0)
						j -= 2;

				} else if (Aula.getInstance().isAnterior2()) {
					Aula.getInstance().setAnterior2(false);

					if(i == 0)
						i--;
					else if (i > 0)
						i -= 2;

					break;
				}
			}

			// Fim da faixa
			player.play(config.getPathDescanso());
			Util.tempo(config.getTempoAlongamento());

			player.play(config.getPathAtencao());
			this.jFrame.getTextAreaStatus().append("*** Fim do Descanso *** \n");
		}

	}

	private Config getConfig() {
		return new Config().getByPerfil("default");
	}

	public void setJFrame(Main jFrame) {
		this.jFrame = jFrame;
	}

	public void continuar() {
		pause = false;

		synchronized (this) {
			this.notify();
		}
	}

	public boolean isPaused() {
		return pause;
	}

	public synchronized void pausar() {
		pause = true;
	}
	
	public void verificarPausa() {
		if (pause)
			this.jFrame.getTextAreaStatus().append("*** PAUSADO *** \n");

		synchronized (this) {
			while (pause) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if (!pause)
					this.jFrame.getTextAreaStatus().append("*** CONTINUANDO *** \n");
			}
		}

	}
	
	public JTextArea getTextAreaStatus() {
		return this.jFrame.getTextAreaStatus();
	}

	public void setProximo1(boolean flag) {
		this.proximo1 = flag;
	}

	public void setProximo2(boolean flag) {
		this.proximo1 = flag;
		this.proximo2 = flag;
	}

	public void setAnterior1(boolean flag) {
		this.anterior1 = flag;
	}

	public void setAnterior2(boolean flag) {
		this.anterior1 = flag;
		this.anterior2 = flag;
	}

	public boolean isProximo1() {
		return proximo1;
	}

	public boolean isProximo2() {
		return proximo2;
	}

	public boolean isAnterior1() {
		return anterior1;
	}

	public boolean isAnterior2() {
		return anterior2;
	}

}
