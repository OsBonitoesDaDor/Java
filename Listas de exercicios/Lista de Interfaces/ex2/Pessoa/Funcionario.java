package ex2.Pessoa;

public class Funcionario extends Pessoa{

	private String funcao;
	
	public Funcionario(String nome, String funcao) {
		super(nome);
		this.funcao = funcao;
	}
	
	public void consultar(Cliente c){
		System.out.printf("%s, consultando %s no plano %s\n", this.getNome(), c.getNome(), c.getPlano());
	}
	
	public String getFuncao() {
		return funcao;
	}
	
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	@Override
	public String toString(){
		return String.format("Ola, eu sou %s , sou %s\n", this.getNome(), this.getFuncao());
	}

}
