package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DAO;
import ddd.Exercicio;

/**
 * DAO do Exercicio
 * 
 * @author Daniel Bonfim <daniel.fb88@gmail.com>
 * @since 12/08/2013
 * @version 1.0
 * 
 */
public class ExercicioDAO extends DAO {

	/**
	 * Adicionar um Exercicio ao banco de dados
	 * 
	 * @param descricao
	 *            Nome do exercicio
	 * @param qtd_repeticao
	 *            Número de repetições a serem executados
	 * @param intervalo_segundos
	 *            Intervalo em segundos entre as repetições
	 * @param path
	 *            Endereço do arquivo de som de comando para o exercicio
	 * @return Numero de linhas afetadas
	 */
	public int adicionar(String descricao, int qtd_repeticao, int intervalo_segundos, String path) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("INSERT INTO exercicio (descricao, qtd_repeticao, intervalo_segundos, path) VALUES (");
		builder.append("'" + descricao + "', ");
		builder.append(qtd_repeticao + ", ");
		builder.append(intervalo_segundos + ", ");
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
	 * Editar um exercicio
	 * 
	 * @param id_exercicio
	 *            Id do exercicio a ser editado
	 * @param descricao
	 *            Nome do exercicio
	 * @param qtd_repeticao
	 *            Número de repetições a serem executados
	 * @param intervalo_segundos
	 *            Intervalo em segundos entre as repetições
	 * @param path
	 *            Endereço do arquivo de som de comando para o exercicio
	 * @return Numero de linhas afetadas
	 */
	public int editar(int id_exercicio, String descricao, int qtd_repeticao, int intervalo_segundos, String path) {

		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("UPDATE exercicio SET ");

		builder.append("descricao = '" + descricao + "', ");
		builder.append("qtd_repeticao = " + qtd_repeticao + ", ");
		builder.append("intervalo_segundos = " + intervalo_segundos + ", ");
		builder.append("path = '" + path + "' ");

		builder.append("WHERE id_exercicio = " + id_exercicio + ";");

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
	 * Excluir um exercicio
	 * 
	 * @param id_exercicio
	 *            Id do exercicio a ser excluído
	 * @return Número de linahs afetadas
	 */
	public int excluir(int id_exercicio) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("DELETE FROM exercicio WHERE id_exercicio = " + id_exercicio + ";");

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
	 * Obtém o exercicio pelo Id
	 * 
	 * @param id_exercicio
	 *            Id do exercicio
	 * @return Objeto Exercicio
	 */
	public Exercicio getById(int id_exercicio) {
		Exercicio exercicio = null;
		StringBuilder builder = new StringBuilder();
		ResultSet rs = null;

		builder.append("SELECT * FROM exercicio WHERE id_exercicio = " + id_exercicio + ";");
		try {
			PreparedStatement ps = getConnection().prepareStatement(builder.toString());

			rs = ps.executeQuery();

			/*
			 * O segundo parâmetro será preenchido pela Faixa.
			 */
			exercicio =
					new Exercicio(
							rs.getInt("id_exercicio"),
							rs.getString("descricao"),
							rs.getInt("qtd_repeticao"),
							rs.getInt("intervalo_segundos"),
							rs.getString("path")
					);

			rs.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return exercicio;
	}
	
	public List<Exercicio> getExercicios() {
		ArrayList<Exercicio> exercicios = new ArrayList<Exercicio>();
		StringBuilder builder = new StringBuilder();
		ResultSet rs = null;

		builder.append("SELECT * FROM exercicio ");

		try {
			Statement s = getConnection().createStatement();

			rs = s.executeQuery(builder.toString());

			while (rs.next()) {
				Exercicio exercicio =
						new Exercicio(
								rs.getInt("id_exercicio"),
								rs.getString("descricao"),
								rs.getInt("qtd_repeticao"),
								rs.getInt("intervalo_segundos"),
								rs.getString("path")
						);
				
				exercicios.add(exercicio);
			}

			rs.close();
			s.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return exercicios;
	}

}
