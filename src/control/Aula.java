package control;

import java.util.List;
import java.util.Random;

import javax.swing.JTabbedPane;

import ddd.Config;
import ddd.Faixa;
import ddd.Movimento;
import ddd.Exercicio;

/**
 * 
 * Aula com instruções sobre movimentos e exercícios da Arte Marcial
 * selecionada.
 * 
 * @author Daniel Bonfim <daniel.fb88@gmail.com>
 * @since 08/08/2013
 * @version 1.0
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

	private Random random;

	private Config config;

	/**
	 * Aula
	 * 
	 * @param arteMarcial
	 *            Objeto ArteMarcial com as faixas e movimentos já definidos.
	 */
	public Aula() {
		player = new WavPlayer();
		random = new Random();
		config = getConfig();
		faixas = new Faixa().getTodasAsFaixas();

	}

	@Override
	public void run() {
		/*
		 * Loop do Exercicio
		 */
		for (int i = 0; i < exercicios.size(); i++) {
			fazerExercicio(exercicios.get(i));
			espere(config.getTempoDescansoCurto());
		}

		/*
		 * Loop de Faixa
		 */
		for (int i = 0; i < faixas.size(); i++) {

			// Mudar pane a cada nova faixa
			tabbedPane.setSelectedIndex(i);

			espere(5);
			reproduzirSom(faixas.get(i).getPath());
			espere(4);

			List<Movimento> movimentos = faixas.get(i).getMovimentos();

			/*
			 * Loop de Movimento
			 */
			for (int j = 0; j < movimentos.size(); j++) {
				espere(2);
				reproduzirSom(movimentos.get(j).getPath());
				espere(3);

				int qtdRepeticaoMovimento = movimentos.get(j).getQtdRepeticao();
				int intervaloSegundosMovimento = movimentos.get(j)
						.getIntervaloSegundos();

				/*
				 * Loop de Repetições do movimento
				 */
				for (int repeticaoAtual = 0; repeticaoAtual < qtdRepeticaoMovimento; repeticaoAtual++) {
					grito();
					espere(intervaloSegundosMovimento);
				}

			}

			// Descansar
			reproduzirSom(config.getPathDescanso());
			espere(config.getTempoDescansoLongo());
			System.out.println("*** Fim do Descanso ***");
			reproduzirSom(config.getPathAtencao());
		}
	}

	/**
	 * Exercícios
	 * 
	 * @param nome
	 * @param quantidade
	 */
	private void fazerExercicio(Exercicio exercicio) {
		reproduzirSom(exercicio.getPath());
		espere(2);
		int x = 1;

		for (int i = 0; i < exercicio.getQtdRepeticao(); i++) {

			if (cancelarExercicio) {
				cancelarExercicio = false;
				break;
			}

			reproduzirSom(config.getPathContagem() + (x) + ".wav");
			espere(exercicio.getIntervaloSegundos());

			if (x == 10)
				x = 0;

			x++;
		}
	}

	private Config getConfig() {
		return new Config().getByPerfil("default");
	}

	private void grito() {
		reproduzirSom(config.getPathComando() + "grito"
				+ (this.random.nextInt(3) + 1) + ".wav");
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
	 * Quando executado, fica escutando a variável pausar para verificar se deve
	 * pausar a thread.
	 */
	private void verificarSePausaSolicitada() {
		if (pausar)
			System.out.println("*** PAUSADO ***");

		while (pausar) {
			synchronized (this) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			if (pausar == false)
				System.out.println("*** CONTINUANDO ***");
		}
	}

	private void reproduzirSom(String path) {
		verificarSePausaSolicitada();
		player.play(path);
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
