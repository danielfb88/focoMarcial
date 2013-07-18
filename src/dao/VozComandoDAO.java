package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.Movimento;
import controller.VozComando;
import util.DAO;

public class VozComandoDAO extends DAO {

	/**
	 * Adicionar VozComando
	 * 
	 * @param id_movimento
	 * @param encoded_data
	 * @param filename
	 * @return
	 */
	public int adicionar(Integer id_movimento, String encoded_data,
			String filename) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("INSERT INTO vozcomando (id_movimento, encoded_data, filename) VALUES ("
				+ id_movimento + ", " + encoded_data + ", " + filename + " );");

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
	 * Editar VozComando
	 * 
	 * @param id_vozComando
	 * @param id_movimento
	 * @param encoded_data
	 * @param filename
	 * @return
	 */
	public int editar(Integer id_vozComando, Integer id_movimento,
			String encoded_data, String filename) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("UPDATE TABLE artemarcial SET id_movimento = "
				+ id_movimento + ", encoded_data = " + encoded_data
				+ ", filename = " + filename + " WHERE id_vozComando = "
				+ id_vozComando + " ;");

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
	 * Excluir VozComando
	 * 
	 * @param id_vozComando
	 * @return
	 */
	public int excluir(Integer id_vozComando) {
		int linhasAfetadas = 0;
		StringBuilder builder = new StringBuilder();

		builder.append("DELETE FROM artemarcial WHERE id_vozComando = "
				+ id_vozComando + ";");

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
	 * Obtém VozComando pelo ID
	 * 
	 * @param id_vozcomando
	 * @return
	 */
	public VozComando getById(Integer id_vozcomando) {
		VozComando vozComando= null;
		StringBuilder builder = new StringBuilder();
		ResultSet rs = null;

		builder.append("SELECT * FROM vozcomando WHERE id_vozcomando = " + id_vozcomando + ";");
		try {
			PreparedStatement ps = getConnection().prepareStatement(
					builder.toString());

			rs = ps.executeQuery();
			
			vozComando = new VozComando(
					rs.getInt("id_vozcomando"), 
					new Movimento(rs.getInt("id_movimento")), 
					rs.getBlob("encoded_data"), 
					rs.getString("filename")
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

		return vozComando;
	}

}
