package ddd;

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
	 * Tempo do intervalo em segundo entre os exercicios
	 */
	private int intervaloSegundos;

	/**
	 * Endereço do arquivo de som do nome do exercicio
	 */
	private String voz_path;
	
	/**
	 * DAO do Exercicio
	 */
	private ExercicioDAO exercicioDAO = new ExercicioDAO();

	public Exercicio() {
		super();
	}

	public Exercicio(Integer id) {
		super();
		this.id = id;
	}

	public Exercicio(Integer id, String descricao, int qtdRepeticao, int intervaloSegundos, String voz_path) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.qtdRepeticao = qtdRepeticao;
		this.intervaloSegundos = intervaloSegundos;
		this.voz_path = voz_path;
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

	public int getIntervaloSegundos() {
		return intervaloSegundos;
	}

	public void setIntervaloSegundos(int intervaloSegundos) {
		this.intervaloSegundos = intervaloSegundos;
	}
	
	public String getVoz_path() {
		return voz_path;
	}

	public void setVoz_path(String voz_path) {
		this.voz_path = voz_path;
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
			retorno =
					exercicioDAO.adicionar(
							this.descricao,
							this.qtdRepeticao,
							this.intervaloSegundos,
							this.voz_path
							);

		} else {
			retorno =
					exercicioDAO.editar(
							this.id,
							this.descricao,
							this.qtdRepeticao,
							this.intervaloSegundos,
							this.voz_path
							);
		}

		return retorno > 0;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + id;
		result = prime * result + intervaloSegundos;
		result = prime * result + qtdRepeticao;
		result = prime * result + ((voz_path == null) ? 0 : voz_path.hashCode());
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
		Exercicio other = (Exercicio) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		if (intervaloSegundos != other.intervaloSegundos)
			return false;
		if (qtdRepeticao != other.qtdRepeticao)
			return false;
		if (voz_path == null) {
			if (other.voz_path != null)
				return false;
		} else if (!voz_path.equals(other.voz_path))
			return false;
		return true;
	}
	
}
