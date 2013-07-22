package tests.dao;

import junit.framework.TestCase;

import org.junit.Test;

import dao.FaixaDAO;
import ddd.Faixa;

public class FaixaDAOTest extends TestCase {

	@Test
	public void testInsert() {
		FaixaDAO faixaDAO = new FaixaDAO();
//		assertEquals(1, faixaDAO.adicionar(1, 10, "Branca"));
		// TODO: Fazer thread esperar 2 segundos.
	}
	
	@Test
	public void testEdit() {
		FaixaDAO faixaDAO = new FaixaDAO();
//		assertEquals(1, faixaDAO.editar(1, 220, 9, "Amarela"));
	}
	
	@Test
	public void testGetById() {
		FaixaDAO faixaDAO = new FaixaDAO();
		Faixa faixa = faixaDAO.getById(2);
		assertEquals("teste", faixa.getDescricao());
	}
	
	@Test
	public void testDelete() {
		FaixaDAO faixaDAO = new FaixaDAO();
		assertEquals(1, faixaDAO.excluir(2));
	}

}
