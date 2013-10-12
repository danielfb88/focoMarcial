package ddd;

import java.io.File;
import java.util.List;

import util.Util;
import dao.ConfigDAO;

public class Config {
	private int id;
	private String perfil;
	private int tempoDescansoCurto;
	private int tempoDescansoMedio;
	private int tempoDescansoLongo;
	private int tempoAlongamento;
	private String pathDescanso;
	private String pathAlongamento;
	private String pathAtencao;
	private String pathComando;
	private String pathContagem;
	private boolean aulaComExercicio;

	private File[] comandosVoz;

	private ConfigDAO configDAO = new ConfigDAO();

	public Config() {

	}

	public Config(int id, String perfil, int tempoDescansoCurto, int tempoDescansoMedio,
			int tempoDescansoLongo, int tempoAlongamento, String pathDescanso,
			String pathAlongamento, String pathAtencao, String pathComando,
			String pathContagem, boolean aulaComExercicio) {
		super();
		this.id = id;
		this.perfil = perfil;
		this.tempoDescansoCurto = tempoDescansoCurto;
		this.tempoDescansoMedio = tempoDescansoMedio;
		this.tempoDescansoLongo = tempoDescansoLongo;
		this.tempoAlongamento = tempoAlongamento;
		this.pathDescanso = pathDescanso;
		this.pathAlongamento = pathAlongamento;
		this.pathAtencao = pathAtencao;
		this.pathComando = pathComando;
		this.pathContagem = pathContagem;
		this.aulaComExercicio = aulaComExercicio;
	}

	public Config(String perfil, int tempoDescansoCurto, int tempoDescansoMedio,
			int tempoDescansoLongo, int tempoAlongamento, String pathDescanso,
			String pathAlongamento, String pathAtencao, String pathComando,
			String pathContagem, boolean aulaComExercicio) {
		super();
		this.perfil = perfil;
		this.tempoDescansoCurto = tempoDescansoCurto;
		this.tempoDescansoMedio = tempoDescansoMedio;
		this.tempoDescansoLongo = tempoDescansoLongo;
		this.tempoAlongamento = tempoAlongamento;
		this.pathDescanso = pathDescanso;
		this.pathAlongamento = pathAlongamento;
		this.pathAtencao = pathAtencao;
		this.pathComando = pathComando;
		this.pathContagem = pathContagem;
		this.aulaComExercicio = aulaComExercicio;
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

	public int getTempoDescansoMedio() {
		return tempoDescansoMedio;
	}

	public void setTempoDescansoMedio(int tempoDescansoMedio) {
		this.tempoDescansoMedio = tempoDescansoMedio;
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

	public void setAulaComExercicio(boolean flag) {
		this.aulaComExercicio = flag;
	}

	public boolean isAulaComExercicio() {
		return this.aulaComExercicio;
	}

	public boolean salvar() {
		int retorno = 0;

		if (this.id == 0) {
			retorno = configDAO.adicionar(this.perfil, this.tempoDescansoCurto,
					this.tempoDescansoMedio, this.tempoDescansoLongo,
					this.tempoAlongamento, this.pathDescanso, this.pathAlongamento, this.pathAtencao,
					this.pathComando, this.pathContagem, (this.aulaComExercicio) ? 1 : 0);

		} else {
			retorno = configDAO.editar(this.id, this.perfil,
					this.tempoDescansoCurto, this.tempoDescansoMedio, this.tempoDescansoLongo,
					this.tempoAlongamento, this.pathDescanso,
					this.pathAlongamento, this.pathAtencao, this.pathComando,
					this.pathContagem, (this.aulaComExercicio) ? 1 : 0);
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
		Config config = configDAO.getByPerfil(perfil);
		config.setComandosVoz(Util.listarArquivos(config.getPathComando(), ".wav"));
		return config;
	}

	public void setComandosVoz(File[] files) {
		this.comandosVoz = files;
	}

	public File[] getComandosVoz() {
		return this.comandosVoz;
	}

}
