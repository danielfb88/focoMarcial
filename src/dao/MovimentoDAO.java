package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.Faixa;
import controller.Movimento;
import controller.VozComando;
import util.DAO;

public class MovimentoDAO extends DAO {

	/**
	 * Adicionar movimento
	 * 
	 * @param id_faixa
	 * @param descricao
	 * @param observacao
	 * @param qtd_repeticao
	 * @param intervalo_segundos
	 * @return
	 */
	public int adicionar(Integer id_faixa, String descricao, String observacao,
			Integer qtd_repeticao, Integer intervalo_segundos) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("INSERT INTO movimento (id_faixa, descricao, observacao, qtd_repeticao, intervalo_segundos) VALUES ("
				+ id_faixa
				+ ", "
				+ descricao
				+ ", "
				+ observacao
				+ ", "
				+ qtd_repeticao + ", " + intervalo_segundos + ");");

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
	 * Editar movimento
	 * 
	 * @param id_movimento
	 * @param id_faixa
	 * @param descricao
	 * @param observacao
	 * @param qtd_repeticao
	 * @param intervalo_segundos
	 * @return
	 */
	public int editar(Integer id_movimento, Integer id_faixa, String descricao,
			String observacao, Integer qtd_repeticao, Integer intervalo_segundos) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("UPDATE TABLE movimento SET ");

		if (id_faixa != null) {
			builder.append("id_faixa = " + id_faixa + " ");
		}

		if (descricao != null) {
			builder.append("descricao = " + descricao + " ");
		}

		if (observacao != null) {
			builder.append("observacao = " + observacao + " ");
		}

		if (qtd_repeticao != null) {
			builder.append("qtd_repeticao = " + qtd_repeticao + " ");
		}

		if (intervalo_segundos != null) {
			builder.append("intervalo_segundos = " + intervalo_segundos + " ");
		}

		builder.append("WHERE id_movimento = " + id_movimento + ";");

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
	 * Excluir Movimento
	 * 
	 * @param id_movimento
	 * @return
	 */
	public int excluir(Integer id_movimento) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("DELETE FROM movimento WHERE id_faixa = " + id_movimento
				+ ");");

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
	 * Obtém o Movimento pelo ID
	 * 
	 * @param id_movimento
	 * @return
	 */
	public Movimento getById(Integer id_movimento) {
		Movimento movimento = null;
		StringBuilder builder = new StringBuilder();
		ResultSet rs = null;

		builder.append("SELECT * FROM movimento WHERE id_movimento = " + id_movimento + ";");
		try {
			PreparedStatement ps = getConnection().prepareStatement(
					builder.toString());

			rs = ps.executeQuery();
			
			movimento = new Movimento(
					rs.getInt("id_movimento"), 
					new Faixa(rs.getInt("id_faixa")), 
					rs.getString("descricao"), 
					rs.getString("observacao"), 
					rs.getInt("qtd_repeticao"), 
					rs.getInt("intervalo_segundos"), 
					new VozComando()
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

		return movimento;
	}

	/**
	 * Obtém Movimentos pelo Id da faixa
	 * 
	 * @param id_faixa
	 * @return
	 */
	public List<Movimento> getMovimentos(Integer id_faixa) {
		ArrayList<Movimento> movimentos = new ArrayList<Movimento>();
		StringBuilder builder = new StringBuilder();
		ResultSet rs = null;

		builder.append("SELECT * FROM movimento WHERE id_faixa = " + id_faixa
				+ ";");

		try {
			PreparedStatement ps = getConnection().prepareStatement(
					builder.toString());

			rs = ps.executeQuery();

			while (rs.next()) {
				movimentos
						.add(new Movimento(
								rs.getInt("id_movimento"),
								new Faixa(rs.getInt("id_faixa")), 
								rs.getString("descricao"), 
								rs.getString("observacao"), 
								rs.getInt("qtd_repeticao"), 
								rs.getInt("intervalo_segundos"),
								null
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

		return movimentos;

	}

}
