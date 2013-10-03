package control;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Classe que executa um arquivo wav especificado pelo seu path.
 * 
 * @author Daniel Bonfim <daniel.fb88@gmail.com>
 * @since 14/08/2013
 * @version 1.0
 * 
 */
public class WavPlayer {

	private String wavPath;
	private File file;
	private SourceDataLine sourceDataLine;
	private AudioInputStream audioInputStream;
	private AudioFormat audioFormat;

	/**
	 * Retorna path do ultimo wav executado.
	 * 
	 * @return Path do ultimo wav executado.
	 */
	public String getLastWavPath() {
		return this.wavPath;
	}
	
	public void play(File file) {
		this.file = file;
		sourceDataLine = null;
		audioInputStream = null;
		audioFormat = null;

		try {
			// Cria um stream de entrada do arquivo
			AudioInputStream wav_audioInputStream = AudioSystem.getAudioInputStream(file);

			// Seleciona o formato do arquivo de audio
			AudioFormat wav_baseFormat = wav_audioInputStream.getFormat();

			// Configura a decodificação
			this.audioFormat =
					new AudioFormat(
							AudioFormat.Encoding.PCM_SIGNED,

							// Encoding to Sample rate (same as base format use
							wav_baseFormat.getSampleRate(),

							// sample size in bits);
							16,

							// # of Chanels
							wav_baseFormat.getChannels(),

							// Frame size
							wav_baseFormat.getChannels() * 2,

							// Frame rate
							wav_baseFormat.getSampleRate(),

							// Big endian
							false
					);

			this.audioInputStream = AudioSystem.getAudioInputStream(this.audioFormat, wav_audioInputStream);

			DataLine.Info wav_info =
					new DataLine.Info(
							SourceDataLine.class,
							this.audioFormat
					);

			this.sourceDataLine = (SourceDataLine) AudioSystem.getLine(wav_info);

			/**
			 * Executando
			 */
			this.sourceDataLine.open(this.audioFormat);

			byte[] data = new byte[4096];

			// Start
			this.sourceDataLine.start();

			int nBytesRead;

			// Toca enquanto a música não acaba
			while ((nBytesRead = audioInputStream.read(data, 0, data.length)) != -1) {
				sourceDataLine.write(data, 0, nBytesRead);
			}

			// Stop
			this.sourceDataLine.drain();
			this.sourceDataLine.stop();
			this.sourceDataLine.close();
			this.audioInputStream.close();

		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Executar som.
	 */
	public void play(String wavPath) {
		this.file = new File(wavPath);
		this.play(file);
	}

}
