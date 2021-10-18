package arvoregenealogica;

public class Filho extends Pessoa{

    public Filho(String nome){
        setNome(nome);
    }

//	@Override
//	public void cadastrarFilho(Pessoa filho) {
//
//	}

	@Override
	public void setNome(String nome) {
		this.nome = "Sr. "+ nome;
	}
}
