package control;

/**
 * Descanso
 * 
 * @author Daniel Bonfim <daniel.fb88@gmail.com>
 * @version 1.0
 * @since 22-07-2013
 *
 */
public enum Descanso {
	POUCO(30, "core/sound/exercicios/descansar.wav"), 
	MEDIO(60, "core/sound/exercicios/descansar.wav"), 
	MUITO(60*2, "core/sound/exercicios/descansar.wav"),
	ALONGAMENTO(60, "core/sound/exercicios/alongamento.wav");

	Descanso(int segundos, String vozPathDescansar) {
		this.segundos = segundos;
		this.vozPathDescansar = vozPathDescansar;
		this.vozPathAtencao = "core/sound/exercicios/atencao.wav";
	}

	private int segundos;
	private String vozPathDescansar;
	private String vozPathAtencao;

	public int getSegundos() {
		return segundos;
	}

	public String getVozPathDescansar() {
		return vozPathDescansar;
	}

	public String getVozPathAtencao() {
		return vozPathAtencao;
	}
}
