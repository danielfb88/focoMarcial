package ddd;

import java.util.List;

import util.Util;
import control.WavPlayer;
import dao.ExercicioDAO;

/**
 * DDD do Exercicio
 * 
 * @author Daniel Bonfim <daniel.fb88@gmail.com>
 * @since 12/08/2013
 * @version 1.0
 * 
 */
public class Exercicio {
	/**
	 * Id
	 */
	private int id;

	/**
	 * Nome do exercicio
	 */
	private String descricao;

	/**
	 * Número de repetições para o exercicio
	 */
	private int qtdRepeticao;
	
	/**
	 * Número de séries
	 */
	private int qtdSerie;

	/**
	 * Tempo do intervalo em segundo entre os exercicios
	 */
	private int intervaloSegundos;

	/**
	 * Endereço do arquivo de som do nome do exercicio
	 */
	private String path;

	private boolean cancelar;

	private Config config;

	/**
	 * DAO do Exercicio
	 */
	private ExercicioDAO exercicioDAO = new ExercicioDAO();;

	private WavPlayer player = new WavPlayer();

	public Exercicio(Config config) {
		this.config = config;
	}

	public Exercicio() {

	}

	public Exercicio(String descricao, int qtdRepeticao, int qtdSerie, int intervaloSegundos,
			String path) {
		super();
		this.descricao = descricao;
		this.qtdRepeticao = qtdRepeticao;
		this.qtdSerie = qtdSerie;
		this.intervaloSegundos = intervaloSegundos;
		this.path = path;
	}

	public Exercicio(int id, String descricao, int qtdRepeticao, int qtdSerie,
			int intervaloSegundos, String path) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.qtdRepeticao = qtdRepeticao;
		this.qtdSerie = qtdSerie;
		this.intervaloSegundos = intervaloSegundos;
		this.path = path;
	}

	public void setConfig(Config config) {
		this.config = config;
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

	public int getQtdRepeticao() {
		return qtdRepeticao;
	}

	public void setQtdRepeticao(int qtdRepeticao) {
		this.qtdRepeticao = qtdRepeticao;
	}
	
	public int getQtdSerie() {
		return qtdSerie;
	}

	public void setQtdSerie(int qtdSerie) {
		this.qtdSerie = qtdSerie;
	}

	public int getIntervaloSegundos() {
		return intervaloSegundos;
	}

	public void setIntervaloSegundos(int intervaloSegundos) {
		this.intervaloSegundos = intervaloSegundos;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Salvar exercicio no banco
	 * 
	 * @return Status do sucesso da operação
	 */
	public boolean salvar() {
		ExercicioDAO exercicioDAO = new ExercicioDAO();
		int retorno = 0;

		if (this.id == 0) {
			retorno = exercicioDAO.adicionar(this.descricao, this.qtdRepeticao, this.qtdSerie,
					this.intervaloSegundos, this.path);

		} else {
			retorno = exercicioDAO.editar(this.id, this.descricao,
					this.qtdRepeticao, this.qtdSerie, this.intervaloSegundos, this.path);
		}

		return retorno > 0;
	}

	/**
	 * Iniciar Exercício
	 * 
	 * @throws Exception
	 */
	public void iniciar() throws Exception {
		if (config == null)
			throw new Exception("Configurações não definidas");

		player.play(this.path);
		Util.tempo(2);

		int x = 1;

		for (int i = 0; i < this.qtdRepeticao; i++) {
			System.out.println(i + 1);

			if (cancelar) {
				cancelar = false;
				break;
			}

			player.play(config.getPathContagem() + (x) + ".wav");
			Util.tempo(intervaloSegundos);

			if (x == 10)
				x = 0;

			x++;
		}
	}

	public void cancelar() {
		cancelar = true;
	}

	public List<Exercicio> getTodosOsExercicios() {
		return exercicioDAO.getExercicios();
	}

	/**
	 * Obtém o Exercicio pelo Id
	 * 
	 * @param id
	 * @return
	 */
	public Exercicio getById(int id) {
		return exercicioDAO.getById(id);
	}

}
