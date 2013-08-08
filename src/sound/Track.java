package sound;

import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

/**
 * Extrai os objetos necessários do Track para ser executado por um player.
 * http://www.guj.com.br/java/76160-como-executar-aquivos-de-som-wav-mp3-etc-
 * numa-aplicacao-java/2
 * 
 * @author Modificações por Daniel Bonfim <daniel.fb88@gmail.com>
 * @since 08/08/2013
 * @version 1.0
 * 
 */
public class Track {

	private File track;
	private SourceDataLine sourceDataLine;
	private AudioInputStream audioInputStream;
	private AudioFormat audioFormat;

	public Track() {
		this.track = null;
		this.sourceDataLine = null;
		this.audioInputStream = null;
	}

	public Track(File sound) {
		try {
			// abre arquivo de audio
			this.track = sound;

			// cria um strem de entrada do arquivo
			AudioInputStream baseAudioInputStream = AudioSystem.getAudioInputStream(this.track);

			// seleciona o formato do arquivo de audio
			AudioFormat baseAudioFormat = baseAudioInputStream.getFormat();

			// configura a decodificação
			this.audioFormat =
					new AudioFormat(
							// Encoding to use
							AudioFormat.Encoding.PCM_SIGNED,

							// sample rate (same as base format
							baseAudioFormat.getSampleRate(),

							// sample size in bits (thx to Javazoom)
							16,

							// # of Channels
							baseAudioFormat.getChannels(),

							// Frame Size
							baseAudioFormat.getChannels() * 2,

							// Frame Rate
							baseAudioFormat.getSampleRate(),

							// Big Endian
							false
					);

			this.audioInputStream = AudioSystem.getAudioInputStream(this.audioFormat, baseAudioInputStream);
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, this.audioFormat);
			this.sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public File getTrack() {
		return track;
	}

	public void setTrack(File track) {
		this.track = track;
	}

	public SourceDataLine getLine() {
		return sourceDataLine;
	}

	public void setLine(SourceDataLine line) {
		this.sourceDataLine = line;
	}

	public AudioInputStream getDin() {
		return audioInputStream;
	}

	public void setDin(AudioInputStream din) {
		this.audioInputStream = din;
	}

	public AudioFormat getDecodeFormat() {
		return audioFormat;
	}

	public void setDecodeFormat(AudioFormat decodeFormat) {
		this.audioFormat = decodeFormat;
	}

}