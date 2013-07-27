package control;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

import ddd.ArteMarcial;
import ddd.Faixa;
import ddd.Movimento;

/**
 * TODO:
 *  
 * 2) Refatorar
 * 3) GUI
 * 4) Implementar Thread para reproduzir músicas do Ensembre Nipponia
 * 
 * 
 */
public class Aula extends Thread {
	private ArteMarcial arteMarcial;
	private List<Faixa> faixas;

	private String comandoDiretorioPath = "core/sound/comando/";
	private String contagemDiretorioPath = "core/sound/contagem/";
	
	private boolean pausar;
	
	public Aula(ArteMarcial arteMarcial, List<Faixa> faixas) {
		super();
		this.arteMarcial = arteMarcial;
		this.faixas = faixas;

		if (this.faixas == null)
			throw new RuntimeException("Faixas Nulas.");
	}

	@Override
	public void run() {
		Random random = new Random();

		reproduzirSom(this.arteMarcial.getVoz_path());
		exibirConsoleDestaque("ARTE MARCIAL", this.arteMarcial.getDescricao());

		// Faixa
		for (int i = 0; i < faixas.size(); i++) {
			espere(5);

			fazerExercicio(Exercicio.ABDOMINAL);
			
			espere(2);

			reproduzirSom(faixas.get(i).getVoz_path());
			exibirConsoleDestaque("FAIXA", faixas.get(i).getDescricao());

			espere(4);

			List<Movimento> movimentos = faixas.get(i).getMovimentos();
			
			// Movimento
			for (int j = 0; j < movimentos.size(); j++) {
				verificarSePausaSolicitada();
				espere(2);

				reproduzirSom(movimentos.get(j).getVoz_path());
				System.out.println("\n NOME DO MOVIMENTO: " + movimentos.get(j).getDescricao());

				espere(3);

				int qtdRepeticaoMovimento = movimentos.get(j).getQtdRepeticao();
				int intervaloSegundosMovimento = movimentos.get(j).getIntervaloSegundos();

				// Repetições
				for (int repeticaoAtual = 0; repeticaoAtual < qtdRepeticaoMovimento; repeticaoAtual++) {
					verificarSePausaSolicitada();

					reproduzirSom(this.comandoDiretorioPath + "grito" + (random.nextInt(3) + 1) + ".wav");
					System.out.println("GRITO!");
					System.out.println(repeticaoAtual);

					espere(intervaloSegundosMovimento);
				}
				
				if (movimentos.get(j).getEh_golpe() == 1) {
					
					// Exercicio
					int n = random.nextInt(movimentos.size() - 1);
					if ((n == j) || (n == ((int) ((movimentos.size() / 2) - 1)))) { // Probabilidade maior
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
	 * Quando executado, fica escutando a variável pausar para verificar se deve pausar a thread.
	 */
	private void verificarSePausaSolicitada() {
		if(pausar)
			System.out.println("*** PAUSADO ***");
		
		while (pausar) {
			synchronized (this) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			if(pausar == false)
				System.out.println("*** CONTINUANDO ***");
		}
	}

	/**
	 * Exibe a informação com destaque no console.
	 * 
	 * @param descricao
	 *            Título
	 * @param valor
	 *            Conteúdo
	 */
	private void exibirConsoleDestaque(String descricao, String valor) {
		System.out.println("----------------------------------");
		System.out.println(descricao + ": " + valor);
		System.out.println("----------------------------------");
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
		exibirConsoleDestaque("Descansar", null);
		reproduzirSom(descanso.getVozPathDescansar());
		espere(descanso.getSegundos());
		
		System.out.println("*** Fim do Descanso ***");
		reproduzirSom(descanso.getVozPathAtencao());
	}

	/**
	 * Exercícios
	 * 
	 * @param nome
	 * @param quantidade
	 */
	private void fazerExercicio(Exercicio exercicio) {
		this.reproduzirSom(exercicio.getVozPath());
		this.espere(2);
		int x = 1;

		for (int i = 0; i < exercicio.getQuantidade(); i++) {
			verificarSePausaSolicitada();
			this.reproduzirSom(this.contagemDiretorioPath + (x) + ".wav");
			this.espere(exercicio.getIntervaloSegundos());

			if (x == 10)
				x = 0;

			x++;
		}
	}

	/**
	 * TODO: Refatorar. TODO: Pesquisar como fazer o mesmo para arquivos .spx
	 * 
	 * @param voz_path
	 */
	private void reproduzirSom(String voz_path) {
		File track = new File(voz_path);
		SourceDataLine line = null;
		AudioInputStream din = null;
		AudioFormat decodeFormat = null;

		try {
			// Cria um stream de entrada do arquivo
			AudioInputStream ais = AudioSystem.getAudioInputStream(track);
			// Seleciona o formato do arquivo de audio
			AudioFormat baseFormat = ais.getFormat();
			// Configura a decodificação
			decodeFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, // Encoding
																			// to
																			// use
					baseFormat.getSampleRate(), // Sample rate (same as base
												// format)
					16, // sample size in bits);
					baseFormat.getChannels(), // # of Chanels
					baseFormat.getChannels() * 2, // Frame size
					baseFormat.getSampleRate(), // Frame rate
					false // Big endian
			);

			din = AudioSystem.getAudioInputStream(decodeFormat, ais);
			DataLine.Info info = new DataLine.Info(SourceDataLine.class,
					decodeFormat);

			line = (SourceDataLine) AudioSystem.getLine(info);
			line.open(decodeFormat);

			byte[] data = new byte[4096];
			// Start
			line.start();

			int nBytesRead;

			// Toca enquanto a música não acaba
			while ((nBytesRead = din.read(data, 0, data.length)) != -1) {
				line.write(data, 0, nBytesRead);
			}

			// Stop
			line.drain();
			line.stop();
			line.close();
			din.close();

		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

}
