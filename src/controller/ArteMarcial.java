package controller;

import java.util.List;

public class ArteMarcial {
	private Integer id;
	private String descricao;
	private List<Faixa> faixas;
	
	public ArteMarcial() {
		super();
	}
	
	public ArteMarcial(Integer id) {
		super();
		this.id = id;
	}

	public ArteMarcial(Integer id, String descricao, List<Faixa> faixas) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.faixas = faixas;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Faixa> getFaixas() {
		return faixas;
	}
	public void setFaixas(List<Faixa> faixas) {
		this.faixas = faixas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((faixas == null) ? 0 : faixas.hashCode());
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
		ArteMarcial other = (ArteMarcial) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (faixas == null) {
			if (other.faixas != null)
				return false;
		} else if (!faixas.equals(other.faixas))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
