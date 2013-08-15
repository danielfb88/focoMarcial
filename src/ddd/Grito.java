package ddd;

import java.util.List;

import dao.GritoDAO;

/**
 * DDD Grito
 * 
 * @author Daniel Bonfim <daniel.fb88@gmail.com>
 * @since 15/08/2013
 * @version 1.0
 * 
 */
public class Grito {
	/**
	 * Id
	 */
	private int id;

	/**
	 * Endereço do arquivo de som do nome da Grito
	 */
	private String path;

	/**
	 * DAO da Grito
	 */
	private GritoDAO gritoDAO = new GritoDAO();

	public Grito() {
		super();
	}

	public Grito(int id) {
		super();
		this.id = id;
	}

	public Grito(Integer id, String path) {
		super();
		this.id = id;
		this.path = path;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Obtém todas as faixas desta Grito
	 * 
	 * @return List<Grito>
	 */
	public List<Grito> getGritos() {
		return gritoDAO.getGritos();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grito other = (Grito) obj;
		if (id != other.id)
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		return true;
	}

}
