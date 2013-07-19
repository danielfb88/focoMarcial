package tests.dao;

import org.junit.Test;

import dao.MovimentoDAO;
import ddd.Movimento;
import junit.framework.TestCase;

public class MovimentoDAOTest extends TestCase {

//	@Test
//	public void testInsert() {
//		MovimentoDAO movimentoDAO = new MovimentoDAO();
//		assertEquals(1, movimentoDAO.adicionar(1, "Aptchagui", "Chute frontal", 10, 1, "/home/daniel/aptchgui.wav"));
//		// TODO: Fazer thread esperar 2 segundos.
//	}
	
//	@Test
//	public void testEdit() {
//		MovimentoDAO movimentoDAO = new MovimentoDAO();
//		assertEquals(1, movimentoDAO.editar(1, 1, "Aptchaoligui", "Perna sobe reta e desce reta", 10, 1, "/home/daniel/aptchaoligui.wav"));
//	}
//	
//	@Test
//	public void testGetById() {
//		MovimentoDAO movimentoDAO = new MovimentoDAO();
//		Movimento movimento = movimentoDAO.getById(1);
//		assertEquals("Aptchaoligui", movimento.getDescricao());
//	}
//	
	@Test
	public void testDelete() {
		MovimentoDAO movimentoDAO = new MovimentoDAO();
		assertEquals(1, movimentoDAO.excluir(1));
	}

}
