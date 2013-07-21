package ddd;

import java.util.List;

import dao.ArteMarcialDAO;
import dao.FaixaDAO;
import dao.MovimentoDAO;

public class ArteMarcial {
	private FaixaDAO faixaDAO = new FaixaDAO();
	private ArteMarcialDAO arteMarcialDAO = new ArteMarcialDAO();
	private MovimentoDAO movimentoDAO = new MovimentoDAO();
	
	private Integer id;
	private String descricao;
	private String voz_path;
	
	private List<Faixa> faixas;
	
	public ArteMarcial() {
		super();
	}
	
	public ArteMarcial(Integer id) {
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
		
		for(int i=0; i<faixas.size(); i++) {
			Faixa faixa = faixas.get(i);
			Integer idFaixa = faixa.getId();
			
			faixa.setArteMarcial(this);
			faixa.setMovimentos(movimentoDAO.getMovimentos(idFaixa));
		}
		
		return faixas;
	}
	
	/**
	 * Obtém todas as faixas entre os GUBs especificados.
	 * 
	 * @return
	 */
	public List<Faixa> getFaixasEntreGubs(int gubInicial, int gubFinal) {
		List<Faixa> faixas = faixaDAO.getFaixas(this.id, gubInicial, gubFinal);
		
		for(int i=0; i<faixas.size(); i++) {
			Faixa faixa = faixas.get(i);
			Integer idFaixa = faixa.getId();
			
			faixa.setArteMarcial(this);
			faixa.setMovimentos(movimentoDAO.getMovimentos(idFaixa));
		}
		
		return faixas;
	}
	
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (voz_path == null) {
			if (other.voz_path != null)
				return false;
		} else if (!voz_path.equals(other.voz_path))
			return false;
		return true;
	}

}
