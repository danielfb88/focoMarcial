package control;

public enum Exercicio {
	ABDOMINAL(100, 0, "core/sound/exercicios/abdominal.wav"), 
	FLEXAO(15, 1, "core/sound/exercicios/flexao.wav"), 
	AGACHAMENTO_APTCHAGUI(20, 2, "core/sound/exercicios/agachamento_aptchagui.wav");

	Exercicio(int quantidade, int intervaloSegundos, String vozPath) {
		this.quantidade = quantidade;
		this.intervaloSegundos = intervaloSegundos;
		this.vozPath = vozPath;
	}

	private int quantidade;
	private int intervaloSegundos;
	private String vozPath;

	public int getQuantidade() {
		return quantidade;
	}

	public int getIntervaloSegundos() {
		return intervaloSegundos;
	}
	
	public String getVozPath() {
		return vozPath;
	}
}
