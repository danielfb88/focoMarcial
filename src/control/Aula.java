package control;

import java.util.List;

import javax.swing.JTabbedPane;

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

	/**
	 * Tocador Wav
	 */
	private WavPlayer player;

	/**
	 * TODO: INSERIR LÓGICA PARA PROXIMO E ANTERIOR DE FAIXA E MOVIMENTO.
	 */
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

			Util.tempo(5);
			player.play(faixas.get(i).getPath());
			Util.tempo(5);

			List<Movimento> movimentos = faixas.get(i).getMovimentos();

			/*
			 * Loop de Movimento
			 */
			for (int j = 0; j < movimentos.size(); j++) {
				
				// Próxima faixa solicitada?
				if (Aula.getInstance().isProximo2()) {
					Aula.getInstance().setProximo2(false);
					break;
				}
				
				movimentos.get(j).setConfig(config);

				try {
					movimentos.get(j).iniciar();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// Fim da faixa
			player.play(config.getPathDescanso());
			Util.tempo(config.getTempoAlongamento());

			player.play(config.getPathAtencao());
			System.out.println("*** Fim do Descanso ***");
		}

	}

	private Config getConfig() {
		return new Config().getByPerfil("default");
	}

	public void manipularElementoTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
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
			System.out.println("*** PAUSADO ***");

		synchronized (this) {
			while (pause) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if (!pause)
					System.out.println("*** CONTINUANDO ***");
			}
		}

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
