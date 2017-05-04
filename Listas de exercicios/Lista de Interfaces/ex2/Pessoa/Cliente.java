package ex2.Pessoa;

public class Cliente extends Pessoa {

	private String plano;

	public Cliente(String nome, String plano) {
		super(nome);
		this.plano = plano;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

}
