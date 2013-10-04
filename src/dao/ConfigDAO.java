package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DAO;
import ddd.Config;

public class ConfigDAO extends DAO {

	public int adicionar(String perfil, int tempoDescansoCurto,
			int tempoDescansoLongo, int tempoAlongamento, String pathDescanso,
			String pathAlongamento, String pathAtencao, String pathComando,
			String pathContagem) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("INSERT INTO config (");
		builder.append("perfil, tempo_descanso_curto, tempo_descanso_longo, tempo_alongamento, path_descanso, path_alongamento, path_atencao, path_comando, path_contagem");
		builder.append(") VALUES (");
		builder.append("'" + perfil + "', ");
		builder.append(tempoDescansoCurto + ", ");
		builder.append(tempoDescansoLongo + ", ");
		builder.append(tempoAlongamento + ", ");
		builder.append("'" + pathDescanso + "'");
		builder.append("'" + pathAlongamento + "'");
		builder.append("'" + pathAtencao + "'");
		builder.append("'" + pathComando + "'");
		builder.append("'" + pathContagem + "'");
		builder.append(");");

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
	 * Editar
	 */
	public int editar(int id, String perfil, int tempoDescansoCurto,
			int tempoDescansoLongo, int tempoAlongamento, String pathDescanso,
			String pathAlongamento, String pathAtencao, String pathComando,
			String pathContagem) {

		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("UPDATE config SET ");

		builder.append("perfil = '" + perfil + "', ");
		builder.append("tempo_descanso_curto = " + tempoDescansoCurto + ", ");
		builder.append("tempo_descanso_longo = " + tempoDescansoLongo + ", ");
		builder.append("tempo_alongamento = " + tempoAlongamento + ", ");
		builder.append("path_descanso = '" + pathDescanso + "', ");
		builder.append("path_alongamento = '" + pathAlongamento + "', ");
		builder.append("path_atencao = '" + pathAtencao + "', ");
		builder.append("path_comando = '" + pathComando + "', ");
		builder.append("path_contagem = '" + pathContagem + "' ");

		builder.append("WHERE id_config = " + id + ";");

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
	 * Excluir
	 */
	public int excluir(int id) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("DELETE FROM config WHERE id_config = " + id + ";");

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

	public Config getByPerfil(String perfil) {
		Config config = null;
		StringBuilder builder = new StringBuilder();
		ResultSet rs = null;

		builder.append("SELECT * FROM config WHERE perfil = '" + perfil + "'");
		try {
			Statement s = getConnection().createStatement();

			rs = s.executeQuery(builder.toString());

			config = new Config(rs.getString("perfil"),
					rs.getInt("tempo_descanso_curto"),
					rs.getInt("tempo_descanso_longo"),
					rs.getInt("tempo_alongamento"),
					rs.getString("path_descanso"),
					rs.getString("path_alongamento"),
					rs.getString("path_atencao"), 
					rs.getString("path_comando"),
					rs.getString("path_contagem"));

			rs.close();
			s.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return config;
	}

	public List<String> getPerfis() {
		ArrayList<String> perfis = new ArrayList<String>();
		StringBuilder builder = new StringBuilder();
		ResultSet rs = null;

		builder.append("SELECT perfil FROM config;");

		try {
			PreparedStatement ps = getConnection().prepareStatement(
					builder.toString());

			rs = ps.executeQuery();

			while (rs.next()) {
				perfis.add(rs.getString("perfil"));
			}

			rs.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return perfis;

	}

}
