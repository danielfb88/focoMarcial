package control;

/**
 * Descanso:
 * 	 POUCO = 60 segundos (1 minuto)
 * 	 MEDIO = 120 segundos (2 minutos)
 * 	 MUITO = 180 segundos (3 minutos)
 * 
 * @author Daniel Bonfim <daniel.fb88@gmail.com>
 * @version 1.0
 * @since 22-07-2013
 *
 */
public enum Descanso {
	POUCO(60), 
	MEDIO(60*2), 
	MUITO(60*3);

	Descanso(int segundos) {
		this.segundos = segundos;
		this.vozPath = "core/sound/exercicios/descansar.wav";
	}

	private int segundos;
	private String vozPath;

	public int getSegundos() {
		return segundos;
	}

	public String getVozPath() {
		return vozPath;
	}

}
