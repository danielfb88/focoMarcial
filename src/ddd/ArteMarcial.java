package ddd;

import java.util.List;

import dao.ArteMarcialDAO;
import dao.FaixaDAO;

/**
 * DDD Arte Marcial
 * 
 * @author Daniel Bonfim <daniel.fb88@gmail.com>
 * @since 03/08/2013
 * @version 1.0
 * 
 */
public class ArteMarcial {
	/**
	 * Id
	 */
	private int id;

	/**
	 * Nome da Arte Marcial
	 */
	private String descricao;

	/**
	 * Endereço do arquivo de som do nome da Arte Marcial
	 */
	private String path;

	/**
	 * Lista das faixas
	 */
	private List<Faixa> faixas;
	
	/**
	 * DAO da Arte Marcial
	 */
	private ArteMarcialDAO arteMarcialDAO = new ArteMarcialDAO();
	
	/**
	 * DAO da Faixa
	 */
	private FaixaDAO faixaDAO = new FaixaDAO();


	public ArteMarcial() {
		super();
	}

	public ArteMarcial(int id) {
		super();
		this.id = id;
	}

	public ArteMarcial(Integer id, String descricao, String path) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.path = path;
	}

	public ArteMarcial(Integer id, String descricao, String path, List<Faixa> faixas) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.path = path;
		this.faixas = faixas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Faixa> getFaixas() {
		return faixas;
	}

	public void setFaixas(List<Faixa> faixas) {
		this.faixas = faixas;
	}

	/**
	 * Obtém a Arte Marcial pelo Id
	 * 
	 * @param id
	 * @return
	 */
	public ArteMarcial getById(int id) {
		ArteMarcial arteMarcial = arteMarcialDAO.getById(id);
		arteMarcial.setFaixas(faixaDAO.getFaixas(arteMarcial.getId()));
		return arteMarcial;
	}

	/**
	 * Obtém todas as faixas desta Arte Marcial
	 * 
	 * @return List<Faixa>
	 */
	public List<Faixa> getTodasAsFaixas() {
		List<Faixa> faixas = faixaDAO.getFaixas(this.id);

		for (Faixa faixa : faixas) {
			faixa.setArteMarcial(this);
		}

		this.faixas = faixas;
		return this.faixas;
	}

	/**
	 * Obtém todas as faixas entre os GUBs especificados.
	 * 
	 * @param gubInicial
	 *            Identificação hierarquica na Arte Marcial
	 * @param gubFinal
	 *            Identificação hierarquica na Arte Marcial
	 * @return Lista de faixas
	 */
	public List<Faixa> getFaixasEntreGubs(int gubInicial, int gubFinal) {
		List<Faixa> faixas = faixaDAO.getFaixas(this.id, gubInicial, gubFinal);

		for (Faixa faixa : faixas) {
			faixa.setArteMarcial(this);
		}

		this.faixas = faixas;
		return this.faixas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((faixas == null) ? 0 : faixas.hashCode());
		result = prime * result + id;
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
		if (id != other.id)
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		return true;
	}

}
