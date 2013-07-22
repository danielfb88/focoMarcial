package ddd;

public class Movimento {
	private int id;
	private Faixa faixa;
	private String descricao;
	private String observacao;
	private int qtdRepeticao;
	private int intervaloSegundos;
	private int eh_golpe;
	private String voz_path;

	public Movimento() {
		super();
	}
	
	public Movimento(Integer id) {
		super();
		this.id = id;
	}

	public Movimento(Integer id, Faixa faixa, String descricao,
			String observacao, int qtdRepeticao, int intervaloSegundos,
			int eh_golpe, String voz_path) {
		super();
		this.id = id;
		this.faixa = faixa;
		this.descricao = descricao;
		this.observacao = observacao;
		this.qtdRepeticao = qtdRepeticao;
		this.intervaloSegundos = intervaloSegundos;
		this.eh_golpe = eh_golpe;
		this.voz_path = voz_path;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Faixa getFaixa() {
		return faixa;
	}

	public void setFaixa(Faixa faixa) {
		this.faixa = faixa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getQtdRepeticao() {
		return qtdRepeticao;
	}

	public void setQtdRepeticao(int qtdRepeticao) {
		this.qtdRepeticao = qtdRepeticao;
	}

	public int getIntervaloSegundos() {
		return intervaloSegundos;
	}

	public void setIntervaloSegundos(int intervaloSegundos) {
		this.intervaloSegundos = intervaloSegundos;
	}

	public int getEh_golpe() {
		return eh_golpe;
	}

	public void setEh_golpe(int eh_golpe) {
		this.eh_golpe = eh_golpe;
	}

	public String getVoz_path() {
		return voz_path;
	}

	public void setVoz_path(String voz_path) {
		this.voz_path = voz_path;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + eh_golpe;
		result = prime * result + ((faixa == null) ? 0 : faixa.hashCode());
		result = prime * result + id;
		result = prime * result + intervaloSegundos;
		result = prime * result
				+ ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + qtdRepeticao;
		result = prime * result
				+ ((voz_path == null) ? 0 : voz_path.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimento other = (Movimento) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (eh_golpe != other.eh_golpe)
			return false;
		if (faixa == null) {
			if (other.faixa != null)
				return false;
		} else if (!faixa.equals(other.faixa))
			return false;
		if (id != other.id)
			return false;
		if (intervaloSegundos != other.intervaloSegundos)
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (qtdRepeticao != other.qtdRepeticao)
			return false;
		if (voz_path == null) {
			if (other.voz_path != null)
				return false;
		} else if (!voz_path.equals(other.voz_path))
			return false;
		return true;
	}

}
