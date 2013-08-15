package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DAO;
import ddd.Grito;

/**
 * DAO Grito
 * 
 * @author Daniel Bonfim <daniel.fb88@gmail.com>
 * @since 15/08/2013
 * @version 1.0
 * 
 */
public class GritoDAO extends DAO {

	/**
	 * Adicionar Grito oa banco de dados
	 * 
	 * @param descricao
	 *            Nome da Grito
	 * @param path
	 *            Endereço do arquivo de som de chamada
	 * @return Número de linhas afetadas
	 */
	public int adicionar(String path) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("INSERT INTO grito (path) VALUES (");
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
	 * Excluir Grito
	 * 
	 * @param id_grito
	 *            Id da Grito a ser excluída
	 * @return Número de linha(s) afetadas
	 */
	public int excluir(int id_grito) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("DELETE FROM grito WHERE id_grito = " + id_grito + ";");

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
	 * Efetua uma consulta no banco e obtém todas as Gritos
	 * cadadastradas.
	 * 
	 * @return Lista das Gritos cadastradas
	 */
	public List<Grito> getGritos() {
		ArrayList<Grito> gritos = new ArrayList<Grito>();
		StringBuilder builder = new StringBuilder();
		ResultSet rs = null;

		builder.append("SELECT * FROM grito;");
		try {
			PreparedStatement ps = getConnection().prepareStatement(builder.toString());

			rs = ps.executeQuery();

			while (rs.next()) {
				gritos.add(
						new Grito(
								rs.getInt("id_grito"),
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

		return gritos;

	}
}
