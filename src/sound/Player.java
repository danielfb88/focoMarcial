package sound;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.SourceDataLine;

/**
 * Apenas executa o Track.
 * 
 * Código retirado do endereço: http://www.guj.com.br/
 * java/76160-como-executar-aquivos-de-som-wav-mp3-etc-numa-aplicacao-java/2
 * 
 * 
 * @author Modificado por Daniel Bonfim <daniel.fb88@gmail.com>
 * @since 08/08/2013
 * @version 1.0
 * 
 */
public class Player implements Runnable {

	private boolean waiting = false;
	private SourceDataLine line;
	private AudioInputStream din;
	private AudioFormat decodeFormat;

	public Player() {
		super();
	}

	public Player(Track track) {
		setTrack(track);

	}

	public void setTrack(Track track) {
		this.line = track.getLine();
		this.din = track.getDin();
		this.decodeFormat = track.getDecodeFormat();
	}

	// metodo para pausar a thread.. a propria thread deve se parar, e não uma
	// thread externa
	public synchronized void pausar() {
		waiting = true;
	}

	// metodo para reiniciar uma thread
	public void continuar() {
		waiting = false;
		synchronized (this) {
			this.notify();
		}
	}

	// aqui executa a musica
	public void run() {
		try
		{
			if (line != null)
			{
				line.open(decodeFormat);
				byte[] data = new byte[4096];
				// Start
				line.start();
				int nBytesRead;
				// toca enquanto a musica não acaba
				while ((nBytesRead = din.read(data, 0, data.length)) != -1)
				{
					// se for solicitado para para a propria thread para
					while (waiting) {
						synchronized (this) {
							wait(); // Note que essa thread mesmo chama o wait
						}
					}
					line.write(data, 0, nBytesRead);
				}
				// Stop
				line.drain();
				line.stop();
				line.close();
				din.close();
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
}