package control;

import java.io.File;
import java.io.FileFilter;
import java.util.List;
import java.util.Random;

import javax.swing.JTabbedPane;

import ddd.Config;
import ddd.Exercicio;
import ddd.Faixa;
import ddd.Movimento;

/**
 * 
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

	private File[] filesGritos;

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

	public Aula() {
		config = getConfig();
		player = new WavPlayer();
		random = new Random();
		faixas = new Faixa().getTodasAsFaixas();
		exercicios = new Exercicio().getTodosOsExercicios();
	}

	@Override
	public void run() {
		/*
		 * Loop do Exercicio 2 séries de cada exercicio
		 */
		int serie = 0;
		for (int i = 0; i < exercicios.size(); serie++) {
			System.out
					.println("Exercicio: " + exercicios.get(i).getDescricao());
			System.out.println("Serie: " + serie + 1);

			try {
				exercicios.get(i).setConfig(config);
				exercicios.get(i).iniciar();

			} catch (Exception e) {
				e.printStackTrace();
			}

			espere(config.getTempoDescansoCurto());

			if (serie == 1) {
				i++;
				serie = 0;
			}
		}
		System.exit(0);

		/*
		 * TODO: Continuar... Loop de Faixa
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
			reproduzirSom(config.getPathAtencao());
			System.out.println("*** Fim do Descanso ***");
		}
	}

	private Config getConfig() {
		return new Config().getByPerfil("default");
	}

	private void grito() {
		if (filesGritos == null)
			filesGritos = listarArquivos(config.getPathComando(), ".wav");

		reproduzirSom(filesGritos[(this.random.nextInt(filesGritos.length) + 1)]);
	}

	// lista os arquivos a partide de determinada extensão
	public File[] listarArquivos(String caminhoDiretorio, final String extensao) {
		File F = new File(caminhoDiretorio);

		File[] files = F.listFiles(new FileFilter() {

			public boolean accept(File pathname) {
				return pathname.getName().toLowerCase().endsWith(extensao);
			}
		});

		return files;
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

	private void reproduzirSom(File file) {
		verificarSePausaSolicitada();
		player.play(file);
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
