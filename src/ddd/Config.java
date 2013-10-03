package ddd;

import java.util.List;

import dao.ConfigDAO;

public class Config {
	private int id;
	private String perfil;
	private int tempoDescansoCurto;
	private int tempoDescansoLongo;
	private int tempoAlongamento;
	private String pathDescanso;
	private String pathAlongamento;
	private String pathAtencao;
	private String pathComando;
	private String pathContagem;
	
	ConfigDAO configDAO;

	public Config() {
		configDAO = new ConfigDAO();
	}

	public Config(String perfil, int tempoDescansoCurto,
			int tempoDescansoLongo, int tempoAlongamento, String pathDescanso,
			String pathAlongamento, String pathAtencao, String pathComando,
			String pathContagem) {
		super();
		this.perfil = perfil;
		this.tempoDescansoCurto = tempoDescansoCurto;
		this.tempoDescansoLongo = tempoDescansoLongo;
		this.tempoAlongamento = tempoAlongamento;
		this.pathDescanso = pathDescanso;
		this.pathAlongamento = pathAlongamento;
		this.pathAtencao = pathAtencao;
		this.pathComando = pathComando;
		this.pathContagem = pathContagem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getPathDescanso() {
		return pathDescanso;
	}

	public void setPathDescanso(String pathDescanso) {
		this.pathDescanso = pathDescanso;
	}

	public int getTempoDescansoCurto() {
		return tempoDescansoCurto;
	}

	public void setTempoDescansoCurto(int tempoDescansoCurto) {
		this.tempoDescansoCurto = tempoDescansoCurto;
	}

	public int getTempoDescansoLongo() {
		return tempoDescansoLongo;
	}

	public void setTempoDescansoLongo(int tempoDescansoLongo) {
		this.tempoDescansoLongo = tempoDescansoLongo;
	}

	public String getPathAlongamento() {
		return pathAlongamento;
	}

	public void setPathAlongamento(String pathAlongamento) {
		this.pathAlongamento = pathAlongamento;
	}

	public int getTempoAlongamento() {
		return tempoAlongamento;
	}

	public void setTempoAlongamento(int tempoAlongamento) {
		this.tempoAlongamento = tempoAlongamento;
	}

	public String getPathAtencao() {
		return pathAtencao;
	}

	public void setPathAtencao(String pathAtencao) {
		this.pathAtencao = pathAtencao;
	}

	public String getPathComando() {
		return pathComando;
	}

	public void setPathComando(String pathComando) {
		this.pathComando = pathComando;
	}

	public String getPathContagem() {
		return pathContagem;
	}

	public void setPathContagem(String pathContagem) {
		this.pathContagem = pathContagem;
	}

	public boolean salvar() {
		int retorno = 0;

		if (this.id == 0) {
			retorno = configDAO.adicionar(this.perfil, this.tempoDescansoCurto,
					this.tempoDescansoLongo, this.tempoAlongamento,
					this.pathDescanso, this.pathAlongamento, this.pathAtencao,
					this.pathComando, this.pathContagem);

		} else {
			retorno = configDAO.editar(this.id, this.perfil,
					this.tempoDescansoCurto, this.tempoDescansoLongo,
					this.tempoAlongamento, this.pathDescanso,
					this.pathAlongamento, this.pathAtencao, this.pathComando,
					this.pathContagem);
		}

		return retorno > 0;
	}

	public boolean excluir() {
		int retorno = 0;

		if (this.id != 0) {
			retorno = configDAO.excluir(this.id);
		}

		return retorno > 0;
	}
	
	public List<String> getPerfis() {
		return configDAO.getPerfis();
	}
	
	public Config getByPerfil(String perfil) {
		return configDAO.getByPerfil(perfil);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result
				+ ((pathAlongamento == null) ? 0 : pathAlongamento.hashCode());
		result = prime * result
				+ ((pathAtencao == null) ? 0 : pathAtencao.hashCode());
		result = prime * result
				+ ((pathComando == null) ? 0 : pathComando.hashCode());
		result = prime * result
				+ ((pathContagem == null) ? 0 : pathContagem.hashCode());
		result = prime * result
				+ ((pathDescanso == null) ? 0 : pathDescanso.hashCode());
		result = prime * result + ((perfil == null) ? 0 : perfil.hashCode());
		result = prime * result + tempoAlongamento;
		result = prime * result + tempoDescansoCurto;
		result = prime * result + tempoDescansoLongo;
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
		Config other = (Config) obj;
		if (id != other.id)
			return false;
		if (pathAlongamento == null) {
			if (other.pathAlongamento != null)
				return false;
		} else if (!pathAlongamento.equals(other.pathAlongamento))
			return false;
		if (pathAtencao == null) {
			if (other.pathAtencao != null)
				return false;
		} else if (!pathAtencao.equals(other.pathAtencao))
			return false;
		if (pathComando == null) {
			if (other.pathComando != null)
				return false;
		} else if (!pathComando.equals(other.pathComando))
			return false;
		if (pathContagem == null) {
			if (other.pathContagem != null)
				return false;
		} else if (!pathContagem.equals(other.pathContagem))
			return false;
		if (pathDescanso == null) {
			if (other.pathDescanso != null)
				return false;
		} else if (!pathDescanso.equals(other.pathDescanso))
			return false;
		if (perfil == null) {
			if (other.perfil != null)
				return false;
		} else if (!perfil.equals(other.perfil))
			return false;
		if (tempoAlongamento != other.tempoAlongamento)
			return false;
		if (tempoDescansoCurto != other.tempoDescansoCurto)
			return false;
		if (tempoDescansoLongo != other.tempoDescansoLongo)
			return false;
		return true;
	}

}
