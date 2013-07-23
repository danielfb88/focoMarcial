package control;

import java.util.List;

import ddd.ArteMarcial;
import ddd.Faixa;

public class Controlador {
	
	public static void main(String[] args) {
		ArteMarcial arteMarcial = new ArteMarcial().getById(1);

		List<Faixa> faixasSelecionadas = arteMarcial.getFaixasEntreGubs(Integer.valueOf(args[0]), Integer.valueOf(args[1]));
//		List<Faixa> faixasSelecionadas = arteMarcial.getFaixasEntreGubs(10, 7);
		
		Aula a = new Aula(arteMarcial, faixasSelecionadas);
		Pause p = new Pause(a);
		
		a.start();
		p.start();		
	}

}
