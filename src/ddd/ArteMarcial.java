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
	private String voz_path;

	private FaixaDAO faixaDAO = new FaixaDAO();
	private ArteMarcialDAO arteMarcialDAO = new ArteMarcialDAO();

	private List<Faixa> faixas;

	public ArteMarcial() {
		super();
	}

	public ArteMarcial(int id) {
		super();
		this.id = id;
	}

	public ArteMarcial(Integer id, String descricao, String voz_path) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.voz_path = voz_path;
	}

	public ArteMarcial(Integer id, String descricao, String voz_path, List<Faixa> faixas) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.voz_path = voz_path;
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

	public String getVoz_path() {
		return voz_path;
	}

	public void setVoz_path(String voz_path) {
		this.voz_path = voz_path;
	}

	public List<Faixa> getFaixas() {
		return faixas;
	}

	public void setFaixas(List<Faixa> faixas) {
		this.faixas = faixas;
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
	 *            Identificação hierarquica na AM
	 * @param gubFinal
	 *            Identificação hierarquica na AM
	 * @return
	 */
	public List<Faixa> getFaixasEntreGubs(int gubInicial, int gubFinal) {
		List<Faixa> faixas = faixaDAO.getFaixas(this.id, gubInicial, gubFinal);

		for (Faixa faixa : faixas) {
			faixa.setArteMarcial(this);
		}

		return faixas;
	}

	/**
	 * Obtém a Arte Marcial pelo Id
	 * 
	 * @param id
	 * @return
	 */
	public ArteMarcial getById(int id) {
		return arteMarcialDAO.getById(id);
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
		if (voz_path == null) {
			if (other.voz_path != null)
				return false;
		} else if (!voz_path.equals(other.voz_path))
			return false;
		return true;
	}

}
