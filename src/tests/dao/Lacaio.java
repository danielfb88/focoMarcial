package tests.dao;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Random;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Lacaio {

	private static void tentativa1() {
		AudioClip somLaser = null;

		try {
			somLaser = Applet.newAudioClip(new File(
					"sound/movimentos/laser.wav").toURI().toURL());
			somLaser.loop();
			System.out.println("oi");

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	private static void tentativa2() {
		Clip clip;
		AudioInputStream audioIn;

		File wav = new File("sound/movimentos/laser.wav");

		try {
			audioIn = AudioSystem.getAudioInputStream(new BufferedInputStream(
					new FileInputStream(wav)));
			clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
			// clip.loop(Clip.LOOP_CONTINUOUSLY);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	private static void tentativa3() {
		Clip clip;
		AudioInputStream audioIn = null;

		File wav = new File("sound/movimentos/laser.wav");

		try {
			audioIn = AudioSystem.getAudioInputStream(wav);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		AudioFormat format = audioIn.getFormat();
		SourceDataLine auline = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

		try {
			auline = (SourceDataLine) AudioSystem.getLine(info);
			auline.open(format);

		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		auline.start();
	}
	
	private static void tentativa4() {
		File track = new File("sound/movimentos/laser.wav");
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
	
	public static void random() {
		Random random = new Random();
		for(int i = 0; i<10; i++) {
			System.out.println(random.nextInt(3) + 1);
		}
	}

	public static void main(String[] args) {
		Toolkit.getDefaultToolkit().beep();     
	}

}
