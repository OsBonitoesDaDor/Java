package common;

public class Brother {
	private String nome, numero;
	
	public Brother(String brother, String numero) {
		this.nome = brother;
		this.setNumero(numero);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}



}
