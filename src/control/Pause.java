package control;

import java.util.Scanner;

/**
 * (Sim, eu sei que isso é horrivel)
 * 
 * Thread temporária enquanto não temos uma GUI para funcionar como um evento e ficar escutando a entrada para o usuário
 * e assim parar ou continuar a Thread
 * 
 * @author daniel
 *
 */
public class Pause extends Thread {
	private Aula aula;
	
	public Pause(Aula aula) {
		this.aula = aula;
	}

	@Override
	public void run() {
		while (true) {
			new Scanner(System.in).nextLine();
			botao();
		}
		
	}
	
	private void botao() {
		if(aula.isPausaSolicitada() == false) {
			aula.pausar();
		} else {
			aula.continuar();
		}
	}

}
