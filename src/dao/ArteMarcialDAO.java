package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DAO;
import ddd.ArteMarcial;

/**
 * DAO da Arte Marcial
 * 
 * @author Daniel Bonfim <daniel.fb88@gmail.com>
 * @since 03/08/2013
 * @version 1.0
 * 
 */
public class ArteMarcialDAO extends DAO {

	/**
	 * Adicionar Arte Marcial oa banco de dados
	 * 
	 * @param descricao
	 *            Nome da Arte Marcial
	 * @param path
	 *            Endereço do arquivo de som de chamada
	 * @return Número de linhas afetadas
	 */
	public int adicionar(String descricao, String path) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("INSERT INTO artemarcial (descricao, path) VALUES (");
		builder.append("'" + descricao + "', ");
		builder.append("'" + path + "'");
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
	 * Editar Arte Marcial
	 * 
	 * @param id_artemarcial
	 *            Id da Arte Marcial a ser editada
	 * @param descricao
	 *            Novo nome
	 * @param path
	 *            Novo endereço do arquivo de som
	 * @return Número de linhas afetadas
	 */
	public int editar(int id_artemarcial, String descricao, String path) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("UPDATE artemarcial SET ");

		builder.append("descricao = '" + descricao + "', ");
		builder.append("path = '" + path + "' ");

		builder.append("WHERE id_artemarcial = " + id_artemarcial + ";");

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
	 * Excluir Arte Marcial
	 * 
	 * @param id_artemarcial
	 *            Id da Arte Marcial a ser excluída
	 * @return Número de linha(s) afetadas
	 */
	public int excluir(int id_artemarcial) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("DELETE FROM artemarcial WHERE id_artemarcial = " + id_artemarcial + ";");

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
	 * Efetua uma consulta no banco e obtém a Arte Marcial por ID
	 * 
	 * @param id_artemarcial
	 *            Id da Arte Marcial
	 * @return Objeto da Arte Marcial
	 */
	public ArteMarcial getById(int id_artemarcial) {
		ArteMarcial arteMarcial = null;
		StringBuilder builder = new StringBuilder();
		ResultSet rs = null;

		builder.append("SELECT * FROM artemarcial WHERE id_artemarcial = " + id_artemarcial + ";");
		try {
			PreparedStatement ps = getConnection().prepareStatement(builder.toString());

			rs = ps.executeQuery();
			arteMarcial =
					new ArteMarcial(
							rs.getInt("id_artemarcial"),
							rs.getString("descricao"),
							rs.getString("path")
					);

			rs.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return arteMarcial;
	}

	/**
	 * Efetua uma consulta no banco e obtém todas as Artes Marciais
	 * cadadastradas.
	 * 
	 * @return Lista das Artes Marciais cadastradas
	 */
	public List<ArteMarcial> getArtesMarciais() {
		ArrayList<ArteMarcial> artesMarciais = new ArrayList<ArteMarcial>();
		StringBuilder builder = new StringBuilder();
		ResultSet rs = null;

		builder.append("SELECT * FROM artemarcial;");
		try {
			PreparedStatement ps = getConnection().prepareStatement(builder.toString());

			rs = ps.executeQuery();

			while (rs.next()) {
				artesMarciais.add(
						new ArteMarcial(
								rs.getInt("id_artemarcial"),
								rs.getString("descricao"),
								rs.getString("path")
						));
			}

			rs.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return artesMarciais;

	}
}
