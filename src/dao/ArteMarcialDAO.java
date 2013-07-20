package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DAO;
import ddd.ArteMarcial;

public class ArteMarcialDAO extends DAO {

	/**
	 * Adicionar Arte Marcial
	 * 
	 * @param descricao
	 *            Nome da Arte Marcial
	 * @return int
	 */
	public int adicionar(String descricao) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("INSERT INTO artemarcial (descricao) VALUES ('" + descricao + "');");

		try {
			PreparedStatement ps = getConnection().prepareStatement(
					builder.toString());

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
	 *            Id da arte marcial a ser editado
	 * @param descricao
	 *            Novo nome
	 * 
	 * @return int
	 */
	public int editar(int id_artemarcial, String descricao) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("UPDATE artemarcial SET descricao = '" + descricao
				+ "' WHERE id_artemarcial = " + id_artemarcial + ";");

		try {
			PreparedStatement ps = getConnection().prepareStatement(
					builder.toString());

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
	 *            Id da arte marcial a ser excluído
	 * 
	 * @return int
	 */
	public int excluir(int id_artemarcial) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("DELETE FROM artemarcial WHERE id_artemarcial = "
				+ id_artemarcial + ";");

		try {
			PreparedStatement ps = getConnection().prepareStatement(
					builder.toString());

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
	 * Obtém Arte Marcial por ID
	 * 
	 * @return
	 */
	public ArteMarcial getById(int id_artemarcial) {
		ArteMarcial arteMarcial = null;
		StringBuilder builder = new StringBuilder();
		ResultSet rs = null;

		builder.append("SELECT * FROM artemarcial WHERE id_artemarcial = " + id_artemarcial + ";");
		try {
			PreparedStatement ps = getConnection().prepareStatement(
					builder.toString());

			rs = ps.executeQuery();
			arteMarcial = new ArteMarcial(rs.getInt("id_artemarcial"), rs.getString("descricao"), null);

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
	 * Obtém todas as Artes Marciais cadastradas
	 * 
	 * @return
	 */
	public List<ArteMarcial> getArtesMarciais() {
		ArrayList<ArteMarcial> artesMarciais = new ArrayList<ArteMarcial>();
		StringBuilder builder = new StringBuilder();
		ResultSet rs = null;

		builder.append("SELECT * FROM artemarcial;");
		try {
			PreparedStatement ps = getConnection().prepareStatement(
					builder.toString());

			rs = ps.executeQuery();

			while (rs.next()) {
				artesMarciais.add(
						new ArteMarcial(
								rs.getInt("id_artemarcial"), 
								rs.getString("descricao"), 
								null
								)
						);
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
