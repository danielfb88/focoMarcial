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
	private ArteMarcial arteMarcial;
	private List<Faixa> faixas;
	
	public Controlador(ArteMarcial arteMarcial, List<Faixa> faixas) {
		super();
		this.arteMarcial = arteMarcial;
		this.faixas = faixas;
		
		if(this.faixas == null)
			throw new RuntimeException("Faixas Nulas.");
	}
	
	@Override
	public void run() {
		
		this.reproduzirSom(this.arteMarcial.getVoz_path());
		this.exibirConsoleDestaque("ARTE MARCIAL", this.arteMarcial.getDescricao());
		
		// Início de cada faixa
		for(int i=0; i<faixas.size(); i++) {
			this.espere(5);
			
			this.reproduzirSom(faixas.get(i).getVoz_path());
			this.exibirConsoleDestaque("FAIXA", faixas.get(i).getDescricao());
			
			this.espere(4);
			
			// Início da sequência de movimentos
			List<Movimento> movimentos = faixas.get(i).getMovimentos();
			for(int j=0; j<movimentos.size(); j++) {
				this.espere(5);
				
				this.reproduzirSom(movimentos.get(j).getDescricao());
				System.out.println("\n NOME DO MOVIMENTO: " + movimentos.get(j).getDescricao());
				
				this.espere(5);

				// Grito em cada movimento
				int qtdRepeticaoMovimento = movimentos.get(j).getQtdRepeticao();
				int intervaloSegundosMovimento = movimentos.get(j).getIntervaloSegundos();
				
				for(int repeticaoAtual=0; repeticaoAtual<qtdRepeticaoMovimento; repeticaoAtual++) {					
					this.reproduzirSom("grito");
					System.out.println("GRITO!");
					
					this.espere(intervaloSegundosMovimento);
				}
			}
			
		}
	}
	
	/**
	 * Exibe a informação com destaque no console.
	 * 
	 * @param descricao Título
	 * @param valor Conteúdo
	 */
	private void exibirConsoleDestaque(String descricao, String valor) {
		System.out.println("----------------------------------");
		System.out.println(descricao + ": " + valor);
		System.out.println("----------------------------------");
	}
	
	/**
	 * Espera a quantidade especificada de tempo em segundos.
	 * @param segundos
	 */
	private void espere(int segundos) {
		try {
			System.out.println("*** Espere " + segundos + " segundo(s)... \n");
			sleep(segundos * 1000);
			
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * TODO: Desenvolver
	 * @param voz_path
	 */
	private void reproduzirSom(String voz_path) {
		
	}
	
	public static void main(String[] args) {
		ArteMarcial arteMarcial = new ArteMarcial().getById(1);
		
		List<Faixa> faixasSelecionadas = arteMarcial.getFaixasEntreGubs(5, 4);		
		Controlador c = new Controlador(arteMarcial, faixasSelecionadas);
		c.start();		
	}

}
