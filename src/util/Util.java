package util;

import java.io.File;
import java.io.FileFilter;

import control.Aula;

/**
 * Métodos estáticos uteis
 * 
 * @author Daniel Bonfim <daniel.fb88@gmail.com>
 * @since 4/10/2013
 * @version 1.0
 * 
 */
public class Util {
	
	public static void tempo(int segundos) {
		try {
			Aula.getInstance().getJFrame().escreverStatus("\n *** Espere " + segundos + " segundo(s)... \n");
			Thread.sleep(segundos * 1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}  
	}

	public static void tempoNoThread(int segundos) {
		long t0 = System.currentTimeMillis();

		while (true) {
			if((System.currentTimeMillis() - t0) >= (segundos * 1000)) {
				break;
			}
		}
	}

	// lista os arquivos a partide de determinada extensão
	public static File[] listarArquivos(String caminhoDiretorio, final String extensao) {
		File F = new File(caminhoDiretorio);

		File[] files = F.listFiles(new FileFilter() {

			public boolean accept(File pathname) {
				return pathname.getName().toLowerCase().endsWith(extensao);
			}
		});

		return files;
	}

}
