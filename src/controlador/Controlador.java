package controlador;

import java.util.List;

import ddd.ArteMarcial;
import ddd.Faixa;
import ddd.Movimento;

/**
 * TODO: 
 * 
 * Preciso de:
 * 
 * 	
 *  1) Reproduzir som
 *  
 *  
 *  O som já está gravado no Iphone.
 *  
 *  
 */
public class Controlador extends Thread {
	private List<Faixa> faixas;
	
	public Controlador(List<Faixa> faixas) {
		super();
		this.faixas = faixas;
		
		if(this.faixas == null)
			throw new RuntimeException("Faixas Nulas.");
	}
	
	@Override
	public void run() {
		
		for(int i=0; i<faixas.size(); i++) {
			/**
			 * TODO: REPRODUZIR SOM
			 */
			System.out.println("Arte Marcial: " + faixas.get(i).getArteMarcial().getDescricao());
			System.out.println("----------------------------------");
			System.out.println();
			System.out.println("Faixa: " + faixas.get(i).getDescricao());
			System.out.println();
			
			List<Movimento> movimentos = faixas.get(i).getMovimentos();
			
			for(int j=0; j<movimentos.size(); j++) {
				
				for(int repeticaoAtual=0; repeticaoAtual<movimentos.get(j).getQtdRepeticao(); repeticaoAtual++) {
					/**
					 * TODO: REPRODUZIR SOM
					 */
					System.out.println(movimentos.get(j).getDescricao());

					try {
						sleep(movimentos.get(j).getIntervaloSegundos() * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			
			try {
				sleep(5000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ArteMarcial arteMarcial = new ArteMarcial().getById(1);
		
		List<Faixa> faixasSelecionadas = arteMarcial.getTodasAsFaixas();		
		Controlador c = new Controlador(faixasSelecionadas);
		c.start();		
	}

}
