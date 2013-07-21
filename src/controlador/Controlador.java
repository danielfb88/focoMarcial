package controlador;

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
 * Preciso de:
 * 
 * 	1) Gravar todas os Vozes.
 *  2) Pausar a tread para descanço a qualquer momento.
 *  
 *  
 */
public class Controlador extends Thread {
	private ArteMarcial arteMarcial;
	private List<Faixa> faixas;
	private String[] exercicioPath;
	
	public Controlador(ArteMarcial arteMarcial, List<Faixa> faixas) {
		super();
		this.arteMarcial = arteMarcial;
		this.faixas = faixas;
		this.exercicioPath = new String[] {"sound/exercicio/flexao.wav", "sound/exercicio/abdominal.wav"};
		
		if(this.faixas == null)
			throw new RuntimeException("Faixas Nulas.");
	}
	
	@Override
	public void run() {
		Random random = new Random();
		
		reproduzirSom(this.arteMarcial.getVoz_path());
		exibirConsoleDestaque("ARTE MARCIAL", this.arteMarcial.getDescricao());
		
		// Início de cada faixa
		for(int i=0; i<faixas.size(); i++) {
			espere(5);
			
			// Abdominal
			exercicio(1, 5, 0);
			
			reproduzirSom(faixas.get(i).getVoz_path());
			exibirConsoleDestaque("FAIXA", faixas.get(i).getDescricao());
			
			espere(4);
			
			// Início da sequência de movimentos
			List<Movimento> movimentos = faixas.get(i).getMovimentos();
			for(int j=0; j<movimentos.size(); j++) {
				espere(2);
				
				// Sorteio para fazer flexão antes deste movimento
				int n = random.nextInt(movimentos.size() - 1);
				if(j == n) {
					exercicio(0, 10, 1);
					espere(2);
				}
				
				reproduzirSom(movimentos.get(j).getVoz_path());
				System.out.println("\n NOME DO MOVIMENTO: " + movimentos.get(j).getDescricao());
				
				espere(3);

				// Grito em cada movimento
				int qtdRepeticaoMovimento = movimentos.get(j).getQtdRepeticao();
				int intervaloSegundosMovimento = movimentos.get(j).getIntervaloSegundos();
				
				for(int repeticaoAtual=0; repeticaoAtual<qtdRepeticaoMovimento; repeticaoAtual++) {		
					// Quantidade de arquivos de audio nomeados como: grito1.wav, grito2.wav...
					
					int numeroAleatorio = random.nextInt(3) + 1;
					reproduzirSom("sound/grito/grito" + numeroAleatorio + ".wav");
					System.out.println("GRITO!");
					
					espere(intervaloSegundosMovimento);
				}
			}
			
		}
	}
	
	/**
	 * Exibe a informação com destaque no console.
	 * 
	 * @param descricao Título
	 * @param valor Conteúdo
	 */
	private void exibirConsoleDestaque(String descricao, String valor) {
		System.out.println("----------------------------------");
		System.out.println(descricao + ": " + valor);
		System.out.println("----------------------------------");
	}
	
	/**
	 * Espera a quantidade especificada de tempo em segundos.
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
	 * Exercícios
	 * 
	 * TODO: refatorar. Para String nome use um Enum
	 * 
	 * @param nome
	 * @param quantidade
	 */
	private void exercicio(int exercicio, int quantidade, int intervaloSegundos) {
		this.reproduzirSom(this.exercicioPath[exercicio]);
		this.espere(2);
		int x = 1;
		
		for(int i=1; i<=quantidade; i++) {
			this.reproduzirSom("sound/exercicio/" + (x) + ".wav");
			this.espere(intervaloSegundos);
			
			if(x == 10)
				x = 0;
			
			x++;
		}
	}
	
	/**
	 * TODO: Por que não funciona?
	 */
	private void beep() {
		Toolkit.getDefaultToolkit().beep();
	}
	
	/**
	 * TODO: Refatorar. 
	 * TODO: Pesquisar como fazer o mesmo para arquivos .spx
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
			decodeFormat = new AudioFormat(
					AudioFormat.Encoding.PCM_SIGNED, // Encoding to use
					baseFormat.getSampleRate(), // Sample rate (same as base format)
					16, // sample size in bits);
					baseFormat.getChannels(), // # of Chanels
					baseFormat.getChannels()*2, // Frame size
					baseFormat.getSampleRate(), // Frame rate
					false // Big endian
				);
			
			din = AudioSystem.getAudioInputStream(decodeFormat, ais);
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, decodeFormat);
			
			line = (SourceDataLine) AudioSystem.getLine(info);
			line.open(decodeFormat);
			
			byte[] data = new byte[4096];
			// Start
			line.start();
			
			int nBytesRead;
			
			// Toca enquanto a música não acaba
			while((nBytesRead = din.read(data, 0, data.length)) != -1) {
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
	
	public static void main(String[] args) {
		ArteMarcial arteMarcial = new ArteMarcial().getById(1);
		
		List<Faixa> faixasSelecionadas = arteMarcial.getFaixasEntreGubs(10, 9);
//		List<Faixa> faixasSelecionadas = arteMarcial.getTodasAsFaixas();
		Controlador c = new Controlador(arteMarcial, faixasSelecionadas);
		c.start();		
	}

}
