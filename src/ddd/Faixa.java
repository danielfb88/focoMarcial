package ddd;

import java.util.List;

public class Faixa {
	private int id;
	private ArteMarcial arteMarcial;
	private int gub;
	private String descricao;
	private String voz_path;
	
	private List<Movimento> movimentos;
	
	public Faixa() {
		super();
	}
	
	public Faixa(Integer id) {
		super();
		this.id = id;
	}

	public Faixa(Integer id, ArteMarcial arteMarcial, Integer gub,
			String descricao, String voz_path) {
		super();
		this.id = id;
		this.arteMarcial = arteMarcial;
		this.gub = gub;
		this.descricao = descricao;
		this.voz_path = voz_path;
	}

	public Faixa(Integer id, ArteMarcial arteMarcial, Integer gub,
			String descricao, String voz_path, List<Movimento> movimentos) {
		super();
		this.id = id;
		this.arteMarcial = arteMarcial;
		this.gub = gub;
		this.descricao = descricao;
		this.voz_path = voz_path;
		this.movimentos = movimentos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArteMarcial getArteMarcial() {
		return arteMarcial;
	}

	public void setArteMarcial(ArteMarcial arteMarcial) {
		this.arteMarcial = arteMarcial;
	}

	public int getGub() {
		return gub;
	}

	public void setGub(int gub) {
		this.gub = gub;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getVoz_path() {
		return voz_path;
	}

	public void setVoz_path(String voz_path) {
		this.voz_path = voz_path;
	}

	public List<Movimento> getMovimentos() {
		return movimentos;
	}

	public void setMovimentos(List<Movimento> movimentos) {
		this.movimentos = movimentos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((arteMarcial == null) ? 0 : arteMarcial.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + gub;
		result = prime * result + id;
		result = prime * result
				+ ((movimentos == null) ? 0 : movimentos.hashCode());
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
		if (gub != other.gub)
			return false;
		if (id != other.id)
			return false;
		if (movimentos == null) {
			if (other.movimentos != null)
				return false;
		} else if (!movimentos.equals(other.movimentos))
			return false;
		if (voz_path == null) {
			if (other.voz_path != null)
				return false;
		} else if (!voz_path.equals(other.voz_path))
			return false;
		return true;
	}

}
