package ddd;

import java.util.List;

import dao.MovimentoDAO;

/**
 * DDD da Faixa
 * 
 * @author Daniel Bonfim <daniel.fb88@gmail.com>
 * @since 03/08/2013
 * @version 1.0
 * 
 */
public class Faixa {
	/**
	 * Id
	 */
	private int id;

	/**
	 * Arte Marcial
	 */
	private ArteMarcial arteMarcial;

	/**
	 * Identiticação hierarquica na AM
	 */
	private int gub;

	/**
	 * Cor da faixa
	 */
	private String descricao;

	/**
	 * Endereço do arquivo de som da faixa
	 */
	private String path;

	/**
	 * DAO Movimento
	 */
	private MovimentoDAO movimentoDAO = new MovimentoDAO();

	/**
	 * Lista de Movimentos da faixa
	 */
	private List<Movimento> movimentos;

	public Faixa() {
		super();
	}

	public Faixa(Integer id) {
		super();
		this.id = id;
	}

	public Faixa(Integer id, ArteMarcial arteMarcial, Integer gub,
			String descricao, String path) {
		super();
		this.id = id;
		this.arteMarcial = arteMarcial;
		this.gub = gub;
		this.descricao = descricao;
		this.path = path;
	}

	public Faixa(Integer id, ArteMarcial arteMarcial, Integer gub,
			String descricao, String path, List<Movimento> movimentos) {
		super();
		this.id = id;
		this.arteMarcial = arteMarcial;
		this.gub = gub;
		this.descricao = descricao;
		this.path = path;
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
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<Movimento> getMovimentos() {
		return movimentos;
	}

	public void setMovimentos(List<Movimento> movimentos) {
		this.movimentos = movimentos;
	}

	/**
	 * Obtém uma lista com todos os movimentos desta faixa
	 * 
	 * @return Lista de Movimentos
	 */
	public List<Movimento> getTodosOsMovimentos() {
		List<Movimento> movimentos = movimentoDAO.getMovimentos(this.id);

		for (Movimento movimento : movimentos) {
			movimento.setFaixa(this);
		}

		this.movimentos = movimentos;
		return movimentos;
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
				+ ((path == null) ? 0 : path.hashCode());
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
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		return true;
	}

}
