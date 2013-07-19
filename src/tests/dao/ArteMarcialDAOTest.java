package tests.dao;

import junit.framework.TestCase;

import org.junit.Test;

import dao.ArteMarcialDAO;
import ddd.ArteMarcial;

public class ArteMarcialDAOTest extends TestCase {
	
	@Test
	public void testInsert() {
		ArteMarcialDAO arteMarcialDAO = new ArteMarcialDAO();
		assertEquals(1, arteMarcialDAO.adicionar("Hapkido"));
		// TODO: Fazer thread esperar 2 segundos.
	}
	
	@Test
	public void testEdit() {
		ArteMarcialDAO arteMarcialDAO = new ArteMarcialDAO();
		assertEquals(1, arteMarcialDAO.editar(1, "Kung Fu"));
	}
	
	@Test
	public void testGetById() {
		ArteMarcialDAO arteMarcialDAO = new ArteMarcialDAO();
		ArteMarcial arteMarcial = arteMarcialDAO.getById(1);
		assertEquals("Kung Fu", arteMarcial.getDescricao());
	}
	
	@Test
	public void testDelete() {
		ArteMarcialDAO arteMarcialDAO = new ArteMarcialDAO();
		assertEquals(1, arteMarcialDAO.excluir(1));
	}

}
