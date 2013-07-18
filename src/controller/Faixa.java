package controller;

public class Faixa {
	private Integer id;
	private ArteMarcial arteMarcial;
	private Integer gub;
	private String descricao;

	public Faixa() {
		super();
	}
	
	public Faixa(Integer id) {
		super();
		this.id = id;
	}

	public Faixa(Integer id, ArteMarcial arteMarcial, Integer gub,
			String descricao) {
		super();
		this.id = id;
		this.arteMarcial = arteMarcial;
		this.gub = gub;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ArteMarcial getArteMarcial() {
		return arteMarcial;
	}

	public void setArteMarcial(ArteMarcial arteMarcial) {
		this.arteMarcial = arteMarcial;
	}

	public Integer getGub() {
		return gub;
	}

	public void setGub(Integer gub) {
		this.gub = gub;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((arteMarcial == null) ? 0 : arteMarcial.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((gub == null) ? 0 : gub.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Faixa other = (Faixa) obj;
		if (arteMarcial == null) {
			if (other.arteMarcial != null)
				return false;
		} else if (!arteMarcial.equals(other.arteMarcial))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (gub == null) {
			if (other.gub != null)
				return false;
		} else if (!gub.equals(other.gub))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
