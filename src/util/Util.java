package util;

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
		long t0 = System.currentTimeMillis();
		
		while (true) {
			if((System.currentTimeMillis() - t0) >= (segundos * 1000)) {
				break;
			}
		}
	}

}
