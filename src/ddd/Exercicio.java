package ddd;

import java.util.List;

import sound.IPlayer;
import sound.Mp3Player;
import util.Util;
import control.Aula;
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

	private Config config;

	/**
	 * DAO do Exercicio
	 */
	private ExercicioDAO exercicioDAO = new ExercicioDAO();

	private IPlayer player = new Mp3Player();

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

		Aula.getInstance().getJFrame().escreverStatus("Exercicio: " + this.descricao + "\n");
		
		player.play(this.path);
		Util.tempo(2);

		int x = 1;

		/*
		 * Séries
		 */
		for (int serie = 1; serie <= this.qtdSerie; serie++) {
			Aula.getInstance().getJFrame().escreverStatus("Serie: " + serie + "\n");

			// Próximo exercício foi solicitado?
			if (Aula.getInstance().isProximo2()) {
				Aula.getInstance().setProximo2(false);
				break;
			}

			if(serie > 1) {
				player.play(config.getPathAtencao());
				Util.tempo(3);
			}
			/*
			 * Repetições
			 */
			for (int i = 0; i < this.qtdRepeticao; i++) {
				Aula.getInstance().verificarPausa();

				// Próxima série foi solicitada?
				if (Aula.getInstance().isProximo1()) {
					Aula.getInstance().setProximo1(false);
					x = 1;
					break;
				}


				Aula.getInstance().getJFrame().escreverStatus(i + 1 + "\n");
				player.play(config.getPathContagem() + (x) + ".mp3");
				Util.tempo(intervaloSegundos);

				if (x == 10)
					x = 0;

				x++;
			}
			Util.tempo(config.getTempoDescansoCurto());
			
		}
		Util.tempo(config.getTempoDescansoMedio());
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
