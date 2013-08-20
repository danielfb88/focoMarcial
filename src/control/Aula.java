package control;

import java.util.List;
import java.util.Random;

import javax.swing.JTabbedPane;

import ddd.ArteMarcial;
import ddd.Faixa;
import ddd.Movimento;

/**
 * TODO: DIVIDA O PROGRAMA EM PEQUENAS PARTES. CRIE CLASSES REAPROVEITAVEIS.
 * TODO: CONTINUAR REFATORAR
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
	 * Arte Marcial
	 */
	private ArteMarcial arteMarcial;

	/**
	 * Lista das faixas da Arte MArcial
	 */
	private List<Faixa> faixas;

	/**
	 * TabbedPane contendo as faixas
	 */
	private JTabbedPane tabbedPane;

	/**
	 * Tocador Wav
	 */
	private WavPlayer player;

	/**
	 * Path do nome dos golpes
	 */
	private String comandoDiretorioPath;

	/**
	 * Path da contagem
	 */
	private String contagemDiretorioPath;

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

	/**
	 * Aula
	 * 
	 * @param arteMarcial
	 *            Objeto ArteMarcial com as faixas e movimentos já definidos.
	 */
	public Aula(ArteMarcial arteMarcial) {
		player = new WavPlayer();

		this.arteMarcial = arteMarcial;
		this.faixas = arteMarcial.getTodasAsFaixas();

		comandoDiretorioPath = "core/sound/comando/";
		contagemDiretorioPath = "core/sound/contagem/";
	}

	@Override
	public void run() {
		Random random = new Random();
		reproduzirSom(this.arteMarcial.getPath());

		/*
		 * Loop de Faixa
		 */
		for (int i = 0; i < faixas.size(); i++) {

			// Mudar pane a cada nova faixa
			tabbedPane.setSelectedIndex(i);
			espere(5);
			fazerExercicio(Exercicio.ABDOMINAL);
			espere(2);
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
				int intervaloSegundosMovimento = movimentos.get(j).getIntervaloSegundos();

				/*
				 * Loop de Repetições do movimento
				 */
				for (int repeticaoAtual = 0; repeticaoAtual < qtdRepeticaoMovimento; repeticaoAtual++) {
					reproduzirSom(this.comandoDiretorioPath + "grito" + (random.nextInt(3) + 1) + ".wav");
					espere(intervaloSegundosMovimento);
				}

				if (movimentos.get(j).getEh_golpe() == 1) {

					// Exercicio
					int n = random.nextInt(movimentos.size() - 1);
					if ((n == j) || (n == ((int) ((movimentos.size() / 2) - 1)))) { // Probabilidade
																					// maior
						fazerExercicio((random.nextBoolean() == true) ? Exercicio.AGACHAMENTO_APTCHAGUI : Exercicio.FLEXAO);
						espere(2);
					}

					// Descanso
					if (j == (int) movimentos.size() / 2) {
						descansar(Descanso.POUCO);
					}
				}
			}

			descansar(Descanso.ALONGAMENTO);
		}
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

	/**
	 * Descansar
	 * 
	 * @param segundos
	 */
	private void descansar(Descanso descanso) {
		player.play(descanso.getVozPathDescansar());
		espere(descanso.getSegundos());

		System.out.println("*** Fim do Descanso ***");
		player.play(descanso.getVozPathAtencao());
	}

	/**
	 * Exercícios
	 * 
	 * @param nome
	 * @param quantidade
	 */
	private void fazerExercicio(Exercicio exercicio) {
		reproduzirSom(exercicio.getVozPath());
		espere(2);
		int x = 1;

		for (int i = 0; i < exercicio.getQuantidade(); i++) {

			if (cancelarExercicio) {
				cancelarExercicio = false;
				break;
			}

			player.play(this.contagemDiretorioPath + (x) + ".wav");
			espere(exercicio.getIntervaloSegundos());

			if (x == 10)
				x = 0;

			x++;
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
