package sound;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;
import sound.IPlayer;

/**
 * Classe que executa arquivo mp3.
 * 
 * @author Daniel Bonfim <daniel.fb88@gmail.com>
 * @since 12/10/2013
 * @version 1.0
 * 
 */
public class Mp3Player implements IPlayer {

	private Player player;

	public void play(File file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			this.player = new Player(bis);
			this.player.play();
			
		} catch (Exception e) {
			System.out.println("Problema ao tocar " + file);
			e.printStackTrace();
		}
	}
	
	public void play(String path) {
		this.play(new File(path));
	}
}
