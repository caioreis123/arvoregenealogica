package arvoregenealogica;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public abstract class Pessoa {
	
	protected String nome;
//	private Pessoa pai;
	protected ArrayList<Pessoa> descendentes=new ArrayList<>();
	protected ArrayList<Pessoa> ascendentes=new ArrayList<>();

	public void setNatimorto(Pessoa filho){
		filho.nome = "Natimorto " + Array.get(filho.nome.split(" "), 1);
	}


	public void cadastrarFilho(Pessoa filho){
		if ((filho instanceof Filho) && (this instanceof Filha)){
			if (new Random().nextBoolean()) {
				setNatimorto(filho);
			}
		}
		if((this instanceof Filho) && (this.descendentes.size()==1)){
			setNatimorto(filho);
		}
		descendentes.add(filho);
		ArrayList<Pessoa> ascendentesDoFilho = new ArrayList<>(ascendentes);
		ascendentesDoFilho.add(this);
		filho.ascendentes = ascendentesDoFilho;
	};
	
	public abstract void setNome(String nome);

	@Override
	public String toString() {
		return this.nome;
	}
	
	
}
