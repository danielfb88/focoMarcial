package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DAO;
import controller.ArteMarcial;
import controller.Faixa;

public class FaixaDAO extends DAO {

	/**
	 * Adicionar Faixa
	 * 
	 * @param id_artemarcial
	 * @param gub
	 * @param descricao
	 * @return
	 */
	public int adicionar(Integer id_artemarcial, Integer gub, String descricao) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("INSERT INTO faixa (id_artemarcial, gub, descricao) VALUES ("
				+ id_artemarcial + ", " + gub + ", '" + descricao + "');");

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

	/**
	 * Editar Faixa
	 * 
	 * @param id_faixa
	 * @param id_artemarcial
	 * @param gub
	 * @param descricao
	 * @return
	 */
	public int editar(Integer id_faixa, Integer id_artemarcial, Integer gub,
			String descricao) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("UPDATE TABLE artemarcial SET ");

		if (id_artemarcial != null) {
			builder.append("id_artemarcial = " + id_artemarcial + " ");
		}

		if (gub != null) {
			builder.append("gub = " + gub + " ");
		}

		if (descricao != null) {
			builder.append("descricao = '" + descricao + "' ");
		}

		builder.append("WHERE id_faixa = " + id_faixa + ";");

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

	/**
	 * Excluir Faixa
	 * 
	 * @param id
	 * @return
	 */
	public int excluir(Integer id_faixa) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("DELETE FROM faixa WHERE id_faixa = " + id_faixa + ");");

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
	
	public Faixa getById(Integer id_faixa) {
		Faixa faixa = null;
		StringBuilder builder = new StringBuilder();
		ResultSet rs = null;

		builder.append("SELECT * FROM faixa WHERE id_faixa = " + id_faixa + ";");
		try {
			PreparedStatement ps = getConnection().prepareStatement(
					builder.toString());

			rs = ps.executeQuery();
			
			faixa = new Faixa(
					rs.getInt("id_faixa"), 
					new ArteMarcial(rs.getInt("id_artemarcial")), 
					rs.getInt("gub"), 
					rs.getString("descricao")
				);

			rs.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

		return faixa;
	}

	/**
	 * Obtém todas as faixas da Arte Marcial especificada pelo ID
	 * 
	 * @param id_artemarcial
	 * @return
	 */
	public List<Faixa> getFaixas(Integer id_artemarcial) {
		ArrayList<Faixa> faixas = new ArrayList<Faixa>();
		StringBuilder builder = new StringBuilder();
		ResultSet rs = null;

		builder.append("SELECT ");

		builder.append("id_faixa, ");
		builder.append("id_artemarcial, ");
		builder.append("gub, ");
		builder.append("descricao, ");

		builder.append("FROM faixa ");

		builder.append("WHERE ");
		builder.append("id_artemarcial = " + id_artemarcial + ";");

		try {
			PreparedStatement ps = getConnection().prepareStatement(
					builder.toString());

			rs = ps.executeQuery();

			while (rs.next()) {
				faixas.add(
						new Faixa(
								rs.getInt("id_faixa"), 
								new ArteMarcial(rs.getInt("id_artemarcial"), null, null), 
								rs.getInt("gub"), 
								rs.getString("descricao")
								)
						);
			}

			rs.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

		return faixas;

	}
}
