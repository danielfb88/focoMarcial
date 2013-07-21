package controlador;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

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
 * 	
 *  1) Reproduzir som
 *  2) Pausar a tread para descanço a qualquer momento
 *  
 *  
 */
public class Controlador extends Thread {
	private ArteMarcial arteMarcial;
	private List<Faixa> faixas;
	
	public Controlador(ArteMarcial arteMarcial, List<Faixa> faixas) {
		super();
		this.arteMarcial = arteMarcial;
		this.faixas = faixas;
		
		if(this.faixas == null)
			throw new RuntimeException("Faixas Nulas.");
	}
	
	@Override
	public void run() {
		
//		this.reproduzirSom(this.arteMarcial.getVoz_path());
		this.exibirConsoleDestaque("ARTE MARCIAL", this.arteMarcial.getDescricao());
		
		// Início de cada faixa
		for(int i=0; i<faixas.size(); i++) {
			this.espere(5);
			
//			this.reproduzirSom(faixas.get(i).getVoz_path());
			this.exibirConsoleDestaque("FAIXA", faixas.get(i).getDescricao());
			
			this.espere(4);
			
			// Início da sequência de movimentos
			List<Movimento> movimentos = faixas.get(i).getMovimentos();
			for(int j=0; j<movimentos.size(); j++) {
				this.espere(5);
				
//				this.reproduzirSom(movimentos.get(j).getDescricao());
				System.out.println("\n NOME DO MOVIMENTO: " + movimentos.get(j).getDescricao());
				
				this.espere(5);

				// Grito em cada movimento
				int qtdRepeticaoMovimento = movimentos.get(j).getQtdRepeticao();
				int intervaloSegundosMovimento = movimentos.get(j).getIntervaloSegundos();
				
				for(int repeticaoAtual=0; repeticaoAtual<qtdRepeticaoMovimento; repeticaoAtual++) {					
					this.reproduzirSom("sound/movimentos/laser.wav");
					System.out.println("GRITO!");
					
					this.espere(intervaloSegundosMovimento);
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
	 * TODO: Por que não funciona?
	 */
	private void beep() {
		Toolkit.getDefaultToolkit().beep();
	}
	
	/**
	 * TODO: Desenvolver
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
		
//		List<Faixa> faixasSelecionadas = arteMarcial.getFaixasEntreGubs(5, 5);
		List<Faixa> faixasSelecionadas = arteMarcial.getTodasAsFaixas();
		Controlador c = new Controlador(arteMarcial, faixasSelecionadas);
		c.start();		
	}

}
