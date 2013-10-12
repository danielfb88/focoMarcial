package ddd;

import java.io.File;
import java.util.Random;

import sound.IPlayer;
import sound.Mp3Player;
import util.Util;
import control.Aula;
import dao.MovimentoDAO;

/**
 * DDD do Movimento
 * 
 * @author Daniel Bonfim <daniel.fb88@gmail.com>
 * @since 03/08/2013
 * @version 1.0
 * 
 */
public class Movimento {
	/**
	 * Id
	 */
	private int id;

	/**
	 * Faixa
	 */
	private Faixa faixa;

	/**
	 * Nome do movimento
	 */
	private String descricao;

	/**
	 * Informações adicionais sobre o movimento
	 */
	private String observacao;

	/**
	 * Número de repetições para o movimento
	 */
	private int qtdRepeticao;

	/**
	 * Tempo do intervalo em segundo entre os movimentos
	 */
	private int intervaloSegundos;

	/**
	 * Informação que diz se o movimento é um golpe ou Movimento de respiração,
	 * atenção, etc.
	 */
	private boolean golpe;

	/**
	 * Endereço do arquivo de som do nome do movimento
	 */
	private String path;

	private Config config = new Config();

	private IPlayer player = new Mp3Player();

	private Random random = new Random();

	public Movimento() {
		super();
	}

	public Movimento(Integer id) {
		super();
		this.id = id;
	}

	public Movimento(Integer id, Faixa faixa, String descricao,
			String observacao, int qtdRepeticao, int intervaloSegundos,
			boolean golpe, String path) {
		super();
		this.id = id;
		this.faixa = faixa;
		this.descricao = descricao;
		this.observacao = observacao;
		this.qtdRepeticao = qtdRepeticao;
		this.intervaloSegundos = intervaloSegundos;
		this.golpe = golpe;
		this.path = path;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Faixa getFaixa() {
		return faixa;
	}

	public void setFaixa(Faixa faixa) {
		this.faixa = faixa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getQtdRepeticao() {
		return qtdRepeticao;
	}

	public void setQtdRepeticao(int qtdRepeticao) {
		this.qtdRepeticao = qtdRepeticao;
	}

	public int getIntervaloSegundos() {
		return intervaloSegundos;
	}

	public void setIntervaloSegundos(int intervaloSegundos) {
		this.intervaloSegundos = intervaloSegundos;
	}

	public boolean isGolpe() {
		return golpe;
	}

	public void setGolpe(boolean golpe) {
		this.golpe = golpe;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	/**
	 * Salvar movimento no banco
	 * 
	 * @return Status do sucesso da operação
	 */
	public boolean salvar() {
		MovimentoDAO movimentoDAO = new MovimentoDAO();
		int retorno = 0;

		if (this.id == 0) {
			retorno =
					movimentoDAO.adicionar(
							faixa.getId(),
							this.descricao,
							this.observacao,
							this.qtdRepeticao,
							this.intervaloSegundos,
							(this.golpe) ? 1 : 0,
							this.path
							);

		} else {
			retorno =
					movimentoDAO.editar(
							this.id,
							faixa.getId(),
							this.descricao,
							this.observacao,
							this.qtdRepeticao,
							this.intervaloSegundos,
							(this.golpe) ? 1 : 0,
							this.path
							);
		}

		return retorno > 0;
	}

	/**
	 * Iniciar Movimento
	 * 
	 * @throws Exception
	 */
	public void iniciar() throws Exception {
		if (config == null)
			throw new Exception("Configurações não definidas");

		File[] comandosVoz = config.getComandosVoz();

		Util.tempo(2);
		Aula.getInstance().getJFrame().escreverStatus(this.descricao + "\n");
		player.play(this.path);
		Util.tempo(3);

		for (int i = 0; i < this.qtdRepeticao; i++) {
			Aula.getInstance().verificarPausa();

			// Próximo movimento foi solicitado?
			if (Aula.getInstance().isProximo1()) {
				Aula.getInstance().setProximo1(false);
				break;

				// Será tratado no for anterior
			} else if (Aula.getInstance().isAnterior1() || Aula.getInstance().isAnterior2()) {
				break;
			}

			// Som aleatório
			player.play(comandosVoz[(this.random.nextInt(comandosVoz.length))]);

			Util.tempo(intervaloSegundos);
		}
	}

}
