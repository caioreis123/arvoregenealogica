package arvoregenealogica;

public class Filha extends Pessoa{

    public Filha(String nome){
        setNome(nome);
    }


	@Override
	public void setNome(String nome) {
		this.nome= "Sra. "+nome;
	}



}
