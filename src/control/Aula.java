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
 * 11/10/2013 - Transformado em um singleton
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
	private boolean proximoMovimento;
	private boolean anteriorMovimento;

	private boolean proximaFaixa;
	private boolean anteriorFaixa;

	private boolean cancelarExercicio;

	private Config config;

	private boolean pause;

	private Aula() {
		config = getConfig();
		player = new WavPlayer();
		faixas = new Faixa().getTodasAsFaixas();
		exercicios = new Exercicio().getTodosOsExercicios();
	}
	
	public static Aula getInstance() {
		if(instance == null)
			instance = new Aula();
		
		return instance;
	}

	@Override
	public void run() {
		this.iniciarAula();
	}

	/*
	 * TODO: A pausa é na aula. não no arquivo de som. Portanto deve ficar aqui.
	 * 
	 * TODO: Gravar voz dos exerciícios TODO: Implementar pausa com uma variável
	 * estática no player Loop do Exercicio. 2 séries para cada
	 */
	public void iniciarAula() {
		if (config.isAulaComExercicio())
			this.executarExercicios();

		/*
		 * Loop da faixa
		 */
		for (int i = 0; i < faixas.size(); i++) {

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

	public void executarExercicios() {
		for (int i = 0; i < exercicios.size(); i++) {
			exercicios.get(i).setConfig(config);

			for (int serie = 1; serie <= exercicios.get(i).getQtdSerie(); serie++) {
				System.out.println("Exercicio: " + exercicios.get(i).getDescricao());
				System.out.println("Serie: " + serie);

				try {
					exercicios.get(i).iniciar();

				} catch (Exception e) {
					e.printStackTrace();
				}

				Util.tempo(config.getTempoDescansoCurto());
			}
			Util.tempo(config.getTempoDescansoLongo());

		}
	}

	private Config getConfig() {
		return new Config().getByPerfil("default");
	}

	public void manipularElementoTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}

	// TODO:
	public void continuar() {
		pause = false;

		synchronized (this) {
			this.notify();
		}
	}

	// TODO:
	public boolean isPaused() {
		return pause;
	}

	// TODO:
	public synchronized void pausar() {
		pause = true;
	}

	// TODO:
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

	public boolean isProximoMovimento() {
		return proximoMovimento;
	}

	public void setProximoMovimento(boolean proximoMovimento) {
		this.proximoMovimento = proximoMovimento;
	}

	public boolean isAnteriorMovimento() {
		return anteriorMovimento;
	}

	public void setAnteriorMovimento(boolean anteriorMovimento) {
		this.anteriorMovimento = anteriorMovimento;
	}

	public boolean isProximaFaixa() {
		return proximaFaixa;
	}

	public void setProximaFaixa(boolean proximaFaixa) {
		this.proximaFaixa = proximaFaixa;
	}

	public boolean isAnteriorFaixa() {
		return anteriorFaixa;
	}

	public void setAnteriorFaixa(boolean anteriorFaixa) {
		this.anteriorFaixa = anteriorFaixa;
	}

	public boolean isCancelarExercicio() {
		return cancelarExercicio;
	}

	public void setCancelarExercicio(boolean cancelarExercicio) {
		this.cancelarExercicio = cancelarExercicio;
	}

}
