package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DAO;
import ddd.ArteMarcial;
import ddd.Faixa;

public class FaixaDAO extends DAO {

	/**
	 * Adicionar Faixa
	 * 
	 * @param id_artemarcial
	 * @param gub
	 * @param descricao
	 * @return
	 */
	public int adicionar(int id_artemarcial, int gub, String descricao, String voz_path) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("INSERT INTO faixa (id_artemarcial, gub, descricao, voz_path) VALUES ("
				+ id_artemarcial + ", " + gub + ", '" + descricao + "', '" + voz_path + "');");

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
	 * Editar Faixa
	 * 
	 * @param id_faixa
	 * @param id_artemarcial
	 * @param gub
	 * @param descricao
	 * @return
	 */
	public int editar(int id_faixa, int id_artemarcial, int gub, String descricao, String voz_path) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();
		
		builder.append("UPDATE faixa SET ");
		
		builder.append("id_artemarcial = " + id_artemarcial + ", ");
		builder.append("gub = " + gub + ", ");
		builder.append("descricao = '" + descricao + "', ");
		builder.append("voz_path = '" + voz_path + "' ");

		builder.append("WHERE id_faixa = " + id_faixa + ";");
		
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
	 * Excluir Faixa
	 * 
	 * @param id
	 * @return
	 */
	public int excluir(int id_faixa) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("DELETE FROM faixa WHERE id_faixa = " + id_faixa + ";");

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
	
	public Faixa getById(int id_faixa) {
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
					rs.getString("descricao"),
					rs.getString("voz_path")
				);

			rs.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return faixa;
	}

	/**
	 * Obtém todas as faixas da Arte Marcial especificada pelo ID
	 * 
	 * @param id_artemarcial ID da arte marcial a ser retornada
	 * @return
	 */
	public List<Faixa> getFaixas(int id_artemarcial) {
		ArrayList<Faixa> faixas = new ArrayList<Faixa>();
		StringBuilder builder = new StringBuilder();
		ResultSet rs = null;

		builder.append("SELECT ");

		builder.append("id_faixa, ");
		builder.append("id_artemarcial, ");
		builder.append("gub, ");
		builder.append("descricao ");

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
								null, 
								rs.getInt("gub"), 
								rs.getString("descricao"),
								rs.getString("voz_path")
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

		return faixas;
	}
	
	/**
	 * Obtém todas as faixas da Arte Marcial especificada pelo ID e Pelo GUB INICIAL e GUB FINAL
	 * 
	 * @param id_artemarcial
	 * @param gub_inicial
	 * @param gub_final
	 * @return
	 */
	public List<Faixa> getFaixas(int id_artemarcial, int gub_inicial, int gub_final) {
		ArrayList<Faixa> faixas = new ArrayList<Faixa>();
		StringBuilder builder = new StringBuilder();
		ResultSet rs = null;

		builder.append("SELECT * FROM faixa ");

		builder.append("WHERE ");
		builder.append("id_artemarcial = " + id_artemarcial + " ");
		builder.append("AND gub <= " + gub_inicial + " ");
		builder.append("AND gub >= " + gub_final + " ");

		try {
			PreparedStatement ps = getConnection().prepareStatement(
					builder.toString());

			rs = ps.executeQuery();

			while (rs.next()) {
				faixas.add(
						new Faixa(
								rs.getInt("id_faixa"), 
								null, 
								rs.getInt("gub"), 
								rs.getString("descricao"),
								rs.getString("voz_path")
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

		return faixas;
	}
}
