package control;

import java.util.List;

import javax.swing.JTabbedPane;

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
 * @version 1.1
 * 
 */
public class Aula extends Thread {

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
	 * Flag que pausa a Thread
	 */
	private boolean pausar;

	/**
	 * TODO: INSERIR LÓGICA PARA PROXIMO E ANTERIOR DE FAIXA E MOVIMENTO.
	 */
	private boolean proximoMovimento;
	private boolean anteriorMovimento;

	private boolean proximaFaixa;
	private boolean anteriorFaixa;

	private boolean cancelarExercicio;

	private Config config;

	public Aula() {
		config = getConfig();
		player = new WavPlayer();
		faixas = new Faixa().getTodasAsFaixas();
		exercicios = new Exercicio().getTodosOsExercicios();
	}

	@Override
	public void run() {
		/*
		 * Loop do Exercicio. 2 séries para cada
		 */

		for (int i = 0; i < exercicios.size(); i++) {
			exercicios.get(i).setConfig(config);

			for (int serie = 1; serie <= 2; serie++) {
				System.out.println("Exercicio: " + exercicios.get(i).getDescricao());
				System.out.println("Serie: " + serie);

				try {
					exercicios.get(i).iniciar();

				} catch (Exception e) {
					e.printStackTrace();
				}

				espere(config.getTempoDescansoCurto());
			}
			espere(config.getTempoDescansoCurto());

		}

		/*
		 * Loop da faixa
		 */
		for (int i = 0; i < faixas.size(); i++) {

			// Mudar pane a cada nova faixa
			tabbedPane.setSelectedIndex(i);

			espere(5);
			player.play(faixas.get(i).getPath());
			espere(5);

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
			espere(config.getTempoAlongamento());
			
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

	/**
	 * Retorna se foi solicitada à thread a entrar em estado de espera.
	 * 
	 * @return
	 */
	public boolean isPausaSolicitada() {
		return pausar;
	}

	/**
	 * Pausa a Thread
	 */
	public synchronized void pausar() {
		pausar = true;
	}

	/**
	 * Continua a execução da Thread
	 */
	public void continuar() {
		pausar = false;
		synchronized (this) {
			this.notify();
		}
	}

	/**
	 * Espera a quantidade especificada de tempo em segundos.
	 * 
	 * @param segundos
	 */
	private void espere(int segundos) {
		try {
			System.out.println("*** Espere " + segundos + " segundo(s)... \n");
			sleep(segundos * 1000);

		} catch (InterruptedException e1) {
			e1.printStackTrace();
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
