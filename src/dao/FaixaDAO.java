package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DAO;
import ddd.Faixa;

/**
 * DAO da Faixa
 * 
 * @author Daniel Bonfim <daniel.fb88@gmail.com>
 * @since 03/08/2013
 * @version 1.0
 * 
 */
public class FaixaDAO extends DAO {

	/**
	 * Adicionar Faixa ao banco de dados
	 * 
	 * @param gub
	 *            Número a qual a faixa pertence na hierarquia da arte marcial
	 * @param descricao
	 *            Cor da faixa
	 * @param path
	 *            Endereço do arquivo de som
	 * @return Número de linhas afetadas
	 */
	public int adicionar(int gub, String descricao, String path) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("INSERT INTO faixa (gub, descricao, path) VALUES (");

		builder.append(gub + ", ");
		builder.append("'" + descricao + "', ");
		builder.append("'" + path + "' ");

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
	 * Editar Faixa
	 * 
	 * @param id_faixa
	 *            Id da faixa a ser editada
	 * @param gub
	 *            Número a qual a faixa pertence na hierarquia da arte marcial
	 * @param descricao
	 *            Cor da faixa
	 * @param path
	 *            Endereço do arquivo de som
	 * @return Número de linhas afetadas
	 */
	public int editar(int id_faixa, int gub, String descricao, String path) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("UPDATE faixa SET ");

		builder.append("gub = " + gub + ", ");
		builder.append("descricao = '" + descricao + "', ");
		builder.append("path = '" + path + "' ");

		builder.append("WHERE id_faixa = " + id_faixa + ";");

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
	 * Excluir Faixa
	 * 
	 * @param id_faixa
	 *            Id da faixa a ser excluída
	 * @return Número de linhas afetadas
	 */
	public int excluir(int id_faixa) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("DELETE FROM faixa WHERE id_faixa = " + id_faixa + ";");

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
	 * Obtém a faixa pelo Id
	 * 
	 * @param id_faixa
	 *            Id da faixa
	 * @return Objeto Faixa
	 */
	public Faixa getById(int id_faixa) {
		Faixa faixa = null;
		StringBuilder builder = new StringBuilder();
		ResultSet rs = null;

		builder.append("SELECT * FROM faixa WHERE id_faixa = " + id_faixa + ";");
		try {
			PreparedStatement ps = getConnection().prepareStatement(builder.toString());

			rs = ps.executeQuery();

			faixa = new Faixa(
					rs.getInt("id_faixa"),
					rs.getInt("gub"),
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

		return faixa;
	}

	/**
	 * Obtém todas as faixas pelo Id da Arte Marcial especificada
	 * 
	 * @param id_artemarcial
	 *            Id da arte Marcial detentora das faixas a serem retornadas
	 * @return Lista das Faixas da arte marcial especificada pelo Id.
	 */
	public List<Faixa> getFaixas() {
		ArrayList<Faixa> faixas = new ArrayList<Faixa>();
		StringBuilder builder = new StringBuilder();
		ResultSet rs = null;

		builder.append("SELECT * FROM faixa ");

		try {
			Statement s = getConnection().createStatement();

			rs = s.executeQuery(builder.toString());

			while (rs.next()) {
				/*
				 * O segundo parâmetro será preenchido pela Arte Marcial.
				 */
				Faixa faixa =
						new Faixa(
								rs.getInt("id_faixa"),
								rs.getInt("gub"),
								rs.getString("descricao"),
								rs.getString("path")
						);
				
				faixa.getTodosOsMovimentos();
				
				faixas.add(faixa);
			}

			rs.close();
			s.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return faixas;
	}

	/**
	 * Obtém todas as Faixas entre os Gubs especificados
	 * 
	 
	 * @param gub_inicial
	 *            Identificação hierarquica da Faixa dentro da Arte Marcial
	 *            (Valor inicial)
	 * @param gub_final
	 *            Identificação hierarquica da Faixa dentro da Arte Marcial
	 *            (Valor final)
	 * @return Lista de Faixas entre os Gubs especificados
	 */
	public List<Faixa> getFaixas(int gub_inicial, int gub_final) {
		ArrayList<Faixa> faixas = new ArrayList<Faixa>();
		StringBuilder builder = new StringBuilder();
		ResultSet rs = null;

		builder.append("SELECT * FROM faixa ");

		builder.append("WHERE ");
		builder.append("AND gub <= " + gub_inicial + " ");
		builder.append("AND gub >= " + gub_final + " ");

		try {
			PreparedStatement ps = getConnection().prepareStatement(builder.toString());

			rs = ps.executeQuery();

			while (rs.next()) {
				faixas.add(
						/*
						 * O segundo parâmetro será preenchido pela Arte
						 * Marcial.
						 */
						new Faixa(
								rs.getInt("id_faixa"),
								rs.getInt("gub"),
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

		return faixas;
	}
}
