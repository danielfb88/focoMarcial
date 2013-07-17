package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DAO;

public class ArteMarcialDAO extends DAO {

	/**
	 * TODO: Concluir
	 * 
	 * Adicionar Arte Marcial
	 * @return
	 */
	public int adicionar(String descricao) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("INSERT INTO ");
		builder.append(" (");

		builder.append(") ");
		builder.append("VALUES ");
		builder.append("(");

		builder.append(")");
		builder.append(";");

		try {
			PreparedStatement ps = getConnection().prepareStatement(
					builder.toString());
			linhasAfetadas = ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);

		} catch (Exception e2) {
			e2.printStackTrace();
			System.exit(0);
		}
		return linhasAfetadas;
	}
}
