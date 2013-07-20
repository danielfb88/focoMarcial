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
	
	/**
	 * Obtém todas as faixas desta Arte Marcial
	 * 
	 * @return List<Faixa>
	 */
	public List<Faixa> getTodasAsFaixas() {
		List<Faixa> faixas = faixaDAO.getFaixas(this.getId());
		
		for(int i=0; i<faixas.size(); i++) {
			Faixa faixa = faixas.get(i);
			Integer idFaixa = faixa.getId();
			
			faixa.setArteMarcial(this);
			faixa.setMovimentos(movimentoDAO.getMovimentos(idFaixa));
		}
		
		return faixas;
	}
	
	/**
	 * TODO: Obter faixas seguindo o mesmo padrão do método anterior, utilizando como filtro o gub inicial e o gub final
	 * 
	 * @return
	 */
	public List<Faixa> getFaixasEntreGubs(int id_arteMarcial, int id_gubInicial, int id_gubFinal) {
		
		return null;
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
