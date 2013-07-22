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
	POUCO(60, "core/sound/exercicios/descansar.wav"), 
	MEDIO(60*2, "core/sound/exercicios/descansar.wav"), 
	MUITO(60*3, "core/sound/exercicios/descansar.wav"),
	ALONGAMENTO(60*3, "core/sound/exercicios/alongamento.wav");

	Descanso(int segundos, String vozPath) {
		this.segundos = segundos;
		this.vozPath = vozPath;
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
