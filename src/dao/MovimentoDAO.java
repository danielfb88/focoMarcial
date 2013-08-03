package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DAO;
import ddd.Movimento;

/**
 * DAO do Movimento
 * 
 * @author Daniel Bonfim <daniel.fb88@gmail.com>
 * @since 03/08/2013
 * @version 1.0
 * 
 */
public class MovimentoDAO extends DAO {

	/**
	 * Adicionar um Movimento ao banco de dados
	 * 
	 * @param id_faixa
	 *            Id da faixa detentora do movimento
	 * @param descricao
	 *            Nome do movimento
	 * @param observacao
	 *            Informações adicionais sobre o movimento
	 * @param qtd_repeticao
	 *            Número de repetições a serem executados
	 * @param intervalo_segundos
	 *            Intervalo em segundos entre as repetições
	 * @param eh_golpe
	 *            Informação que diz se o movimento é um golpe ou Movimento de
	 *            respiração, atenção, etc.
	 * @param voz_path
	 *            Endereço do arquivo de som de comando para o movimento
	 * @return Numero de linhas afetadas
	 */
	public int adicionar(int id_faixa, String descricao, String observacao,
			int qtd_repeticao, int intervalo_segundos, int eh_golpe, String voz_path) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos, eh_golpe, voz_path) VALUES (");
		builder.append(id_faixa + ", ");
		builder.append("'" + descricao + "', ");
		builder.append("'" + observacao + "', ");
		builder.append(qtd_repeticao + ", ");
		builder.append(intervalo_segundos + ", ");
		builder.append(eh_golpe + ", ");
		builder.append("'" + voz_path + "'");
		builder.append(");");

		try {
			PreparedStatement ps = getConnection().prepareStatement(builder.toString());

			linhasAfetadas = ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return linhasAfetadas;
	}

	/**
	 * Editar um movimento
	 * 
	 * @param id_movimento
	 *            Id do movimento a ser editado
	 * @param id_faixa
	 *            Id da faixa detentora do movimento
	 * @param descricao
	 *            Nome do movimento
	 * @param observacao
	 *            Informações adicionais sobre o movimento
	 * @param qtd_repeticao
	 *            Número de repetições a serem executados
	 * @param intervalo_segundos
	 *            Intervalo em segundos entre as repetições
	 * @param eh_golpe
	 *            Informação que diz se o movimento é um golpe ou Movimento de
	 *            respiração, atenção, etc.
	 * @param voz_path
	 *            Endereço do arquivo de som de comando para o movimento
	 * @return Numero de linhas afetadas
	 */
	public int editar(int id_movimento, int id_faixa, String descricao,
			String observacao, int qtd_repeticao, int intervalo_segundos, int eh_golpe, String voz_path) {

		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("UPDATE movimento SET ");

		builder.append("id_faixa = " + id_faixa + ", ");
		builder.append("descricao = '" + descricao + "', ");
		builder.append("observacao = '" + observacao + "', ");
		builder.append("qtd_repeticao = " + qtd_repeticao + ", ");
		builder.append("intervalo_segundos = " + intervalo_segundos + ", ");
		builder.append("eh_golpe = " + eh_golpe + ", ");
		builder.append("voz_path = '" + voz_path + "' ");

		builder.append("WHERE id_movimento = " + id_movimento + ";");

		try {
			PreparedStatement ps = getConnection().prepareStatement(builder.toString());

			linhasAfetadas = ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return linhasAfetadas;
	}

	/**
	 * Excluir um movimento
	 * 
	 * @param id_movimento
	 *            Id do movimento a ser excluído
	 * @return Número de linahs afetadas
	 */
	public int excluir(int id_movimento) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("DELETE FROM movimento WHERE id_movimento = " + id_movimento + ";");

		try {
			PreparedStatement ps = getConnection().prepareStatement(builder.toString());

			linhasAfetadas = ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return linhasAfetadas;
	}

	/**
	 * Obtém o movimento pelo Id
	 * 
	 * @param id_movimento
	 *            Id do movimento
	 * @return Objeto Movimento
	 */
	public Movimento getById(int id_movimento) {
		Movimento movimento = null;
		StringBuilder builder = new StringBuilder();
		ResultSet rs = null;

		builder.append("SELECT * FROM movimento WHERE id_movimento = " + id_movimento + ";");
		try {
			PreparedStatement ps = getConnection().prepareStatement(builder.toString());

			rs = ps.executeQuery();

			/*
			 * O segundo parâmetro será preenchido pela Faixa.
			 */
			movimento =
					new Movimento(
							rs.getInt("id_movimento"),
							null,
							rs.getString("descricao"),
							rs.getString("observacao"),
							rs.getInt("qtd_repeticao"),
							rs.getInt("intervalo_segundos"),
							rs.getInt("eh_golpe"),
							rs.getString("voz_path")
					);

			rs.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return movimento;
	}

	/**
	 * Obtém Movimentos pelo Id da faixa
	 * 
	 * @param id_faixa
	 * @return
	 */
	public List<Movimento> getMovimentos(int id_faixa) {
		ArrayList<Movimento> movimentos = new ArrayList<Movimento>();
		StringBuilder builder = new StringBuilder();
		ResultSet rs = null;

		builder.append("SELECT * FROM movimento WHERE id_faixa = " + id_faixa + ";");

		try {
			PreparedStatement ps = getConnection().prepareStatement(builder.toString());

			rs = ps.executeQuery();

			while (rs.next()) {
				/*
				 * O segundo parâmetro será preenchido pela Faixa.
				 */
				movimentos
						.add(new Movimento(
								rs.getInt("id_movimento"),
								null,
								rs.getString("descricao"),
								rs.getString("observacao"),
								rs.getInt("qtd_repeticao"),
								rs.getInt("intervalo_segundos"),
								rs.getInt("eh_golpe"),
								rs.getString("voz_path")
						));
			}

			rs.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return movimentos;

	}

}
