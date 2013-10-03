package ddd;

import java.util.List;

import dao.FaixaDAO;
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

	private FaixaDAO faixaDAO = new FaixaDAO();

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

	public Faixa(Integer id, Integer gub, String descricao, String path) {
		super();
		this.id = id;
		this.gub = gub;
		this.descricao = descricao;
		this.path = path;
	}

	public Faixa(Integer id, Integer gub, String descricao, String path,
			List<Movimento> movimentos) {
		super();
		this.id = id;
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

	public List<Faixa> getTodasAsFaixas() {
		return faixaDAO.getFaixas();
	}

}
