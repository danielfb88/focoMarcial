package ddd;

public class Movimento {
	private Integer id;
	private Faixa faixa;
	private String descricao;
	private String observacao;
	private Integer qtdRepeticao;
	private Integer intervaloSegundos;
	private String voz_path;

	public Movimento() {
		super();
	}
	
	public Movimento(Integer id) {
		super();
		this.id = id;
	}

	public Movimento(Integer id, Faixa faixa, String descricao,
			String observacao, Integer qtdRepeticao, Integer intervaloSegundos,
			String voz_path) {
		super();
		this.id = id;
		this.faixa = faixa;
		this.descricao = descricao;
		this.observacao = observacao;
		this.qtdRepeticao = qtdRepeticao;
		this.intervaloSegundos = intervaloSegundos;
		this.voz_path = voz_path;
	}

	public Integer getId() {
		return id;
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

	public Integer getQtdRepeticao() {
		return qtdRepeticao;
	}

	public void setQtdRepeticao(Integer qtdRepeticao) {
		this.qtdRepeticao = qtdRepeticao;
	}

	public Integer getIntervaloSegundos() {
		return intervaloSegundos;
	}

	public void setIntervaloSegundos(Integer intervaloSegundos) {
		this.intervaloSegundos = intervaloSegundos;
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
		result = prime * result + ((faixa == null) ? 0 : faixa.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((intervaloSegundos == null) ? 0 : intervaloSegundos
						.hashCode());
		result = prime * result
				+ ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result
				+ ((qtdRepeticao == null) ? 0 : qtdRepeticao.hashCode());
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
		if (faixa == null) {
			if (other.faixa != null)
				return false;
		} else if (!faixa.equals(other.faixa))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (intervaloSegundos == null) {
			if (other.intervaloSegundos != null)
				return false;
		} else if (!intervaloSegundos.equals(other.intervaloSegundos))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (qtdRepeticao == null) {
			if (other.qtdRepeticao != null)
				return false;
		} else if (!qtdRepeticao.equals(other.qtdRepeticao))
			return false;
		if (voz_path == null) {
			if (other.voz_path != null)
				return false;
		} else if (!voz_path.equals(other.voz_path))
			return false;
		return true;
	}

}
