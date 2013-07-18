package controller;

import java.sql.Blob;

public class VozComando {
	private Integer id;
	private Movimento movimento;
	private Blob encodedData;
	private String fileName;

	public VozComando() {
		super();
	}
	
	public VozComando(Integer id) {
		super();
		this.id = id;
	}

	public VozComando(Integer id, Movimento movimento, Blob encodedData,
			String fileName) {
		super();
		this.id = id;
		this.movimento = movimento;
		this.encodedData = encodedData;
		this.fileName = fileName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Movimento getMovimento() {
		return movimento;
	}

	public void setMovimento(Movimento movimento) {
		this.movimento = movimento;
	}

	public Blob getEncodedData() {
		return encodedData;
	}

	public void setEncodedData(Blob encodedData) {
		this.encodedData = encodedData;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((encodedData == null) ? 0 : encodedData.hashCode());
		result = prime * result
				+ ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((movimento == null) ? 0 : movimento.hashCode());
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
		VozComando other = (VozComando) obj;
		if (encodedData == null) {
			if (other.encodedData != null)
				return false;
		} else if (!encodedData.equals(other.encodedData))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (movimento == null) {
			if (other.movimento != null)
				return false;
		} else if (!movimento.equals(other.movimento))
			return false;
		return true;
	}
}
